package se.patrikbergman.java.mapper.orika.autovalue.domain;

import com.google.auto.value.AutoValue;

@AutoValue
abstract class Band {
    abstract String name();
    abstract int rockFactor();

    static Builder builder() {
        return new AutoValue_Band.Builder();
    }

    @AutoValue.Builder
    abstract static class Builder {
        abstract Builder name(String value);
        abstract Builder rockFactor(int value);
        abstract Band build();
    }
}
