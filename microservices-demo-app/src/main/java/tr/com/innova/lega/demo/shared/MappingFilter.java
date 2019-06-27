package tr.com.innova.lega.demo.shared;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;

public class MappingFilter extends MappingJacksonValue {

    public MappingFilter(Object object) {
        super(object);
    }

    public MappingFilter(Object object, String filterName, String... columnName) {
        super(object);
        SimpleBeanPropertyFilter filter;
        if (columnName.length == 0) {
            filter = SimpleBeanPropertyFilter.serializeAll();
        } else {
            filter = SimpleBeanPropertyFilter.filterOutAllExcept(columnName);
        }
        setFilters(new SimpleFilterProvider().addFilter(filterName, filter));
    }
}
