package tr.com.innova.lega.demo.api.adres;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class AdresMapper {

    public abstract AdresDto mapAdresToAdresDto(Adres source);
}
