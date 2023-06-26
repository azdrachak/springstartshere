package org.example.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonComponentWithConstructor {
    private String name = "Ella Constructor";
    private final ParrotComponent parrot;

    @Autowired
    public PersonComponentWithConstructor(ParrotComponent parrot) {
        this.parrot = parrot;
    }

    @Override
    public String toString() {
        return "Parrot : " + name;
    }

    public String getName() {
        return name;
    }

    public ParrotComponent getParrot() {
        return parrot;
    }

    public void setName(String name) {
        this.name = name;
    }
}
