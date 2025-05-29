package com.econcepcion.user.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("User Management API")
                        .description("API for managing users")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Elizabeth Concepcion")
                                .email("ingelizabethconcepcion@gmail.com")
                        )
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                )
                .externalDocs(new ExternalDocumentation()
                        .description("GitHub Repo: user-management")
                        .url("https://github.com/elizabethconcepcionyuden/user-management.git"));
    }
}
