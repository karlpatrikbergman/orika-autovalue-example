package se.patrikbergman.java.bandapp.service.domain;

/**
 * TODO: Add list of guitar-strings
 */
public class Guitar extends AbstractInstrument {
    private String name;

    public Guitar(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
