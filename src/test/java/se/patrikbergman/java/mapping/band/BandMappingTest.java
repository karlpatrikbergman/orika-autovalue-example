package se.patrikbergman.java.mapping.band;

import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.Before;
import org.junit.Test;
import se.patrikbergman.java.bandapp.controller.dto.BandDto;
import se.patrikbergman.java.bandapp.controller.dto.BandJavaBeanDto;
import se.patrikbergman.java.bandapp.service.domain.Band;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BandMappingTest {
    MapperFactory mapperFactory;
    private MapperFacade mapperFacade;
    private BoundMapperFacade<Band, BandDto> boundMapperFacade; //Another (faster) alternative
    private Band sourceBand;
    private BandDto sourceBandDto;
    private static final String BAND_NAME = "Judas Priest";
    private static final int BAND_ROCKFACTOR = 8;

    @Before
    public void setup() {
        mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFacade = mapperFactory.getMapperFacade();
        sourceBand = Band.builder()
                .name(BAND_NAME)
                .rockFactor(BAND_ROCKFACTOR)
                .build();
    }

    /**
     * This works since Orika can use getters of Band and constructor of
     * BandJavaBeanDto
     */
    @Test
    public void bandToBandJavaBeanDto() {
        BandJavaBeanDto bandJavaBeanDto = mapperFacade.map(sourceBand, BandJavaBeanDto.class);
        assertNotNull(bandJavaBeanDto);
        assertEquals(BAND_NAME, bandJavaBeanDto.getName());
        assertEquals(BAND_ROCKFACTOR, bandJavaBeanDto.getRockFactor());
    }

    //Can't get this to work!!
//    @Test
//    public void foo() {
//        mapperFactory.classMap(Band.class, BandDto.class)
//                .field("name", "name")
//                .field("rockFactor", "rockFactor")
//                .byDefault()
//                .register();
//        mapperFactory.registerObjectFactory(new BandDtoFactory(), TypeFactory.valueOf(BandDto.class));
//        BandDto bandDto = mapperFacade.map(sourceBand, BandDto.class);
//    }
}
