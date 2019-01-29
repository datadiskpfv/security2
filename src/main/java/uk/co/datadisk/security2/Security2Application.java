package uk.co.datadisk.security2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Security2Application {

    public static void main(String[] args) {
        SpringApplication.run(Security2Application.class, args);
    }

}

