package org.example;

import org.example.components.PersonComponent;
import org.example.components.PersonComponentWithConstructor;
import org.example.components.Sparrow;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
//        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
//        chapter2(context);

        var context = new AnnotationConfigApplicationContext(ProjectConfigCh3.class);
        chapter3(context);
    }

    public static void chapter2(AnnotationConfigApplicationContext context) {
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

        // add bean to context programmatically
        Parrot parrotP = new Parrot(); //create required instance to add to context
        parrotP.setName("Kiki");
        Supplier<Parrot> parrotSupplier = () -> parrotP;
        context.registerBean("parrotP", Parrot.class, parrotSupplier); // add bean to context
        p = context.getBean("parrotP", Parrot.class);
        System.out.println(p.getName());
    }

    public static void chapter3(AnnotationConfigApplicationContext context) {
//        Person person = context.getBean("personDirect", Person.class);
        Person person = context.getBean("personWithParam", Person.class);
        Parrot parrot = context.getBean(Parrot.class);
        System.out.println("Person's name: " + person.getName());
        System.out.println("Parrot's name: " + parrot.getName());
        System.out.println("Person's parrot: " + person.getParrot());
        System.out.println("---\nUsing component annotation and autowired\n---");
        PersonComponent personComponent = context.getBean(PersonComponent.class);
        System.out.println("Person's name: " + personComponent.getName());
        System.out.println("Person's parrot: " + personComponent.getParrot().getName());
        System.out.println("---\nUsing component annotation and autowired on constructor\n---");
        PersonComponentWithConstructor personCWC = context.getBean(PersonComponentWithConstructor.class);
        System.out.println("Person's name: " + personCWC.getName());
        System.out.println("Person's parrot: " + personCWC.getParrot().getName());
    }
}