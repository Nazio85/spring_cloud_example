package com.example.simplerestclient;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    @Lazy
    private List<EurekaClient> eurekaClient;

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/")
    public String greeting() throws UnknownHostException {
        final Application application = eurekaClient.get(0).getApplication(appName);
        return String.format(
                "Hello from '%s'!", application.getName() + " port="+ port);
    }
}
