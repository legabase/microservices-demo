package tr.com.innova.lega.demo.shared;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;

public class MappingFilter extends MappingJacksonValue {

    public static final String FILTER_NAME = "DefaultFilter";

    public MappingFilter(Object object) {
        super(object);
    }

    public MappingFilter(Object object, String filterName, String... columnList) {
        super(object);

        SimpleBeanPropertyFilter filter = columnList.length == 0 ?
                SimpleBeanPropertyFilter.serializeAll() :
                SimpleBeanPropertyFilter.filterOutAllExcept(columnList);

        setFilters(new SimpleFilterProvider().addFilter(filterName, filter));
    }
}
