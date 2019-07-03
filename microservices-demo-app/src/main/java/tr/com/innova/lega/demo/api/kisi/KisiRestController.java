package tr.com.innova.lega.demo.api.kisi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.innova.lega.demo.shared.MappingFilter;

import java.util.List;

@RestController
@RequestMapping("v1/kisi")
public class KisiRestController {

    private KisiService kisiService;
    private KisiMapper kisiMapper;

    @Autowired
    public KisiRestController(
            KisiService kisiService,
            KisiMapper kisiMapper
    ) {
        this.kisiService = kisiService;
        this.kisiMapper = kisiMapper;
    }

    @GetMapping
    public MappingFilter getAll() {
        final List<Kisi> kisiList = kisiService.findAll();
        final List<KisiDto> kisiDtoList = kisiMapper.mapKisiListToKisiDtoList(kisiList);
        return new MappingFilter(kisiDtoList, MappingFilter.FILTER_NAME);
    }

    @GetMapping("{id}")
    public MappingFilter findById(@PathVariable String id) {
        final Kisi kisi = kisiService.getOne(id);
        final KisiDto kisiDto = kisiMapper.mapKisiToKisiDto(kisi);
        return new MappingFilter(kisiDto, MappingFilter.FILTER_NAME, "ad", "soyad");
    }
}
