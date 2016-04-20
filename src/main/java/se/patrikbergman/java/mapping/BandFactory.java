package se.patrikbergman.java.mapping;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.ObjectFactory;
import se.patrikbergman.java.bandapp.controller.dto.BandDto;
import se.patrikbergman.java.bandapp.service.domain.Band;

public class BandFactory implements ObjectFactory<Band> {

    @Override
    public Band create(Object source, MappingContext mappingContext) {
        if (source instanceof BandDto) {
            BandDto bandDto = (BandDto) source;
            return Band.builder()
                    .name(bandDto.getName())
                    .rockFactor(bandDto.getRockFactor())
                    .build();
        } else {
            throw new IllegalArgumentException("Source object must be of type " + BandDto.class.getSimpleName());
        }
    }
}
