package se.patrikbergman.java.mapper.orika.autovalue.domain;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Band {
    public abstract String getName();
    public abstract int getRockFactor();

    public static Builder builder() {
        return new AutoValue_Band.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder name(String value);
        public abstract Builder rockFactor(int value);
        public abstract Band build();
    }
}
