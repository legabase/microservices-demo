package tr.com.innova.lega.demo.api.kisi;

import org.mapstruct.factory.Mappers;

import java.util.ArrayList;

class AbstractKisiTestSetup {

    private static final String ACTUAL_ID = "1001";
    private static final String ACTUAL_NAME = "Name";
    private static final String ACTUAL_SURNAME = "Surname";

    KisiMapper kisiMapper = Mappers.getMapper(KisiMapper.class);

    ArrayList<Kisi> kisiList;

    void prepareKisi() {
        Kisi kisi = new Kisi();
        kisi.setId(ACTUAL_ID);
        kisi.setAd(ACTUAL_NAME);
        kisi.setSoyad(ACTUAL_SURNAME);

        Kisi kisi2 = new Kisi();
        kisi2.setId(ACTUAL_ID + "2");
        kisi2.setAd(ACTUAL_NAME + "2");
        kisi2.setSoyad(ACTUAL_SURNAME + "2");

        kisiList = new ArrayList<>();
        kisiList.add(kisi);
        kisiList.add(kisi2);
    }
}
