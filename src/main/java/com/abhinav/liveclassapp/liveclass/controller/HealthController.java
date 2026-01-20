package com.abhinav.liveclassapp.liveclass.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Health check controller for container runtime tests.
 */
@RestController
public class HealthController {

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
