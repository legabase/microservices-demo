package tr.com.innova.lega.demo.shared;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public class MappingFilterProvider extends SimpleFilterProvider {

    public MappingFilterProvider(String filterName) {
        this(filterName, SimpleBeanPropertyFilter.serializeAll());
    }

    public MappingFilterProvider(String filterName, SimpleBeanPropertyFilter propertyFilter) {
        addFilter(filterName, propertyFilter);
    }
}
