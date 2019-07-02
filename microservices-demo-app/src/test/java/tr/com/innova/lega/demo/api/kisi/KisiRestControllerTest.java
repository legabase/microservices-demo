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
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class KisiRestControllerTest {

    private static final String ACTUAL_ID = "1001";
    private static final String ACTUAL_NAME = "Name";
    private static final String ACTUAL_SURNAME = "Surname";

    @Mock
    private KisiRepository kisiRepository;

    private Kisi kisi;
    private List<Kisi> kisiList;

    private KisiRestController kisiRestController;

    @Before
    public void before() {
        prepareKisi();
        mockKisiRepository();
        autowireKisiRestController();
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

    private void mockKisiRepository() {
        when(kisiRepository.getOne(ACTUAL_ID)).thenReturn(kisi);
        when(kisiRepository.findAll()).thenReturn(kisiList);
    }

    private void autowireKisiRestController() {
        KisiServiceImpl kisiService = new KisiServiceImpl(kisiRepository);
        KisiMapper kisiMapper = Mappers.getMapper(KisiMapper.class);
        kisiRestController = new KisiRestController(kisiService, kisiMapper);
    }

    @Test
    public void getAll() {
        MappingFilter response = kisiRestController.getAll();
        verify(kisiRepository, times(1)).findAll();
        List value = (List) response.getValue();

        assertEquals(2, value.size());

        KisiDto value0 = (KisiDto) value.get(0);
        assertEquals(ACTUAL_ID, value0.getId());
        assertEquals(ACTUAL_NAME, value0.getAd());
        assertEquals(ACTUAL_SURNAME, value0.getSoyad());

        KisiDto value1 = (KisiDto) value.get(1);
        assertEquals(ACTUAL_ID + "2", value1.getId());
        assertEquals(ACTUAL_NAME + "2", value1.getAd());
        assertEquals(ACTUAL_SURNAME + "2", value1.getSoyad());
    }

    @Test
    public void findById() {
        MappingFilter response = kisiRestController.findById(ACTUAL_ID);
        verify(kisiRepository, times(1)).getOne(ACTUAL_ID);
        KisiDto value = (KisiDto) response.getValue();

        assertEquals(ACTUAL_ID, value.getId());
        assertEquals(ACTUAL_NAME, value.getAd());
        assertEquals(ACTUAL_SURNAME, value.getSoyad());
    }
}
