package tr.com.innova.lega.demo.api.kisi;

import lombok.Getter;
import lombok.Setter;
import tr.com.innova.lega.demo.base.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "T_KISI")
public class Kisi extends AbstractEntity {

    @Column(name = "AD", columnDefinition = "VARCHAR", length = 256, nullable = false)
    private String ad;

    @Column(name = "SOYAD", columnDefinition = "VARCHAR", length = 256, nullable = false)
    private String soyad;
}
