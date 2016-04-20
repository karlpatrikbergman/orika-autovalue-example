package se.patrikbergman.java.bandapp.controller.dto;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class BandDto {
    public abstract String getName();
    public abstract int getRockFactor();

//    public static BandDto create(String name, int rockFactor) {
//        return new AutoValue_BandDto(name, rockFactor);
//    }

    public static Builder builder() {
        return new AutoValue_BandDto.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder name(String value);
        public abstract Builder rockFactor(int value);
        public abstract BandDto build();
    }
}