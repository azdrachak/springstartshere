package org.example;

import org.example.components.Sparrow;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        // get beans by name/value
        Parrot p = context.getBean("koko", Parrot.class);
        System.out.println(p.getName());
        p = context.getBean("miki", Parrot.class);
        System.out.println(p.getName());
        p = context.getBean("riki", Parrot.class);
        System.out.println(p.getName());

        // get default bean from context
        p = context.getBean(Parrot.class);
        System.out.println(p.getName());

        // bean returns String
        String s = context.getBean(String.class);
        System.out.println(s);

        // bean returns integer
        Integer n = context.getBean(Integer.class);
        System.out.println(n);

        // get component bean with PostConstruct
        Sparrow sparrow2 = context.getBean(Sparrow.class);
        System.out.println(sparrow2.getName());

        // get component bean
        Sparrow sparrow1 = context.getBean(Sparrow.class);
        sparrow1.setName("Chirp");
        System.out.println(sparrow1.getName());

    }
}