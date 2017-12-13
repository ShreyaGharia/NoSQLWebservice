package com.target.myRetail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * Created by Shreya on 12/12/2017.
 */
@SpringBootApplication
@EnableFeignClients
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class MyRetailRunner {
    public static void main(String[] args) {
        SpringApplication.run(MyRetailRunner.class, args);
    }
}
