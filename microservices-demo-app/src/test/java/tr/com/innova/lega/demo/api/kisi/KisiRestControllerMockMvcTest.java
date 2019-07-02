package tr.com.innova.lega.demo.api.kisi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class KisiRestControllerMockMvcTest {

    private static final String ACTUAL_ID = "1001";
    private static final String ACTUAL_NAME = "Name";
    private static final String ACTUAL_SURNAME = "Surname";

    private KisiMapper kisiMapper = Mappers.getMapper(KisiMapper.class);

    private List<Kisi> kisiList;

    @InjectMocks
    private KisiRestController mockKisiRestController;

    @Mock
    private KisiService mockKisiService;

    @Mock
    private KisiMapper mockKisiMapper;

    private MockMvc mvc;

    @Before
    public void setup() {
        Kisi kisi = new Kisi();
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

        when(mockKisiService.getOne(ACTUAL_ID)).thenReturn(kisi);
        when(mockKisiMapper.mapKisiToKisiDto(kisi)).thenReturn(kisiMapper.mapKisiToKisiDto(kisi));

        when(mockKisiService.findAll()).thenReturn(kisiList);
        when(mockKisiMapper.mapKisiListToKisiDtoList(kisiList)).thenReturn(kisiMapper.mapKisiListToKisiDtoList(kisiList));

        mvc = MockMvcBuilders.standaloneSetup(mockKisiRestController).build();
    }

    @Test
    public void getAll() throws Exception {
        mvc
                .perform(get("/v1/kisi").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").exists())
                .andExpect(jsonPath("$[1]").exists())
                .andExpect(jsonPath("$[2]").doesNotExist())
                .andExpect(jsonPath("$[0].id").value(kisiList.get(0).getId()))
                .andExpect(jsonPath("$[0].ad").value(kisiList.get(0).getAd()))
                .andExpect(jsonPath("$[0].soyad").value(kisiList.get(0).getSoyad()))
                .andExpect(jsonPath("$[1].id").value(kisiList.get(1).getId()))
                .andExpect(jsonPath("$[1].ad").value(kisiList.get(1).getAd()))
                .andExpect(jsonPath("$[1].soyad").value(kisiList.get(1).getSoyad()));
    }

    @Test
    public void findById() throws Exception {
        mvc
                .perform(get("/v1/kisi/" + ACTUAL_ID).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").doesNotExist())
                .andExpect(jsonPath("$.ad").value(ACTUAL_NAME))
                .andExpect(jsonPath("$.soyad").value(ACTUAL_SURNAME));
    }
}
