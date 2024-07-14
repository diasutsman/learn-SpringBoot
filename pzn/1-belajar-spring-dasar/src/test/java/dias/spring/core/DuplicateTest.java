package dias.spring.core;

import dias.spring.core.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DuplicateTest {

    @Test
    void duplicateTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DuplicateConfiguration.class);
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> {
            Foo foo1 = applicationContext.getBean(Foo.class);
        });


    }

    @Test
    void getBean() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DuplicateConfiguration.class);
        Foo foo1 = applicationContext.getBean("foo1",Foo.class);
        Foo foo2 = applicationContext.getBean("foo2",Foo.class);

        Assertions.assertNotSame(foo1, foo2);
    }

}
