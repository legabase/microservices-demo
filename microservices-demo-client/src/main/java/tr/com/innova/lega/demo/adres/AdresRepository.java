package tr.com.innova.lega.demo.adres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AdresRepository extends JpaRepository<Adres, String> {
}
