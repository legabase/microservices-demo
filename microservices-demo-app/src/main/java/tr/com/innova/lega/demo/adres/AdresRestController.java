package tr.com.innova.lega.demo.adres;

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
@RequestMapping("v1/adres")
public class AdresRestController {

    private AdresService adresService;

    @Autowired
    public AdresRestController(AdresService adresService) {
        this.adresService = adresService;
    }

    @GetMapping
    public MappingFilter getAll() {
        final List<Adres> adresList = adresService.findAll();
        final List<AdresDTO> adresDTOList = adresList.stream().map(AdresDTO::mapFromAdres).collect(Collectors.toList());
        return new MappingFilter(adresDTOList);
    }

    @GetMapping("{id}")
    public MappingFilter findById(@PathVariable String id) {
        final Adres adres = adresService.getOne(id);
        final AdresDTO adresDTO = AdresDTO.mapFromAdres(adres);
        return new MappingFilter(adresDTO);
    }
}
