package tr.com.innova.lega.demo.kisi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface KisiRepository extends JpaRepository<Kisi, String> {
}
