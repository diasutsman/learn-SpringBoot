package io.github.diasutsman.runnerz;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.diasutsman.runnerz.run.Location;
import io.github.diasutsman.runnerz.run.Run;
import io.github.diasutsman.runnerz.run.RunRepository;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // * Run After application runned
    // @Bean
    // CommandLineRunner runner(RunRepository runRepository) {
    //     return args -> {
    //         Run run = new Run(1, "First Run",
    //                 LocalDateTime.now(),
    //                 LocalDateTime.now().plus(1, ChronoUnit.HOURS),
    //                 5,
    //                 Location.OUTDOOR);

    //         runRepository.create(run);
    //     };
    // }
}
