package com.server.impala;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ImpalaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImpalaApplication.class, args);
    }

}
