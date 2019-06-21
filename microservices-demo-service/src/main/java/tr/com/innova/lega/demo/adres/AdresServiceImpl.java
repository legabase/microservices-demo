package tr.com.innova.lega.demo.adres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AdresServiceImpl implements AdresService {

    private AdresRepository adresRepository;

    @Autowired
    public AdresServiceImpl(AdresRepository adresRepository) {
        this.adresRepository = adresRepository;
    }
}
