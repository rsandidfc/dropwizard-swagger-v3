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

import com.idfconnect.tools.dropwizard.swagger.SwaggerBundle;
import com.idfconnect.tools.dropwizard.swagger.SwaggerBundleConfiguration;
import com.idfconnect.tools.dropwizard.swagger.SwaggerViewConfiguration;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TestApplicationWithApiSelectorDisabled extends Application<TestConfiguration> {

  @Override
  public void initialize(Bootstrap<TestConfiguration> bootstrap) {
    bootstrap.addBundle(
        new SwaggerBundle<TestConfiguration>() {
          @Override
          protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(
              TestConfiguration configuration) {
            SwaggerBundleConfiguration swaggerBundleConfiguration =
                new SwaggerBundleConfiguration();
            swaggerBundleConfiguration.setResourcePackage("com.ossterdam.dropwizard.swagger");
            SwaggerViewConfiguration viewConfig = new SwaggerViewConfiguration();
            viewConfig.setShowApiSelector(false);
            swaggerBundleConfiguration.setSwaggerViewConfiguration(viewConfig);
            return swaggerBundleConfiguration;
          }
        });
  }

  @Override
  public void run(TestConfiguration configuration, Environment environment) throws Exception {
    environment.jersey().register(new TestResource());
  }
}
