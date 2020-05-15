package com.self.learning;

public record Person(String firstName, String secondName, int salary) {
    public Person {
        if(salary < 1) {
            throw new IllegalArgumentException("He can't work for free");
        }
        if(firstName.isEmpty() || secondName.isEmpty()) {
            throw new NullPointerException("A men does need a name. Valar Morghulis");
        }
    }

}
