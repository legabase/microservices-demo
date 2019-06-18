package tr.com.innova.lega.demo.adres;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface AdresRepository extends PagingAndSortingRepository<Adres, String> {
}
