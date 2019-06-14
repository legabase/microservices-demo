package tr.com.innova.lega.demo.domain.kisi;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "KISI")
public class Kisi {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private Long id;

    @Column(name = "AD")
    private String ad;

    @Column(name = "SOYAD")
    private String soyad;
}
