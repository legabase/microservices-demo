package tr.com.innova.lega.demo.kisi;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "KISI")
public class Kisi {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "AD", columnDefinition = "VARCHAR", length = 256, nullable = false)
    private String ad;

    @Column(name = "SOYAD", columnDefinition = "VARCHAR", length = 256)
    private String soyad;
}
