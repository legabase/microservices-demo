package tr.com.innova.lega.demo.kisi;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.innova.lega.demo.shared.MappingFilter;
import tr.com.innova.lega.demo.shared.MappingFilterProvider;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@NoArgsConstructor
@RequestMapping("v1/kisi")
public class KisiRestController {

    private KisiService kisiService;

    @Autowired
    public KisiRestController(KisiService kisiService) {
        this.kisiService = kisiService;
    }

    @GetMapping
    public MappingFilter getAll() {
        final List<Kisi> kisiList = kisiService.findAll();
        final List<KisiDTO> kisiDTOList = kisiList.stream().map(KisiDTO::mapFromKisi).collect(Collectors.toList());
        final MappingFilterProvider propertyFilter = new MappingFilterProvider("KisiDTOFilter");
        return new MappingFilter(kisiDTOList, propertyFilter);
    }

    @GetMapping("{id}")
    public MappingFilter findById(@PathVariable String id) {
        final Kisi kisi = kisiService.getOne(id);
        final KisiDTO kisiDTO = KisiDTO.mapFromKisi(kisi);
        final MappingFilterProvider propertyFilter = new MappingFilterProvider("KisiDTOFilter", SimpleBeanPropertyFilter.filterOutAllExcept("ad", "soyad"));
        return new MappingFilter(kisiDTO, propertyFilter);
    }
}
