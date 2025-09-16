package com.sevencows.business.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "SevenCows Business API",
                version = "1.0",
                description = "API documentation",
                contact = @Contact(
                        name = "Marcelo Paschoal",
                        email = "marcelo.hlp@outlook.com"
                )
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080",
                description = "Local server"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class SwaggerConfig {
}
