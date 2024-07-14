package dias.spring.core;

import dias.spring.core.data.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PrimaryConfiguration {
    @Bean()
    @Primary
    Foo foo1() {
        return new Foo();
    }

    @Bean
    Foo foo2() {
        return new Foo();
    }
}
