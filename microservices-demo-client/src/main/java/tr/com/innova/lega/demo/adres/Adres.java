package tr.com.innova.lega.demo.adres;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import tr.com.innova.lega.demo.kisi.Kisi;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "ADRES")
public class Adres {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @NotNull
    @Column(name = "ACIK_ADRES", columnDefinition = "VARCHAR", length = 256)
    private String acikAdres;

    @ManyToOne
    @JoinColumn(name = "KISI_ID", updatable = false, nullable = false)
    private Kisi kisi;
}

