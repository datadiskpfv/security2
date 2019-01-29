package uk.co.datadisk.security2.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/")
    public String index(Authentication auth) {
        return "Spring Security In-memory example, User is " + auth.getName() + "\n\n"
                + " Auth Details: " + auth.toString();
    }
}
