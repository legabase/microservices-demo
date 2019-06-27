package tr.com.innova.lega.demo.api.kisi;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.innova.lega.demo.shared.MappingFilter;

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
        return new MappingFilter(kisiDTOList, KisiDTO.FILTER_NAME);
    }

    @GetMapping("{id}")
    public MappingFilter findById(@PathVariable String id) {
        final Kisi kisi = kisiService.getOne(id);
        final KisiDTO kisiDTO = KisiDTO.mapFromKisi(kisi);
        return new MappingFilter(kisiDTO, KisiDTO.FILTER_NAME, "ad", "soyad");
    }
}
