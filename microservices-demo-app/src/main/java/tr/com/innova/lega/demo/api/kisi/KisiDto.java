package tr.com.innova.lega.demo.api.kisi;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonFilter("KisiDTOFilter")
public class KisiDto {
    public static final String FILTER_NAME = "KisiDTOFilter";
    private String id;
    private String ad;
    private String soyad;
}
