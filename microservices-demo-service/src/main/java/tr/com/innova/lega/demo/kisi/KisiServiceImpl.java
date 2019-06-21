package tr.com.innova.lega.demo.kisi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class KisiServiceImpl implements KisiService {

    private KisiRepository kisiRepository;

    @Autowired
    public KisiServiceImpl(KisiRepository kisiRepository) {
        this.kisiRepository = kisiRepository;
    }

}
