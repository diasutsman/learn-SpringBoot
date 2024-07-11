package io.github.diasutsman.runnerz;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import io.github.diasutsman.runnerz.run.Location;
import io.github.diasutsman.runnerz.run.Run;
import io.github.diasutsman.runnerz.user.User;
import io.github.diasutsman.runnerz.user.UserHttpClient;
import io.github.diasutsman.runnerz.user.UserRestClient;
import io.github.diasutsman.runnerz.run.JDBCClientRunRepository;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    UserHttpClient userHttpClient() {
        // * Set base url for users api
        RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com/");
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(restClient)).build();

        return httpServiceProxyFactory.createClient(UserHttpClient.class);
    }

    // * Run After application runned
    @Bean
    CommandLineRunner runner(UserHttpClient client) {
        return args -> {
            System.out.println(client.findAll());

            User user = client.findById(1);

            System.out.println(user);
        };
    }
}
