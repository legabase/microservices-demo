package tr.com.innova.lega.demo.shared;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;

public class MappingFilter extends MappingJacksonValue {

    public MappingFilter(Object dtoList) {
        super(dtoList);
    }

    public MappingFilter(Object dtoList, FilterProvider propertyFilter) {
        this(dtoList);
        setFilters(propertyFilter);
    }
}
