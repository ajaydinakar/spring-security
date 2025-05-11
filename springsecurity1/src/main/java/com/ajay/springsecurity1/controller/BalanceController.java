package com.ajay.springsecurity1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
    @GetMapping("/myBalance")
    public String getBalanceDetails() {
        return "Here are the balances details from the DB";
    }
}
