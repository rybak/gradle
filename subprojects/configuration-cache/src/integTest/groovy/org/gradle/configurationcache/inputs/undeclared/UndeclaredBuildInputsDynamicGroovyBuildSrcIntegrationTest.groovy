/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.configurationcache.inputs.undeclared

import com.gradle.enterprise.testing.annotations.LocalOnly

@LocalOnly(because = "https://github.com/gradle/gradle-private/issues/3821")
class UndeclaredBuildInputsDynamicGroovyBuildSrcIntegrationTest extends AbstractUndeclaredBuildInputsIntegrationTest implements GroovyPluginImplementation {
    @Override
    String getLocation() {
        return "Plugin class 'SneakyPlugin'"
    }

    @Override
    void buildLogicApplication(BuildInputRead read) {
        dynamicGroovyPlugin(file("buildSrc/src/main/groovy/SneakyPlugin.groovy"), read)
        buildFile << """
            apply plugin: SneakyPlugin
        """
    }
}
