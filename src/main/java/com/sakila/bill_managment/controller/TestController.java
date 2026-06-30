package com.sakila.bill_managment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String test(){
        return "Bill Management API is Running.....";
    }

    @GetMapping("/api/test")
    public String successTest() {
        return "API test success";
    }
}
