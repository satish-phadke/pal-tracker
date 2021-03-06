package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

   // @Value("${WELCOME_MESSAGE}")
    private String welcomeMessage;

    public WelcomeController(@Value("${WELCOME_MESSAGE}") String message ){
        welcomeMessage=message;
    }

    @GetMapping("/")
    public String sayHello() {
        return welcomeMessage;
    }
}
