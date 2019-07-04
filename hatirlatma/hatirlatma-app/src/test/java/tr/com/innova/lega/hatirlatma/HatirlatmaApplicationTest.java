package tr.com.innova.lega.hatirlatma;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HatirlatmaApplicationTest {

    @Value("${spring.application.name}")
    private String appName;

    @Test
    public void contextLoads() {
        Assert.assertEquals("hatirlatma", appName);
    }
}