package tr.com.innova.lega.demo.kisi;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KisiDTOTest {

    private static final String ACTUAL_ID = "1001";
    private static final String ACTUAL_NAME = "Name";
    private static final String ACTUAL_SURNAME = "Surname";

    private Kisi kisi;

    @Before
    public void before() {
        kisi = new Kisi();
        kisi.setId(ACTUAL_ID);
        kisi.setAd(ACTUAL_NAME);
        kisi.setSoyad(ACTUAL_SURNAME);
    }

    @Test
    public void mapFromKisi() {
        final KisiDTO kisiDTO = KisiDTO.mapFromKisi(kisi);

        assertNotNull(kisiDTO);

        assertEquals(ACTUAL_ID, kisiDTO.getId());
        assertEquals(ACTUAL_NAME, kisiDTO.getAd());
        assertEquals(ACTUAL_SURNAME, kisiDTO.getSoyad());

        assertNull(KisiDTO.mapFromKisi(null));
    }
}
