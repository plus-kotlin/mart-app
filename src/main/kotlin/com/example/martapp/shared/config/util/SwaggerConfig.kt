package com.example.martapp.shared.config.util

import org.springdoc.core.GroupedOpenApi
import org.springframework.context.annotation.Bean


class SwaggerConfig {
    @Bean
    fun publicApi(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("com.example.janghj")
            .pathsToMatch("/**")
            .packagesToScan("com.example.janghj.web")
            .build()
        //        http://localhost:8080/swagger-ui.html
    }
}