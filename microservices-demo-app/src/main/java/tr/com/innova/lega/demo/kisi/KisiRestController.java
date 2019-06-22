package tr.com.innova.lega.demo.kisi;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@NoArgsConstructor
@RequestMapping("v1/kisi")
public class KisiRestController {

    private KisiRepository kisiRepository;
    private KisiService kisiService;

    @Autowired
    public KisiRestController(KisiRepository kisiRepository, KisiService kisiService) {
        this.kisiRepository = kisiRepository;
        this.kisiService = kisiService;
    }

    @GetMapping
    public MappingJacksonValue getAll() {
        List<KisiDTO> kisiDTOList = new ArrayList<>();
        Iterable<Kisi> kisiIterable = kisiRepository.findAll();
        kisiIterable.forEach(kisi -> kisiDTOList.add(KisiDTO.mapFromKisi(kisi)));
        MappingJacksonValue mapping = new MappingJacksonValue(kisiDTOList);
        mapping.setFilters(new SimpleFilterProvider().addFilter("KisiDTOFilter", SimpleBeanPropertyFilter.serializeAll()));
        return mapping;
    }


    @GetMapping("{id}")
    public MappingJacksonValue findById(@PathVariable String id) {
        Optional<Kisi> kisi = kisiRepository.findById(id);
        if (kisi.isPresent()) {
            MappingJacksonValue mapping = new MappingJacksonValue(KisiDTO.mapFromKisi(kisi.get()));
            mapping.setFilters(new SimpleFilterProvider().addFilter("KisiDTOFilter", SimpleBeanPropertyFilter.filterOutAllExcept("ad", "soyad")));
            return mapping;
        }
        throw new RuntimeException();
    }
}
