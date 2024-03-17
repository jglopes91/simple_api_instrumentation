package com.jgsoft.api.service;

import com.jgsoft.api.response.HealthAPIResponseDTO;
import com.jgsoft.api.response.HealthResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HealthService {
    private final RestTemplate httpClient;

    public HealthService(RestTemplate httpClient) {
        this.httpClient = httpClient;
    }

    public HealthResponseDTO getHealthStatusByAnotherApi() {
        HealthAPIResponseDTO response = httpClient.getForObject("/health", HealthAPIResponseDTO.class);
        return new HealthResponseDTO(
                response.status(),
                HttpStatus.OK.value()
        );
    }
}
