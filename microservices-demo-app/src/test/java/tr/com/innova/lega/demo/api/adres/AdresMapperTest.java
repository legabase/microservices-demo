package tr.com.innova.lega.demo.api.adres;

import org.junit.Before;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AdresMapperTest {

    private static final String ACTUAL_ID = "1001";
    private static final String ACTUAL_ACIK_ADRES = "Adres";

    private AdresMapper adresMapper = Mappers.getMapper(AdresMapper.class);

    private Adres adres;

    @Before
    public void before() {
        adres = new Adres();
        adres.setId(ACTUAL_ID);
        adres.setAcikAdres(ACTUAL_ACIK_ADRES);
    }

    @Test
    public void mapAdresToAdresDto() {
        AdresDto adresDto = adresMapper.mapAdresToAdresDto(adres);

        assertNotNull(adresDto);

        assertEquals(ACTUAL_ID, adresDto.getId());
        assertEquals(ACTUAL_ACIK_ADRES, adresDto.getAcikAdres());

        assertNull(adresMapper.mapAdresToAdresDto(null));
    }

    @Test
    public void mapAdresListToAdresDtoList() {
        List<Adres> list = new ArrayList<>();
        list.add(adres);
        list.add(adres);

        List<AdresDto> adresDtoList = adresMapper.mapAdresListToAdresDtoList(list);

        assertNotNull(adresDtoList);
        assertEquals(2, adresDtoList.size());

        AdresDto adresDto0 = adresDtoList.get(0);
        assertEquals(ACTUAL_ID, adresDto0.getId());
        assertEquals(ACTUAL_ACIK_ADRES, adresDto0.getAcikAdres());

        AdresDto adresDto1 = adresDtoList.get(1);
        assertEquals(ACTUAL_ID, adresDto1.getId());
        assertEquals(ACTUAL_ACIK_ADRES, adresDto1.getAcikAdres());

        assertNull(adresMapper.mapAdresListToAdresDtoList(null));
    }
}
