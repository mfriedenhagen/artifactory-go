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

    private URL uri;
    private URL downloadUri;
    private URL metadataUri;
    private String repo;
    private String path;
    private String createdBy;
    private String modifiedBy;
    private ArtifactoryChecksums checksums;
    private ArtifactoryChecksums originalChecksums;
    private String mimeType;
    private long size;
    private DateTime created;
    private DateTime lastModified;
    private DateTime lastUpdated;

    /**
     * @return the uri
     */
    public URL getUri() {
        return uri;
    }

    /**
     * @param uri the uri to set
     */
    public void setUri(URL uri) {
        this.uri = uri;
    }

    /**
     * @return the downloadUri
     */
    public URL getDownloadUri() {
        return downloadUri;
    }

    /**
     * @param downloadUri the downloadUri to set
     */
    public void setDownloadUri(URL downloadUri) {
        this.downloadUri = downloadUri;
    }

    /**
     * @return the metadataUri
     */
    public URL getMetadataUri() {
        return metadataUri;
    }

    /**
     * @param metadataUri the metadataUri to set
     */
    public void setMetadataUri(URL metadataUri) {
        this.metadataUri = metadataUri;
    }

    /**
     * @return the repo
     */
    public String getRepo() {
        return repo;
    }

    /**
     * @param repo the repo to set
     */
    public void setRepo(String repo) {
        this.repo = repo;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy the createdBy to set
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return the modifiedBy
     */
    public String getModifiedBy() {
        return modifiedBy;
    }

    /**
     * @param modifiedBy the modifiedBy to set
     */
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    /**
     * @return the checksums
     */
    public ArtifactoryChecksums getChecksums() {
        return checksums;
    }

    /**
     * @param checksums the checksums to set
     */
    public void setChecksums(ArtifactoryChecksums checksums) {
        this.checksums = checksums;
    }

    /**
     * @return the originalChecksums
     */
    public ArtifactoryChecksums getOriginalChecksums() {
        return originalChecksums;
    }

    /**
     * @param originalChecksums the originalChecksums to set
     */
    public void setOriginalChecksums(ArtifactoryChecksums originalChecksums) {
        this.originalChecksums = originalChecksums;
    }

    /**
     * @return the mimeType
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * @param mimeType the mimeType to set
     */
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    /**
     * @return the size
     */
    public long getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(long size) {
        this.size = size;
    }

    /**
     * @return the created
     */
    public DateTime getCreated() {
        return created;
    }

    /**
     * @param created the created to set
     */
    public void setCreated(DateTime created) {
        this.created = created;
    }

    /**
     * @return the lastModified
     */
    public DateTime getLastModified() {
        return lastModified;
    }

    /**
     * @param lastModified the lastModified to set
     */
    public void setLastModified(DateTime lastModified) {
        this.lastModified = lastModified;
    }

    /**
     * @return the lastUpdated
     */
    public DateTime getLastUpdated() {
        return lastUpdated;
    }

    /**
     * @param lastUpdated the lastUpdated to set
     */
    public void setLastUpdated(DateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
