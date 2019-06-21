package tr.com.innova.lega.demo.adres;

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
@RequestMapping("v1/adres")
public class AdresRestController {
    private AdresRepository adresRepository;
    private AdresService adresService;

    @Autowired
    public AdresRestController(AdresRepository adresRepository, AdresService adresService) {
        this.adresRepository = adresRepository;
        this.adresService = adresService;
    }

    @GetMapping
    public List<AdresDTO> getAll() {
        List<AdresDTO> adresDTOList = new ArrayList<>();
        Iterable<Adres> adresIterable = adresRepository.findAll();
        adresIterable.forEach(adres -> adresDTOList.add(AdresDTO.mapFromAdres(adres)));
        
        return adresDTOList;
    }


    @GetMapping("{id}")
    public AdresDTO findById(@PathVariable String id) {
        Optional<Adres> adres = adresRepository.findById(id);
        if (adres.isPresent()) {
            return AdresDTO.mapFromAdres(adres.get());
        }
        throw new RuntimeException();
    }
}
