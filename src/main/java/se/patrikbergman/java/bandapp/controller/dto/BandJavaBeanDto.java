package se.patrikbergman.java.bandapp.controller.dto;

public class BandJavaBeanDto {
    private final String name;
    private final int rockFactor;

    public BandJavaBeanDto(String name, int rockFactor) {
        this.name = name;
        this.rockFactor = rockFactor;
    }

    public String getName() {
        return name;
    }

    public int getRockFactor() {
        return rockFactor;
    }
}
