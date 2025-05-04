package com.ajay.springsecurity1.controller;


import com.ajay.springsecurity1.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SampleController {

    @Autowired
    SampleService service;
    @GetMapping("/login")
    public String method()
    {
      return  service.getSampleString();
    }

    @GetMapping("/lastLogin")
    public String getLastLogin() {
        return service.getLastLoginRequest();
    }

    @GetMapping("/lastFiveLogins")
    public String getLastFiveLogins() {
        return service.getLastFiveLoginRequests();
    }


}
