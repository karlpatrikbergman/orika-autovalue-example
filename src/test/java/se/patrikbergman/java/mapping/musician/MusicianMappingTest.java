package se.patrikbergman.java.mapping.musician;

import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.Before;
import org.junit.Test;
import se.patrikbergman.java.bandapp.controller.dto.MusicianDto;
import se.patrikbergman.java.bandapp.service.domain.Musician;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Slightly more advanced example, but still very basic. Classes to
 * be mapped has only one field but it does not have the same name.
 * Hence field mapping must be specified.
 *
 * Both MapperFacade and BoundMapperFacade are tested.
 */
public class MusicianMappingTest {
    private MapperFacade mapperFacade; //One alternative
    private BoundMapperFacade<Musician, MusicianDto> boundMapperFacade;
    private Musician sourceMusician;
    private MusicianDto sourceMusicianDto;

    @Before
    public void createMapperFactoryAndDefineMapping() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Musician.class, MusicianDto.class)
                .field("surName", "familyName")
                .byDefault()
                .register();
        mapperFacade = mapperFactory.getMapperFacade();
        boundMapperFacade = mapperFactory.getMapperFacade(Musician.class, MusicianDto.class);
        sourceMusician = new Musician("John", "Lennon");
        sourceMusicianDto = new MusicianDto("Paul", "Mccartney");
    }

    @Test
    public void personToPersonDto_UsingMapperFacade() {
        MusicianDto musicianDto = mapperFacade.map(sourceMusician, MusicianDto.class);
        assertNotNull(musicianDto);
        assertEquals("John", musicianDto.getName());
        assertEquals("Lennon", musicianDto.getFamilyName());
    }

    @Test
    public void personDtoToPerson_UsingMapperFacade() {
        Musician musician = mapperFacade.map(sourceMusicianDto, Musician.class);
        assertNotNull(musician);
        assertEquals("Paul", musician.getName());
        assertEquals("Mccartney", musician.getSurName());
    }

    @Test
    public void personToPersonDto_UsingBoundMapperFacade() {
        MusicianDto musicianDto = boundMapperFacade.map(sourceMusician);
        assertEquals("John", musicianDto.getName());
        assertEquals("Lennon", musicianDto.getFamilyName());
    }

    @Test
    public void personDtoToPerson_UsingBoundMapperFacade() {
        Musician musician = boundMapperFacade.mapReverse(sourceMusicianDto);
        assertNotNull(musician);
        assertEquals("Paul", musician.getName());
        assertEquals("Mccartney", musician.getSurName());
    }
}
