package tr.com.innova.lega.demo.base;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class AbstractServiceImpl<T> implements AbstractService<T> {

    protected final JpaRepository<T, String> repository;

    public AbstractServiceImpl(JpaRepository<T, String> repository) {
        this.repository = repository;
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T getOne(String id) {
        return repository.getOne(id);
    }
}
