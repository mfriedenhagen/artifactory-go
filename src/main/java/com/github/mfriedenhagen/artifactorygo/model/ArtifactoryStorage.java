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
package com.github.mfriedenhagen.artifactorygo.model;

import java.net.URL;
import org.joda.time.DateTime;

/**
 *
 * @author Mirko Friedenhagen <mirko.friedenhagen@1und1.de>
 */
public class ArtifactoryStorage {

    public URL uri;
    public URL downloadUri;
    public URL metadataUri;
    public String repo;
    public String path;
    public String createdBy;
    public String modifiedBy;
    public ArtifactoryChecksums checksums;
    public ArtifactoryChecksums originalChecksums;
    public String mimeType;
    public long size;
    public DateTime created;
    public DateTime lastModified;
    public DateTime lastUpdated;
}
