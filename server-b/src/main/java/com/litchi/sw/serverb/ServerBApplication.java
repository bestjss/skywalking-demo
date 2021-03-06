package com.litchi.sw.serverb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ServerBApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerBApplication.class, args);
    }

}
