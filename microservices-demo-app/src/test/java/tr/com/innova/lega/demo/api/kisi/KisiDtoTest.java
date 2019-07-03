package tr.com.innova.lega.demo.api.kisi;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;

public class KisiDtoTest {

    @Test
    public void testEqualsAndHashCode() {
        EqualsVerifier
                .forClass(KisiDto.class)
                .suppress(Warning.STRICT_INHERITANCE)
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }
}
