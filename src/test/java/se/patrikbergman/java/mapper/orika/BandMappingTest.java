//package se.patrikbergman.java.mapper.orika;
//
//import org.junit.Before;
//import org.junit.Test;
//import se.patrikbergman.java.mapper.orika.autovalue.domain.Band;
//import se.patrikbergman.java.mapper.orika.autovalue.dto.BandDto;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//public class BandMappingTest {
//    private BandMapper mapper;
//
//    @Before
//    public void setup() {
//        mapper = BandMapper.INSTANCE;
//    }
//
//    @Test
//    public void bandToBandDto() {
//        Band band = Band.builder().name("Judas Priest").rockFactor(8).build();
//        BandDto bandDto = mapper.bandToBandDto(band);
//        assertNotNull(bandDto);
//        assertEquals(band.getName(), bandDto.getName());
//        assertEquals(band.getRockFactor(), bandDto.getRockFactor());
//    }
//
//    @Test
//    public void bandDtoToBand() {
//        BandDto bandDto = BandDto.builder().name("Judas Priest").rockFactor(8).build();
//        Band band = mapper.bantDtoToBand(bandDto);
//        assertNotNull(band);
//        assertEquals(bandDto.getName(), band.getName());
//        assertEquals(bandDto.getRockFactor(), band.getRockFactor());
//    }
//}
