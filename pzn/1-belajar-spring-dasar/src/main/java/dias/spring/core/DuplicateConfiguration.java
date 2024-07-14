package dias.spring.core;

import dias.spring.core.data.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DuplicateConfiguration {
    @Bean
    Foo foo1() {
        return new Foo();
    }

    @Bean
    Foo foo2() {
        return new Foo();
    }
}
