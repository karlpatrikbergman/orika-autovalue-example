package se.patrikbergman.java.mapper.orika;

import org.junit.Before;
import org.junit.Test;
import se.patrikbergman.java.mapper.orika.autovalue.domain.Person;
import se.patrikbergman.java.mapper.orika.autovalue.dto.PersonDto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PersonMappingTest {
    private PersonMapper mapper;

    @Before
    public void setup() {
        mapper = PersonMapper.INSTANCE;
    }

    @Test
    public void personToPersonDto() {
        Person person = new Person();
        person.setName("John");
        person.setSurName("Lennon");
        PersonDto personDto = mapper.toPersonDto(person);
        assertNotNull(personDto);
        assertEquals("John", personDto.getName());
        assertEquals("Lennon", personDto.getFamilyName());
    }

    @Test
    public void personDtoToPerson() {
        PersonDto personDto = new PersonDto();
        personDto.setName("Paul");
        personDto.setFamilyName("Mccartney");
        Person person = mapper.toPerson(personDto);
    }
}
