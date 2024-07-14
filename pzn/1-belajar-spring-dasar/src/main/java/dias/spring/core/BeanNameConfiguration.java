package dias.spring.core;

import dias.spring.core.data.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanNameConfiguration {
    @Bean(value = "fooFirst")
    @Primary
    Foo foo1() {
        return new Foo();
    }

    @Bean(value = "fooSecond")
    Foo foo2() {
        return new Foo();
    }
}
