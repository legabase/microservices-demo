package tr.com.innova.lega.demo.kisi;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<KisiDTO> getAll() {
        List<KisiDTO> kisiDTOList = new ArrayList<>();
        Iterable<Kisi> kisiIterable = kisiRepository.findAll();
        kisiIterable.forEach(kisi -> kisiDTOList.add(KisiDTO.mapFromKisi(kisi)));
        return kisiDTOList;
    }


    @GetMapping("{id}")
    public KisiDTO findById(@PathVariable String id) {
        Optional<Kisi> kisi = kisiRepository.findById(id);
        if (kisi.isPresent()) {
            return KisiDTO.mapFromKisi(kisi.get());
        }
        throw new RuntimeException();
    }
}
