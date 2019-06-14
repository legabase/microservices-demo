package tr.com.innova.lega.demo.services.adres;

import org.springframework.data.repository.CrudRepository;
import tr.com.innova.lega.demo.domain.adres.Adres;

public interface AdresRepository extends CrudRepository<Adres, String> {
}
