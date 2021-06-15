package com.mini_builder.mini_builder.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.HttpAuthenticationScheme;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

import static java.util.Collections.singletonList;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket v1Api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/v1/**"))
                .build()
                .ignoredParameterTypes(AuthenticationPrincipal.class)
                .securitySchemes(singletonList(securityScheme()))
                .securityContexts(singletonList(securityContext()));
    }

    /**
     * scheme: bearer
     * bearerFormat: JWT
     * name: Authorization
     *
     * @return SecurityScheme
     */
    public SecurityScheme securityScheme() {
        return HttpAuthenticationScheme
                .JWT_BEARER_BUILDER
                .name("Authorization")
                .build();
    }

    /**
     * @return SecurityContext
     */
    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    /**
     * @return SecurityReference List
     */
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return singletonList(new SecurityReference("Authorization", authorizationScopes));
    }
}
