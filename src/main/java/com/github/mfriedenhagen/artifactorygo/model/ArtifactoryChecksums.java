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

/**
 *
 * @author Mirko Friedenhagen <mirko.friedenhagen@1und1.de>
 */
public class ArtifactoryChecksums {

    private Sha1 sha1;
    
    private MD5 md5;

    /**
     * @return the sha1
     */
    public Sha1 getSha1() {
        return sha1;
    }

    /**
     * @param sha1 the sha1 to set
     */
    void setSha1(Sha1 sha1) {
        this.sha1 = sha1;
    }

    /**
     * @return the md5
     */
    public MD5 getMd5() {
        return md5;
    }

    /**
     * @param md5 the md5 to set
     */
    void setMd5(MD5 md5) {
        this.md5 = md5;
    }
}
