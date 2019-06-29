package tr.com.innova.lega.demo.api.adres;

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
    private AdresMapper adresMapper;

    @Autowired
    public AdresRestController(
            AdresService adresService,
            AdresMapper adresMapper
    ) {
        this.adresService = adresService;
        this.adresMapper = adresMapper;
    }

    @GetMapping
    public MappingFilter getAll() {
        final List<Adres> adresList = adresService.findAll();
        final List<AdresDto> adresDtoList = adresList.stream().map(adresMapper::mapAdresToAdresDto).collect(Collectors.toList());
        return new MappingFilter(adresDtoList);
    }

    @GetMapping("{id}")
    public MappingFilter findById(@PathVariable String id) {
        final Adres adres = adresService.getOne(id);
        final AdresDto adresDto = adresMapper.mapAdresToAdresDto(adres);
        return new MappingFilter(adresDto);
    }
}
