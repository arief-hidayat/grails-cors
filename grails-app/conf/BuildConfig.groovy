/*
 * Copyright 2013 BrandsEye (http://www.brandseye.com/)
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

grails.project.work.dir = "target"

grails.project.dependency.resolution = {
    inherits "global"
    log "warn"

    repositories {
        grailsPlugins()
        grailsHome()
        mavenLocal()
        grailsCentral()
        mavenCentral()
    }

    dependencies {
//        test ":grails-test-suite-base:$grailsVersion"  // no version for 2.4.x
test ("org.grails:grails-test-suite-base:2.2.5") {
 excludes 'grails-spring', 'grails-test', 'grails', 'grails-bootstrap', 'groovy-all'
}
	test "org.grails:grails-spring:$grailsVersion"
	test "org.grails:grails-test:$grailsVersion"
	
        compile('org.springframework.security:spring-security-core:3.0.7.RELEASE') {
            transitive = false
        }
        compile('org.springframework.security:spring-security-web:3.0.7.RELEASE') {
			transitive = false
        }
    }

    plugins {
        compile ":webxml:1.4.1"
        build(":release:3.0.1", ":rest-client-builder:1.0.3") {
            export = false
        }
    }
}
