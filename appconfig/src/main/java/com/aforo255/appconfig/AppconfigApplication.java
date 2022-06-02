package com.aforo255.appconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class AppconfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppconfigApplication.class, args);
    }

}
