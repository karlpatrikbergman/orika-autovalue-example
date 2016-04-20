package se.patrikbergman.java.bandapp.service.domain;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Band {
//    public static Band create(String name, int rockFactor) {
//        return new AutoValue_Band(name, rockFactor);
//    }

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
