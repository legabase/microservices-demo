package tr.com.innova.lega.demo.services.kisi;

import org.springframework.data.repository.CrudRepository;
import tr.com.innova.lega.demo.domain.kisi.Kisi;

public interface KisiRepository extends CrudRepository<Kisi, String> {
}
