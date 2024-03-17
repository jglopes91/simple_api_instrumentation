package com.jgsoft.api.response;

public record HealthResponseDTO (
        String status,
        Integer httpStatusCode
) {}