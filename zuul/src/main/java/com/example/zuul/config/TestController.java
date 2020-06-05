package com.example.zuul.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class TestController {

    @GetMapping("/")
    public String index() {
        return "Main success";
    }

    @RequestMapping(value = "/enter")
    public Principal user(Principal principal) {
        return principal;
    }
}
