/*
 * Copyright © 2021 Ossterdam (mohamed.o.alnagdy@gmail.com)
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
/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * <p>http://www.apache.org/licenses/LICENSE-2.0
 *
 * <p>Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ossterdam.dropwizard.swagger;

import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import io.restassured.RestAssured;
import org.eclipse.jetty.http.HttpStatus;
import org.hamcrest.core.StringContains;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;

public class DefaultServerWithContactTest extends DropwizardTest {

  @ClassRule
  public static final DropwizardAppRule<TestConfiguration> RULE =
      new DropwizardAppRule<TestConfiguration>(
          TestApplication.class, ResourceHelpers.resourceFilePath("test-default-contact.yaml"));

  public DefaultServerWithContactTest() {
    super(RULE.getLocalPort(), "/");
  }

  @Test
  @Ignore("passes when ran standalone, but fails inside the suite")
  public void swaggerHasContactInfo() throws Exception {
    RestAssured.expect()
        .statusCode(HttpStatus.OK_200)
        .body(
            StringContains.containsString("\"name\":\"test-contact-info\""),
            StringContains.containsString("\"email\":\"test-contact-email@test.com\""),
            StringContains.containsString("\"url\":\"test-url.contact.com\""))
        .when()
        .get(Path.from(basePath, "swagger.json"));
  }
}
