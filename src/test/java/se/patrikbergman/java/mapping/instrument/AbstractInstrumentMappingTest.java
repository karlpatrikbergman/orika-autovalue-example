package se.patrikbergman.java.mapping.instrument;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.Before;
import org.junit.Test;
import se.patrikbergman.java.bandapp.controller.dto.AbstractInstrumentDto;
import se.patrikbergman.java.bandapp.service.domain.AbstractInstrument;
import se.patrikbergman.java.bandapp.service.domain.Guitar;
import se.patrikbergman.java.bandapp.controller.dto.GuitarDto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AbstractInstrumentMappingTest {
    private MapperFactory mapperFactory;
    private MapperFacade mapperFacade; //One alternative, another is BoundMapperFacade

    @Before
    public void createMapperFactoryAndDefineMapping() {
        mapperFactory = new DefaultMapperFactory.Builder()
//                .useAutoMapping(false)
                .build();
        mapperFacade = mapperFactory.getMapperFacade();
    }

    @Test
    public void abstractInstrumentToGuitarDto_UsingMapperFacade() {
        AbstractInstrument abstractInstrument = new Guitar("Gibson");
        GuitarDto guitarDto = mapperFacade.map(abstractInstrument, GuitarDto.class);
        assertNotNull(guitarDto);
        assertEquals("Gibson", guitarDto.getName());
    }

    @Test
    public void abstractInstrumentToAbstractInstrumentDto_UsingMapperFacade() {
        /**
         * Orika can read from AbstractInstrument using defined getters, but
         * it can't create AbstractInstrumentDto since it has no constructor.
         * By registering GuitarDto that implements AbstractInstrumentDto Orika
         * knows how to create AbstractInstrumentDto.
         */
        mapperFactory.registerConcreteType(AbstractInstrumentDto.class, GuitarDto.class);

        AbstractInstrument abstractInstrument = new Guitar("Gibson");
        AbstractInstrumentDto abstractInstrumentDto = mapperFacade.map(abstractInstrument, AbstractInstrumentDto.class);
        assertNotNull(abstractInstrumentDto);
        assertEquals("Gibson", abstractInstrumentDto.getName());
    }

//    @Test
//    public void abstractInstrumentDtoToAbstractInstrument_UsingMapperFacade() {
//        mapperFactory.registerConcreteType(AbstractInstrument.class, Guitar.class);
//
//        AbstractInstrumentDto abstractInstrumentDto = new GuitarDto("Gibson");
//
//    }
}
