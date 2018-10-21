package com.alex.zuulexample.zuulgateway;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class SwaggerConfig implements SwaggerResourcesProvider {

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList();
        resources.add(this.swaggerResource("user-service", "/api/users/v2/api-docs", "2.0"));
        return resources;
    }

    private SwaggerResource swaggerResource(String name,
                                            String url,
                                            String swaggerVersion) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setUrl(url);
        swaggerResource.setSwaggerVersion(swaggerVersion);
        return swaggerResource;
    }
}
