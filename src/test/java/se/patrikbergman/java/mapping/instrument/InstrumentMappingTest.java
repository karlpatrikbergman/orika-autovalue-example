package se.patrikbergman.java.mapping.instrument;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.Before;
import org.junit.Test;
import se.patrikbergman.java.bandapp.controller.dto.GuitarDto;
import se.patrikbergman.java.bandapp.service.domain.Guitar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class InstrumentMappingTest {
    private MapperFactory mapperFactory;
    private MapperFacade mapperFacade;
    private Guitar sourceGuitar;
    private GuitarDto sourceGuitarDto;
    private static final String BRAND_NAME = "Fender";

    @Before
    public void setup() {
        mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFacade = mapperFactory.getMapperFacade();
        sourceGuitar = new Guitar(BRAND_NAME);
        sourceGuitarDto = new GuitarDto(BRAND_NAME);
    }

    @Test
    public void guitarToGuitarDto_UsingMapperFacade() {
        GuitarDto guitarDto =  mapperFacade.map(sourceGuitar, GuitarDto.class);
        assertNotNull(guitarDto);
        assertEquals(guitarDto.getName(), BRAND_NAME);
    }

    @Test
    public void guitarDtoToGuitar_UsingMapperFacade() {
        Guitar guitar = mapperFacade.map(sourceGuitarDto, Guitar.class);
        assertNotNull(guitar);
        assertEquals(BRAND_NAME, guitar.getName());
    }

}
