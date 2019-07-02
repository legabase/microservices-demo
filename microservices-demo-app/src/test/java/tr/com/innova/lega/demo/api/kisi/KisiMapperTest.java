package tr.com.innova.lega.demo.api.kisi;

import org.junit.Before;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class KisiMapperTest {

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
    public void mapKisiToKisiDto() {
        KisiDto kisiDto = kisiMapper.mapKisiToKisiDto(kisi);

        assertNotNull(kisiDto);

        assertEquals(ACTUAL_ID, kisiDto.getId());
        assertEquals(ACTUAL_NAME, kisiDto.getAd());
        assertEquals(ACTUAL_SURNAME, kisiDto.getSoyad());

        assertNull(kisiMapper.mapKisiToKisiDto(null));
    }

    @Test
    public void mapKisiListToKisiDtoList() {
        List<Kisi> list = new ArrayList<>();
        list.add(kisi);
        list.add(kisi);

        List<KisiDto> kisiDtoList = kisiMapper.mapKisiListToKisiDtoList(list);

        assertNotNull(kisiDtoList);
        assertEquals(2, kisiDtoList.size());

        KisiDto kisiDto0 = kisiDtoList.get(0);
        assertEquals(ACTUAL_ID, kisiDto0.getId());
        assertEquals(ACTUAL_NAME, kisiDto0.getAd());
        assertEquals(ACTUAL_SURNAME, kisiDto0.getSoyad());

        KisiDto kisiDto1 = kisiDtoList.get(1);
        assertEquals(ACTUAL_ID, kisiDto1.getId());
        assertEquals(ACTUAL_NAME, kisiDto1.getAd());
        assertEquals(ACTUAL_SURNAME, kisiDto1.getSoyad());

        assertNull(kisiMapper.mapKisiListToKisiDtoList(null));
    }
}
