package tr.com.innova.lega.demo.api.adres;

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
public class AdresRestControllerUnitTest {

    private static final String ACTUAL_ID = "1001";
    private static final String ACTUAL_ACIK_ADRES = "Adres";

    private AdresMapper adresMapper = Mappers.getMapper(AdresMapper.class);

    @Mock
    private AdresRepository adresRepository;

    private AdresRestController adresRestController;

    private ArrayList<Adres> adresList;

    @Before
    public void before() {
        prepareAdres();

        when(adresRepository.getOne(adresList.get(0).getId())).thenReturn(adresList.get(0));

        when(adresRepository.findAll()).thenReturn(adresList);

        adresRestController = new AdresRestController(new AdresServiceImpl(adresRepository), adresMapper);
    }

    private void prepareAdres() {
        Adres adres = new Adres();
        adres.setId(ACTUAL_ID);
        adres.setAcikAdres(ACTUAL_ACIK_ADRES);

        Adres adres2 = new Adres();
        adres2.setId(ACTUAL_ID + "2");
        adres2.setAcikAdres(ACTUAL_ACIK_ADRES + "2");

        adresList = new ArrayList<>();
        adresList.add(adres);
        adresList.add(adres2);
    }

    @Test
    public void getAll() {
        MappingFilter response = adresRestController.getAll();
        verify(adresRepository, times(1)).findAll();

        List value = (List) response.getValue();
        assertNotNull(value);
        assertEquals(2, value.size());
        assertEquals(adresMapper.mapAdresToAdresDto(adresList.get(0)), value.get(0));
        assertEquals(adresMapper.mapAdresToAdresDto(adresList.get(1)), value.get(1));
    }

    @Test
    public void findById() {
        MappingFilter response = adresRestController.findById(adresList.get(0).getId());
        verify(adresRepository, times(1)).getOne(adresList.get(0).getId());

        assertNotNull(response.getValue());
        assertEquals(adresMapper.mapAdresToAdresDto(adresList.get(0)), response.getValue());
    }
}
