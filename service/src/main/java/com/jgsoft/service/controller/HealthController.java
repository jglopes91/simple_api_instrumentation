package com.jgsoft.service.controller;

import com.jgsoft.service.response.Response;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
public class HealthController {
    @GetMapping()
    public HttpEntity<Response> getDefaultResposne() {
        return new ResponseEntity<>(new Response("UP"), HttpStatus.OK);
    }
}
