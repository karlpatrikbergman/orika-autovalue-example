package se.patrikbergman.java.mapper.orika.autovalue.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class BandTest {

    @Test
    public void testBand() {
        Band band = Band.builder().name("Judas Priest").rockFactor(8).build();
        assertEquals("Judas Priest", band.name());
        assertEquals(8, band.rockFactor());

        // You probably don't need to write assertions like these; just illustrating.
        assertTrue(Band.builder().name("Judas Priest").rockFactor(8).build().equals(band));
        assertFalse(Band.builder().name("Abba").rockFactor(7).build().equals(band));
        assertFalse(Band.builder().name("Judas Priest").rockFactor(2).build().equals(band));

        assertEquals("Band{name=Judas Priest, rockFactor=8}", band.toString());
    }
}
