package tr.com.innova.lega.demo.adres;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdresDTO {
    private String id;
    private String acikAdres;

    public static AdresDTO mapFromAdres(Adres adres) {
        AdresDTO adresDTO = null;
        if (adres != null) {
            adresDTO = new AdresDTO();
            adresDTO.setId(adres.getId());
            adresDTO.setAcikAdres(adres.getAcikAdres());
        }
        return adresDTO;
    }
}
