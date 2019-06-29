package tr.com.innova.lega.demo.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractVersionedEntity extends BaseEntity {

    @Version
    @Column(name = "VERSION")
    private Long version;
}
