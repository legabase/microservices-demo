package tr.com.innova.lega.demo.api.kisi;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Getter;
import lombok.Setter;

import static tr.com.innova.lega.demo.shared.MappingFilter.FILTER_NAME;

@Getter
@Setter
@JsonFilter(FILTER_NAME)
public class KisiDto {
    private String id;
    private String ad;
    private String soyad;
}
