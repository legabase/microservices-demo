package tr.com.innova.lega.demo.kisi;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface KisiRepository extends PagingAndSortingRepository<Kisi, String> {
}
