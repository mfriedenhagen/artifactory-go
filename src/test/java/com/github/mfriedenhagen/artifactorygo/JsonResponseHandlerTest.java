/**
 * Copyright 1&1 Internet AG, https://github.com/1and1/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.mfriedenhagen.artifactorygo;

import com.github.mfriedenhagen.artifactorygo.model.ArtifactoryStorage;
import com.github.mfriedenhagen.artifactorygo.model.SearchResults;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpResponseException;
import org.apache.http.message.BasicStatusLine;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Mirko Friedenhagen
 */
public class JsonResponseHandlerTest {

    final JsonResponseHandler<SearchResults> sut = new JsonResponseHandler<SearchResults>(SearchResults.class);
    final HttpResponse mockedResponse = mock(HttpResponse.class);

    /**
     * Test of handleResponse method, of class JsonResponseHandler.
     */
    @Test(expected = HttpResponseException.class)
    public void testHandleResponseBadStatusCode() throws Exception {
        final BasicStatusLine statusLine = new BasicStatusLine(HttpVersion.HTTP_1_1, HttpStatus.SC_MULTIPLE_CHOICES, "Multiple Choices");
        when(mockedResponse.getStatusLine()).thenReturn(statusLine);
        sut.handleResponse(mockedResponse);
    }

    /**
     * Test of handleResponse method, of class JsonResponseHandler.
     */
    @Test
    public void testHandleResponse() throws Exception {
        final BasicStatusLine statusLine = new BasicStatusLine(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, "OK");
        when(mockedResponse.getStatusLine()).thenReturn(statusLine);
        final HttpEntity mockedEntity = mock(HttpEntity.class);
        when(mockedEntity.getContent()).thenReturn(JsonResponseHandlerTest.class.getResourceAsStream("/junit.json"));
        when(mockedResponse.getEntity()).thenReturn(mockedEntity);
        final SearchResults checksumResults = sut.handleResponse(mockedResponse);
        final ArtifactoryStorage checksumResult = checksumResults.results.get(0);
        assertEquals(
                "http://localhost:8081/artifactory/api/storage/repo1-cache/junit/junit/4.11/junit-4.11.pom",
                checksumResult.uri.toString());
        assertEquals(
                "http://localhost:8081/artifactory/repo1-cache/junit/junit/4.11/junit-4.11.pom",
                checksumResult.downloadUri.toString());
    }
}
