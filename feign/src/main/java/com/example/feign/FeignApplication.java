package com.example.feign;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@EnableFeignClients
@SpringBootApplication
@EnableScheduling
public class FeignApplication {
    @Autowired
    private RequestToSimpleRest requestToSimpleRest;
    @Autowired
    private EurekaClient eurekaClient;

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }


    @Scheduled(fixedDelay = 5000)
    public void test() {
        System.out.println(requestToSimpleRest.greeting());
    }

}
