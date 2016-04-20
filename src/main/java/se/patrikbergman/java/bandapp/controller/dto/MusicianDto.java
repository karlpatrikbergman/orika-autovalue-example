package se.patrikbergman.java.bandapp.controller.dto;

/**
 * Basic "hand crafted" immutable java class for testing Orika mapping
 */
public class MusicianDto {
    private final String name;
    private final String familyName;

    public MusicianDto(String name, String familyName) {
        this.name = name;
        this.familyName = familyName;
    }

    public String getName() {
        return name;
    }

    public String getFamilyName() {
        return familyName;
    }

    @Override
    public String toString() {
        return "MusicianDto{" +
                "name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                '}';
    }
}
