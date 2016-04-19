package se.patrikbergman.java.mapper.orika.autovalue.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BandDtoTest {

    @Test
    public void testBandDto() {
        BandDto bandDto = BandDto.builder().name("Judas Priest").rockFactor(8).build();
        assertEquals("Judas Priest", bandDto.getName());
        assertEquals(8, bandDto.getRockFactor());

        assertTrue(BandDto.builder().name("Judas Priest").rockFactor(8).build().equals(bandDto));
        assertFalse(BandDto.builder().name("Abba").rockFactor(7).build().equals(bandDto));
        assertFalse(BandDto.builder().name("Judas Priest").rockFactor(2).build().equals(bandDto));

        assertEquals("BandDto{name=Judas Priest, rockFactor=8}", bandDto.toString());
    }
}

