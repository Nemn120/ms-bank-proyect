package com.aforo255.apptransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ApptransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApptransactionApplication.class, args);
    }

}
