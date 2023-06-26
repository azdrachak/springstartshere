package org.example.components;

import org.springframework.stereotype.Component;

@Component
public class ParrotComponent {
    private String name = "Koko";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Parrot : '%s'".formatted(name);
    }
}
