package tr.com.innova.lega.demo.api.adres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.innova.lega.demo.base.AbstractServiceImpl;

@Service
@Transactional
public class AdresServiceImpl extends AbstractServiceImpl<Adres> implements AdresService {

    @Autowired
    public AdresServiceImpl(AdresRepository adresRepository) {
        super(adresRepository);
    }
}
