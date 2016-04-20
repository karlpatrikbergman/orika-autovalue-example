//package se.patrikbergman.java.mapper.orika;
//
//import ma.glasnost.orika.MapperFactory;
//import ma.glasnost.orika.impl.DefaultMapperFactory;
//import org.junit.Before;
//import se.patrikbergman.java.mapper.orika.autovalue.domain.Band;
//import se.patrikbergman.java.mapper.orika.autovalue.dto.BandDto;
//import se.patrikbergman.java.mapper.orika.autovalue.dto.BandJavaBeanDto;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//public class BandMappingTest2 {
//    private MapperFactory mapperFactory;
//    private Band sourceBand;
//
//    @Before
//    public void createMapperFactoryAndDefineMapping() {
//        mapperFactory = new DefaultMapperFactory.Builder()
//                .useAutoMapping(false).build();
//        mapperFactory.classMap(Band.class, BandJavaBeanDto.class)
//                .field("name", "name")
//                .field("rockFactor", "rockFactor")
//                .register();
//        sourceBand = Band.builder()
//                .name("Saxon")
//                .rockFactor(5)
//                .build();
//    }
//
////    @Test
//    public void bandToBandJavaBeanDto() {
//        BandJavaBeanDto bandJavaBeanDto = mapperFactory.getMapperFacade().map(sourceBand, BandJavaBeanDto.class);
//        assertNotNull(bandJavaBeanDto);
//        assertEquals("Saxon", bandJavaBeanDto.getName());
//        assertEquals(5, bandJavaBeanDto.getRockFactor());
//        System.out.println(bandJavaBeanDto);
//    }
//
////    @Test
//    public void bandToBandDto() {
//        mapperFactory.registerConcreteType(BandDto.class, BandDto.getGeneratedClass());
//        BandDto bandDto = mapperFactory.getMapperFacade().map(sourceBand, BandDto.class);
//        assertNotNull(bandDto);
//        assertEquals("Saxon", bandDto.getName());
//        assertEquals(5, bandDto.getRockFactor());
//
//        System.out.println(bandDto);
//    }
//
//}
