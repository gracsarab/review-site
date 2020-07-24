package com.sample.secondtry;

import org.springframework.stereotype.Component;

@Component //or @Service, this is a bean.
public class WelcomeService {
    public String retrieveWelcomeMessage() {
        return "home";
    }
}
