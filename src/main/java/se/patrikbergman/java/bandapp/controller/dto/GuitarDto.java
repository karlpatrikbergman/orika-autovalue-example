package se.patrikbergman.java.bandapp.controller.dto;

public class GuitarDto extends AbstractInstrumentDto {
    private String name;

    public GuitarDto(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "GuitarDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
