package tr.com.innova.lega.demo.api.kisi;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface KisiMapper {

    KisiDto mapKisiToKisiDto(Kisi source);

    List<KisiDto> mapKisiListToKisiDtoList(List<Kisi> source);
}
