package se.patrikbergman.java.mapper.orika;

import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import se.patrikbergman.java.mapper.orika.autovalue.domain.Person;
import se.patrikbergman.java.mapper.orika.autovalue.dto.PersonDto;

/**
 * Only mapping deviations must be specified, fields with the same name
 * are automatically mapped.
 */
public enum PersonMapper {
    INSTANCE;
    private static final BoundMapperFacade<Person, PersonDto> boundMapper;

    static {
        final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Person.class, PersonDto.class)
                .field("surName", "familyName")
                .byDefault().register();
        boundMapper = mapperFactory.getMapperFacade(Person.class, PersonDto.class);
    }

    public PersonDto toPersonDto(Person person) {
        return boundMapper.map(person);
    }

    public Person toPerson(PersonDto personDto) {
        return boundMapper.mapReverse(personDto);
    }
}
