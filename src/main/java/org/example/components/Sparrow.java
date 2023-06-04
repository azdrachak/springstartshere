package org.example.components;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Sparrow {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void init() {
        this.name = "Twit";
    }
}
