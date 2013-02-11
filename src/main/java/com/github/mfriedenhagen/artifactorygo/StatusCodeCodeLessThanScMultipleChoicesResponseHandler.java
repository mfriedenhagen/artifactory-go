/**
 * Copyright 1&1 Internet AG, https://github.com/1and1/
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.github.mfriedenhagen.artifactorygo;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

/**
 * {@link ResponseHandler} which checks that the returncode is in the range of 200 < rc < 300.
 *
 * @param <T> type of the deserialized answer
 * @author Mirko Friedenhagen
 */
public abstract class StatusCodeCodeLessThanScMultipleChoicesResponseHandler<T> implements ResponseHandler<T> {

    /**
     * Checks that the returncode is in the range of 200 < rc < 300.
     *
     * @param response whose rc is validated.
     * @return the entity of the response.
     * @throws IOException when the rc > 300 and swallowing the response body has a problem..
     */
    protected final HttpEntity returnEntityWhenStatusValid(HttpResponse response) throws IOException {
        final StatusLine statusLine = response.getStatusLine();
        final HttpEntity entity = response.getEntity();
        if (statusLine.getStatusCode() >= HttpStatus.SC_MULTIPLE_CHOICES) {
            EntityUtils.consume(entity);
            throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
        }
        return entity;
    }
}
