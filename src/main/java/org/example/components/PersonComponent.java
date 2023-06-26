package org.example.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonComponent {
    private String name = "Ella Field";
    @Autowired
    private ParrotComponent parrot;

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
