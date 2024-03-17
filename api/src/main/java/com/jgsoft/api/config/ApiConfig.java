package com.jgsoft.api.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import java.util.Objects;

@Configuration
public class ApiConfig {
    private final Environment env;

    public ApiConfig(Environment env) {
        this.env = env;
    }

    @Bean
    @Primary
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .uriTemplateHandler(
                        new DefaultUriBuilderFactory(
                                Objects.requireNonNull(env.getProperty("url.externalAPI")
                                )
                        )
                )
                .build();
    }
}
