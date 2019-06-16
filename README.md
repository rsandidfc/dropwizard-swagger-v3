dropwizard-swagger-v3
==================

A Dropwizard bundle that serves Swagger UI static content and loads Swagger endpoints. Swagger UI static content is taken from https://github.com/swagger-api/swagger-ui

Current version has been tested with Dropwizard 1.3.9 and Swagger 2.0.7 which supports OpenApi 3.0 specifications

Requirements
--------------
* Dropwizard 1.3.x
* Swagger API 2.0.7
* Swagger UI 3.19.2

Usage
-------------

* Add the Maven dependency (available in Maven Central)

```xml
<dependency>
    <groupId>com.ossterdam</groupId>
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
  resourcePackage: <a comma separated string of the packages that contain your @OpenAPIDefinition annotated resources>
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

* To see all the properties that can be used to customize Swagger UI see [SwaggerBundleConfiguration.java](src/main/java/com/ossterdam/dropwizard/swagger/SwaggerBundleConfiguration.java)
