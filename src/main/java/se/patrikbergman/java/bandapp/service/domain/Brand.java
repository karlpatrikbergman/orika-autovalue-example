package se.patrikbergman.java.bandapp.service.domain;

/**
 * Orika need a public all args constructor, at least by default.
 * --> static factory method does not work out of the box
 */
public class Brand {
    private final String name;

    public Brand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "name='" + name + '\'' +
                '}';
    }
}
