package tr.com.innova.lega.demo.api.kisi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import tr.com.innova.lega.demo.shared.MappingFilter;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class KisiRestControllerUnitTest extends AbstractKisiTestSetup {

    @Mock
    private KisiRepository kisiRepository;

    private KisiRestController kisiRestController;

    @Before
    public void before() {
        prepareKisi();

        when(kisiRepository.getOne(kisiList.get(0).getId())).thenReturn(kisiList.get(0));

        when(kisiRepository.findAll()).thenReturn(kisiList);

        kisiRestController = new KisiRestController(new KisiServiceImpl(kisiRepository), kisiMapper);
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
        MappingFilter response = kisiRestController.findById(kisiList.get(0).getId());
        verify(kisiRepository, times(1)).getOne(kisiList.get(0).getId());

        assertNotNull(response.getValue());
        assertEquals(kisiMapper.mapKisiToKisiDto(kisiList.get(0)), response.getValue());
    }
}
