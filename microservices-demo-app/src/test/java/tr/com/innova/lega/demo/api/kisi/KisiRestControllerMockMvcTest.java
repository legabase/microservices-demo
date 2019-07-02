package tr.com.innova.lega.demo.api.kisi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class KisiRestControllerMockMvcTest extends AbstractKisiTestSetup {

    @InjectMocks
    private KisiRestController mockKisiRestController;

    @Mock
    private KisiService mockKisiService;

    @Mock
    private KisiMapper mockKisiMapper;

    private MockMvc mvc;

    @Before
    public void setup() {
        prepareKisi();

        when(mockKisiService.getOne(kisiList.get(0).getId())).thenReturn(kisiList.get(0));
        when(mockKisiMapper.mapKisiToKisiDto(kisiList.get(0))).thenReturn(kisiMapper.mapKisiToKisiDto(kisiList.get(0)));

        when(mockKisiService.findAll()).thenReturn(kisiList);
        when(mockKisiMapper.mapKisiListToKisiDtoList(kisiList)).thenReturn(kisiMapper.mapKisiListToKisiDtoList(kisiList));

        mvc = MockMvcBuilders.standaloneSetup(mockKisiRestController).build();
    }

    @Test
    public void getAll() throws Exception {
        mvc
                .perform(get("/v1/kisi").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(kisiList.get(0).getId())))
                .andExpect(jsonPath("$[0].ad", is(kisiList.get(0).getAd())))
                .andExpect(jsonPath("$[0].soyad", is(kisiList.get(0).getSoyad())))
                .andExpect(jsonPath("$[1].id", is(kisiList.get(1).getId())))
                .andExpect(jsonPath("$[1].ad", is(kisiList.get(1).getAd())))
                .andExpect(jsonPath("$[1].soyad", is(kisiList.get(1).getSoyad())));
    }

    @Test
    public void findById() throws Exception {
        mvc
                .perform(get("/v1/kisi/" + kisiList.get(0).getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").doesNotExist())
                .andExpect(jsonPath("$.ad").value(kisiList.get(0).getAd()))
                .andExpect(jsonPath("$.soyad").value(kisiList.get(0).getSoyad()));
    }
}
