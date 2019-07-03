package tr.com.innova.lega.demo.api.adres;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;

public class AdresDtoTest {

    @Test
    public void testEqualsAndHashCode() {
        EqualsVerifier
                .forClass(AdresDto.class)
                .suppress(Warning.STRICT_INHERITANCE)
                .suppress(Warning.NONFINAL_FIELDS)
                .verify();
    }
}
