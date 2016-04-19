package se.patrikbergman.java.mapper.orika.autovalue.dto;

import com.google.auto.value.AutoValue;

@AutoValue
abstract class BandDto {
    abstract String name();
    abstract int rockValue();

    static Builder builder() {
        return new AutoValue_BandDto.Builder();
    }

    @AutoValue.Builder
    abstract static class Builder {
        abstract Builder name(String value);
        abstract Builder rockValue(int value);
        abstract BandDto build();
    }
}