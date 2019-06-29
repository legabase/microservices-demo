package tr.com.innova.lega.demo.api.adres;

import lombok.Getter;
import lombok.Setter;
import tr.com.innova.lega.demo.api.kisi.Kisi;
import tr.com.innova.lega.demo.base.AbstractEntity;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "T_ADRES")
public class Adres extends AbstractEntity {

    @Column(name = "ACIK_ADRES", columnDefinition = "VARCHAR", length = 256, nullable = false)
    private String acikAdres;

    @ManyToOne
    @JoinColumn(name = "KISI_ID", updatable = false, nullable = false)
    private Kisi kisi;
}
