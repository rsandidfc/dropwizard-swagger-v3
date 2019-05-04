dropwizard-swagger
==================
[![Build Status](https://travis-ci.org/smoketurner/dropwizard-swagger.svg?branch=master)](https://travis-ci.org/smoketurner/dropwizard-swagger)
[![Coverage Status](https://coveralls.io/repos/smoketurner/dropwizard-swagger/badge.svg?branch=master&service=github)](https://coveralls.io/github/smoketurner/dropwizard-swagger?branch=master)
[![Maven Central](https://img.shields.io/maven-central/v/com.smoketurner/dropwizard-swagger.svg?style=flat-square)](https://maven-badges.herokuapp.com/maven-central/com.smoketurner/dropwizard-swagger/)
[![GitHub license](https://img.shields.io/github/license/smoketurner/dropwizard-swagger.svg?style=flat-square)](https://github.com/smoketurner/dropwizard-swagger/tree/master)
[![Become a Patron](https://img.shields.io/badge/Patron-Patreon-red.svg)](https://www.patreon.com/bePatron?u=9567343)

A Dropwizard bundle that serves Swagger UI static content and loads Swagger endpoints. Swagger UI static content is taken from https://github.com/swagger-api/swagger-ui

Current version has been tested with Dropwizard 1.3.9 and Swagger 2.0.7 which supports OpenAPI 3 specifications

Note: if you come from previous versions there have been some changes in the way the bundle is configured, see details below.

License
-------

http://www.apache.org/licenses/LICENSE-2.0

Version matrix
--------------

 version | Dropwizard |Swagger API|Swagger UI
---------|------------|-----------|----------
  1.0.0  |   1.3.x    |   2.0.7   | v3.19.2

How to use it
-------------

* Add the Maven dependency (available in Maven Central)

```xml
<dependency>
    <groupId>com.fashiontrade</groupId>
    <artifactId>dropwizard-swagger-v3</artifactId>
    <version>1.0.0</version>
</dependency>
```


* Add the following to your Configuration class:

```java
public class YourConfiguration extends Configuration {

    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;
```

* Add the following your configuration yaml (this is the minimal configuration you need):

```yaml
prop1: value1
prop2: value2

# the only required property is resourcePackage, for more config options see below
swagger:
  resourcePackage: <a comma separated string of the packages that contain your @Api annotated resources>
```

* In your Application class:

```java
@Override
public void initialize(Bootstrap<YourConfiguration> bootstrap) {
    bootstrap.addBundle(new SwaggerBundle<YourConfiguration>() {
        @Override
        protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(YourConfiguration configuration) {
            return configuration.swaggerBundleConfiguration;
        }
    });
}
```

* As usual, add Swagger annotations to your resource classes and methods

* Open a browser and hit `http://localhost:<your_port>/swagger`

Additional Swagger configuration
--------------------------------

To see all the properties that can be used to customize Swagger see [SwaggerBundleConfiguration.java](src/main/java/io/federecio/dropwizard/swagger/SwaggerBundleConfiguration.java)

Contributors
------------

* Federico Recio [@federecio](http://twitter.com/federecio)
* Jochen Szostek [prefabsoft] (http://prefabsoft.com)
* Damien Raude-Morvan [drazzib] (https://github.com/drazzib)
* Marcel Stör [marcelstoer] (https://github.com/marcelstoer)
* Flemming Frandsen https://github.com/dren-dk
* Tristan Burch [tburch] (https://github.com/tburch)
* Matt Carrier [mattcarrier] (https://github.com/mattcarrier)
* Justin Plock [jplock] (https://github.com/jplock)
* Ian Rogers [IanRogers-LShift] (https://github.com/IanRogers-LShift)
* Mohamed Osama [oss92](https://github.com/oss92)
