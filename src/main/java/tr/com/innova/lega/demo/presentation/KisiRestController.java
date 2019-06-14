package tr.com.innova.lega.demo.presentation;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.innova.lega.demo.domain.kisi.Kisi;
import tr.com.innova.lega.demo.services.kisi.KisiRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@NoArgsConstructor
@RequestMapping("kisi")
public class KisiRestController {
    private KisiRepository kisiRepository;

    @Autowired
    public KisiRestController(KisiRepository kisiRepository) {
        this.kisiRepository = kisiRepository;
    }

    @GetMapping
    public List<KisiDTO> getKisiList() {
        List<KisiDTO> kisiDTOList = new ArrayList<>();
        Iterable<Kisi> kisiIterable = kisiRepository.findAll();
        kisiIterable.forEach(kisi -> kisiDTOList.add(KisiDTO.mapFromKisi(kisi)));
        return kisiDTOList;
    }


    @GetMapping("/id")
    public KisiDTO getKisi(@PathVariable String id) {
        Optional<Kisi> kisi = kisiRepository.findById(id);
        if (kisi.isPresent()) {
            return KisiDTO.mapFromKisi(kisi.get());
        }
        throw new RuntimeException();
    }
}
