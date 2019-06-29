package tr.com.innova.lega.demo.api.kisi;

import org.junit.Before;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.Assert.*;

public class KisiDtoTest {

    private static final String ACTUAL_ID = "1001";
    private static final String ACTUAL_NAME = "Name";
    private static final String ACTUAL_SURNAME = "Surname";

    private KisiMapper kisiMapper = Mappers.getMapper(KisiMapper.class);

    private Kisi kisi;

    @Before
    public void before() {
        kisi = new Kisi();
        kisi.setId(ACTUAL_ID);
        kisi.setAd(ACTUAL_NAME);
        kisi.setSoyad(ACTUAL_SURNAME);
    }

    @Test
    public void shouldMapKisiToKisiDto() {
        KisiDto kisiDto = kisiMapper.mapKisiToKisiDto(kisi);

        assertNotNull(kisiDto);

        assertEquals(ACTUAL_ID, kisiDto.getId());
        assertEquals(ACTUAL_NAME, kisiDto.getAd());
        assertEquals(ACTUAL_SURNAME, kisiDto.getSoyad());

        assertNull(kisiMapper.mapKisiToKisiDto(null));
    }
}
