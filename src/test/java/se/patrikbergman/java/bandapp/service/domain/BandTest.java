package se.patrikbergman.java.bandapp.service.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BandTest {

//    @Test
//    public void testBand() {
//        Band band = Band.Band("Judas Priest", 8);
//        assertEquals("Judas Priest", band.getName());
//        assertEquals(8, band.getRockFactor());
//        assertEquals("Band{name=Judas Priest, rockFactor=8}", band.toString());
//    }

    @Test
    public void testBand() {
        Band band = Band.builder().name("Judas Priest").rockFactor(8).build();
        assertEquals("Judas Priest", band.getName());
        assertEquals(8, band.getRockFactor());

        assertTrue(Band.builder().name("Judas Priest").rockFactor(8).build().equals(band));
        assertFalse(Band.builder().name("Abba").rockFactor(7).build().equals(band));
        assertFalse(Band.builder().name("Judas Priest").rockFactor(2).build().equals(band));

        assertEquals("Band{name=Judas Priest, rockFactor=8}", band.toString());
    }
}
