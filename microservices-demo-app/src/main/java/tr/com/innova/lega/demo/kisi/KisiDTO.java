package tr.com.innova.lega.demo.kisi;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonFilter("KisiDTOFilter")
public class KisiDTO {
    private String id;
    private String ad;
    private String soyad;

    public static KisiDTO mapFromKisi(Kisi kisi) {
        KisiDTO kisiDTO = null;
        if (kisi != null) {
            kisiDTO = new KisiDTO();
            kisiDTO.setId(kisi.getId());
            kisiDTO.setAd(kisi.getAd());
            kisiDTO.setSoyad(kisi.getSoyad());
        }
        return kisiDTO;
    }
}
