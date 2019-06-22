package tr.com.innova.lega.demo.kisi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tr.com.innova.lega.demo.base.AbstractServiceImpl;

@Service
@Transactional
public class KisiServiceImpl extends AbstractServiceImpl<Kisi> implements KisiService {

    @Autowired
    public KisiServiceImpl(KisiRepository kisiRepository) {
        super(kisiRepository);
    }
}
