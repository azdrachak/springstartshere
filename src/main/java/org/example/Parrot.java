package org.example;

public class Parrot {
    public Parrot() {
        System.out.println("Parrot created");
    }

    private String name;

    @Override
    public String toString() {
        return "Parrot : " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
