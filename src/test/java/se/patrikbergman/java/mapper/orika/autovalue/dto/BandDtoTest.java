package se.patrikbergman.java.mapper.orika.autovalue.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BandDtoTest {

    @Test
    public void testBandDto() {
        BandDto bandDto = BandDto.builder().name("Judas Priest").rockValue(8).build();
        assertEquals("Judas Priest", bandDto.name());
        assertEquals(8, bandDto.rockValue());

        assertTrue(BandDto.builder().name("Judas Priest").rockValue(8).build().equals(bandDto));
        assertFalse(BandDto.builder().name("Abba").rockValue(7).build().equals(bandDto));
        assertFalse(BandDto.builder().name("Judas Priest").rockValue(2).build().equals(bandDto));

        assertEquals("BandDto{name=Judas Priest, rockValue=8}", bandDto.toString());
    }
}

