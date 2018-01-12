package se.patrikbergman.java.mapping.brand;

import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.Before;
import org.junit.Test;
import se.patrikbergman.java.bandapp.controller.dto.BrandDto;
import se.patrikbergman.java.bandapp.service.domain.Brand;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Very basic example of mapping. The classes to be mapped have only one
 * field and it has the same name in both classes.
 *
 * Both MapperFacade and BoundMapperFacade are tested.
 *
 * DefaultMapperFactory.Builder().useAutoMapping() is set to true by default,
 * so we don't need to specify mapping of fields that have the same name.
 */

public class BrandMappingTest {
    private MapperFacade mapperFacade; //One alternative
    private BoundMapperFacade<Brand, BrandDto> boundMapperFacade; //Another (faster) alternative
    private Brand sourceBrand;
    private BrandDto sourceBrandDto;
    private static final String BRAND_NAME = "Fender";

    @Before
    public void setup() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFacade = mapperFactory.getMapperFacade();
        boundMapperFacade = mapperFactory.getMapperFacade(Brand.class, BrandDto.class);
        sourceBrand = new Brand(BRAND_NAME);
        sourceBrandDto = new BrandDto(BRAND_NAME);
    }

    @Test
    public void brandToBrantDto_UsingMapperFacade() {
        BrandDto brandDto = mapperFacade.map(sourceBrand, BrandDto.class);
        assertNotNull(brandDto);
        assertEquals(BRAND_NAME, brandDto.getName());
    }

    @Test
    public void brandDtoToBrand_UsingMapperFacade() {
        Brand brand = mapperFacade.map(sourceBrandDto, Brand.class);
        assertNotNull(brand);
        assertEquals(BRAND_NAME, brand.getName());
    }

    @Test
    public void brandToBrandDto_UsingBoundMapperFacade() {
        BrandDto brandDto = boundMapperFacade.map(sourceBrand);
        assertNotNull(brandDto);
        assertEquals(BRAND_NAME, brandDto.getName());
    }

    @Test
    public void brandDtoToBrand_UsingBoundMapperFacade() {
        Brand brand = boundMapperFacade.mapReverse(sourceBrandDto);
        assertNotNull(brand);
        assertEquals(BRAND_NAME, brand.getName());
    }


}
