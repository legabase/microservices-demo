package tr.com.innova.lega.demo.api.kisi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import tr.com.innova.lega.demo.shared.MappingFilter;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class KisiRestControllerUnitTest {

    private static final String ACTUAL_ID = "1001";
    private static final String ACTUAL_NAME = "Name";
    private static final String ACTUAL_SURNAME = "Surname";

    @Mock
    private KisiRepository kisiRepository;

    private Kisi kisi;
    private List<Kisi> kisiList;

    private KisiMapper kisiMapper = Mappers.getMapper(KisiMapper.class);

    private KisiRestController kisiRestController;

    @Before
    public void before() {
        prepareKisi();
        when(kisiRepository.getOne(ACTUAL_ID)).thenReturn(kisi);
        when(kisiRepository.findAll()).thenReturn(kisiList);
        kisiRestController = new KisiRestController(new KisiServiceImpl(kisiRepository), kisiMapper);
    }

    private void prepareKisi() {
        kisi = new Kisi();
        kisi.setId(ACTUAL_ID);
        kisi.setAd(ACTUAL_NAME);
        kisi.setSoyad(ACTUAL_SURNAME);

        Kisi kisi2 = new Kisi();
        kisi2.setId(ACTUAL_ID + "2");
        kisi2.setAd(ACTUAL_NAME + "2");
        kisi2.setSoyad(ACTUAL_SURNAME + "2");

        kisiList = new ArrayList<>();
        kisiList.add(kisi);
        kisiList.add(kisi2);
    }

    @Test
    public void getAll() {
        MappingFilter response = kisiRestController.getAll();
        verify(kisiRepository, times(1)).findAll();

        List value = (List) response.getValue();
        assertNotNull(value);
        assertEquals(2, value.size());
        assertEquals(kisiMapper.mapKisiToKisiDto(kisiList.get(0)), value.get(0));
        assertEquals(kisiMapper.mapKisiToKisiDto(kisiList.get(1)), value.get(1));
    }

    @Test
    public void findById() {
        MappingFilter response = kisiRestController.findById(ACTUAL_ID);
        verify(kisiRepository, times(1)).getOne(ACTUAL_ID);

        assertNotNull(response.getValue());
        assertEquals(kisiMapper.mapKisiToKisiDto(kisi), response.getValue());
    }
}
