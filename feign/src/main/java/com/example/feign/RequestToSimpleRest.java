package com.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("simple-rest-client")
public interface RequestToSimpleRest {

    @RequestMapping("/")
    String greeting();
}
