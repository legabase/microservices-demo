package tr.com.innova.lega.demo.api.adres;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AdresMapper {

    AdresDto mapAdresToAdresDto(Adres source);

    List<AdresDto> mapAdresListToAdresDtoList(List<Adres> source);
}
