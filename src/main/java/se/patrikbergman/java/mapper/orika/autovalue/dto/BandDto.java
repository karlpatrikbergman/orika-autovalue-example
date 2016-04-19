package se.patrikbergman.java.mapper.orika.autovalue.dto;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class BandDto {
    public abstract String getName();
    public abstract int getRockFactor();

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