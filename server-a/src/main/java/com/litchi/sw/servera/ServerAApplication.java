package com.litchi.sw.servera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServerAApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerAApplication.class, args);
    }

}
