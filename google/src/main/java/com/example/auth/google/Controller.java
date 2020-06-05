package com.example.auth.google;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class Controller {
    @RequestMapping(value = "/")
    public Principal info(Principal principal) {
        return principal;
    }
    @RequestMapping(value = "/enter")
    public Principal user(Principal principal) {
        return principal;
    }
}
