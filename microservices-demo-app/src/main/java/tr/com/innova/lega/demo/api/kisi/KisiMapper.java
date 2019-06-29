package tr.com.innova.lega.demo.api.kisi;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class KisiMapper {

    public abstract KisiDto mapKisiToKisiDto(Kisi source);
}
