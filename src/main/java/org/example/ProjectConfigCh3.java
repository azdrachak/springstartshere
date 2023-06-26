package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "org.example.components")
public class ProjectConfigCh3 {
    @Bean
    public Parrot parrot() {
        Parrot p = new Parrot();
        p.setName("Koko");
        return p;
    }

    // wire beans directly
    @Bean(name = "personDirect")
    @Primary
    public Person personDirect() {
        Person p = new Person();
        p.setName("Ella");
        p.setParrot(parrot());
        return p;
    }

    @Bean(name = "personWithParam")
    public Person personWithParam(Parrot parrot) {
        Person p = new Person();
        p.setName("Ella");
        p.setParrot(parrot);
        return p;
    }
}
