package com.tmsolution.settingsapi.configs;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigs {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public OpenAPI openAPIConfig() {

        final String securityScheme = "bearerAuth";

        return new OpenAPI()
                .info(new Info().title("Settings API")
                        .description("Settings API description")
                        .version("v0.0.1-SNAPSHOT")
                )
                .addSecurityItem(new SecurityRequirement()
                        .addList(securityScheme))
                .components(new Components()
                        .addSecuritySchemes(securityScheme,
                                new SecurityScheme()
                                        .name(securityScheme)
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        ))
                .externalDocs(new ExternalDocumentation()
                        .description("Settings API")
                        .url("https://github.com/TMExperimentals/SettingsApi/blob/master/README.md"));
    }


}
