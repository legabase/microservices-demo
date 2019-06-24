package tr.com.innova.lega.demo.base;

import java.util.List;

public interface AbstractService<T> {

    List<T> findAll();

    T getOne(String id);
}
