package org.softwaretechnologies.animals;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public String sound() {
        return "woof";
    }
}