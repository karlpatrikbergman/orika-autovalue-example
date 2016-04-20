package se.patrikbergman.java.bandapp.controller.dto;

/**
 * Orika need a public all args constructor, at least by default.
 * --> static factory method does not work out of the box
 */
public class BrandDto {
    private final String name;

    public BrandDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "BrandDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
