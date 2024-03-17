package com.jgsoft.api.controller;

import com.jgsoft.api.response.HealthResponseDTO;
import com.jgsoft.api.service.HealthService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
public class HealthController {
    private final HealthService healthService;

    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }
    @GetMapping
    public HttpEntity<HealthResponseDTO> getHealthStatus() {
        return new ResponseEntity<>(healthService.getHealthStatusByAnotherApi(), HttpStatus.OK);
    }
}
