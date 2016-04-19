//package se.patrikbergman.java.mapper.orika;
//
//import ma.glasnost.orika.BoundMapperFacade;
//import ma.glasnost.orika.MapperFactory;
//import ma.glasnost.orika.impl.DefaultMapperFactory;
//import se.patrikbergman.java.mapper.orika.autovalue.domain.Band;
//import se.patrikbergman.java.mapper.orika.autovalue.dto.BandDto;
//
//
//public enum BandMapper {
//    INSTANCE;
//    private static final BoundMapperFacade<Band, BandDto> boundMapper;
//
//    static {
//        final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
//        mapperFactory.classMap(Band.class, BandDto.class)
//                .field("name", "name")
//                .field("rockFactor", "rockFactor")
//                .byDefault().register();
//        boundMapper = mapperFactory.getMapperFacade(Band.class, BandDto.class);
//    }
//
//    public BandDto bandToBandDto(Band band) {
//        return boundMapper.map(band);
//    }
//
//    public Band bantDtoToBand(BandDto bandDto) {
//        return boundMapper.mapReverse(bandDto);
//    }
//}
