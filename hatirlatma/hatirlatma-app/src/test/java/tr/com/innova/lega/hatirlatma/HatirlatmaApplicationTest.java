package tr.com.innova.lega.hatirlatma;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HatirlatmaApplicationTest {

    @Value("${spring.application.name}")
    private String appName;

    @Test
    public void contextLoads() {
        Assert.isTrue(appName.equals("hatirlatma"), "Applicaton 'hatirlatma' could not load.");
    }
}