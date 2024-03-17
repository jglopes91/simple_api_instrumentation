package com.jgsoft.api.controller;

import com.jgsoft.api.request.RequestPayloadDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/receive")
public class ReceiveController {
    @PostMapping("/data")
    public HttpEntity<Void> receivePayload(@RequestBody RequestPayloadDTO payload) {
        System.out.println(payload.value());
        System.out.println(payload.age());
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
}
