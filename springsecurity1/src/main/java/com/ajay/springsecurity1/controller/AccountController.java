package com.ajay.springsecurity1.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @GetMapping("/myAccount")
    public String getAccountDetails() {
        return "Here are the accounts details from the DB";
    }
}
