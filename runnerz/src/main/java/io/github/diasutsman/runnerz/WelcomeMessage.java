package io.github.diasutsman.runnerz;

import org.springframework.stereotype.Component;

@Component
public class WelcomeMessage {
    public void getMessage() {
        System.out.println("Hello World!");
    }
}
