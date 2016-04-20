package se.patrikbergman.java.mapping;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.ObjectFactory;
import se.patrikbergman.java.bandapp.controller.dto.BandDto;
import se.patrikbergman.java.bandapp.service.domain.Band;

public class BandDtoFactory implements ObjectFactory<BandDto> {

    @Override
    public BandDto create(Object source, MappingContext mappingContext) {
        if (source instanceof Band) {
            Band band = (Band) source;
            return BandDto.builder()
                    .name(band.getName())
                    .rockFactor(band.getRockFactor())
                    .build();
        } else {
            throw new IllegalArgumentException("Source object must be of type " + Band.class.getSimpleName());
        }
    }
}
