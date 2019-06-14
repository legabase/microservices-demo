package tr.com.innova.lega.demo.domain.adres;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import tr.com.innova.lega.demo.domain.kisi.Kisi;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "ADRES")
public class Adres {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "ACIK_ADRES")
    private String acikAdres;

    @ManyToOne
    @JoinColumn(name = "KISI_ID")
    private Kisi kisi;
}
