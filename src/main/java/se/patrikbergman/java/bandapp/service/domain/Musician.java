package se.patrikbergman.java.bandapp.service.domain;

/**
 * Basic "hand crafted" immutable java class for testing Orika mapping
 */
public class Musician {
    private final String name;
    private final String surName;

    public Musician(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    @Override
    public String toString() {
        return "Musician{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }
}
