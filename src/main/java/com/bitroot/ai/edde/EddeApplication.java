package com.bitroot.ai.edde;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan(
        {"com.bitroot.ai.edde.configuration"}
)
public class EddeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EddeApplication.class, args);
    }

}
