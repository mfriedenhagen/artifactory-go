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

import com.github.mfriedenhagen.artifactorygo.model.MD5;
import com.github.mfriedenhagen.artifactorygo.model.Sha1;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;
import org.joda.time.DateTime;

/**
 * {@link ResponseHandler} which deserializes the given JSON response.
 *
 * @param <T> type of the deserialized answer
 * @author Mirko Friedenhagen
 */
public class JsonResponseHandler<T> extends StatusCodeCodeLessThanScMultipleChoicesResponseHandler<T> {

    /** clazz for deserialization. */
    private final Class<T> clazz;

    /**
     * @param clazz for deserialization.
     */
    public JsonResponseHandler(final Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
        final HttpEntity entity = returnEntityWhenStatusValid(response);
        final Gson gson = new GsonBuilder()
                .registerTypeAdapter(DateTime.class, new DateTimeDeserializer())
                .registerTypeAdapter(Sha1.class, new Sha1Deserializer())
                .registerTypeAdapter(MD5.class, new MD5Deserializer())
                .create();
        final String body = EntityUtils.toString(entity);
        return gson.fromJson(body, clazz);
    }
    
}
