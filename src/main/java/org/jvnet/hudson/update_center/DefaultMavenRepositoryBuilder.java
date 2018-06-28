/**
 * The MIT License
 *
 * Copyright (c) 2011, Jerome Lacoste
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.jvnet.hudson.update_center;

import org.kohsuke.args4j.Option;

import java.net.URL;

public class DefaultMavenRepositoryBuilder {

    @Option(name="-repositoryId",
            usage="Specify an id of the maven repository.")
    public String repositoryId = "public";

    @Option(name="-repositoryUrl",
            usage="Specify an URL of the maven repository.")
    public String repositoryUrl = "http://repo.jenkins-ci.org/public/";

    @Option(name="-downloadUrl",
            usage="Specify an URL of the download site.")
    public String downloadUrl = "http://updates.jenkins-ci.org/download/";

    public DefaultMavenRepositoryBuilder () {
        
    }
    
    public static MavenRepositoryImpl createStandardInstance() throws Exception {
        return new DefaultMavenRepositoryBuilder().createInstance();
    }

    public MavenRepositoryImpl createInstance() throws Exception {
        MavenRepositoryImpl instance = new MavenRepositoryImpl(new URL(downloadUrl));
        instance.addRemoteRepository(repositoryId, new URL(repositoryUrl));

        return instance;
    }
}
