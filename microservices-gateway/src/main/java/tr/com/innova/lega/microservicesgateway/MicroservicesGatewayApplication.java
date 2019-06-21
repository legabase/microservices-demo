package tr.com.innova.lega.microservicesgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy  // act as zuul proxy.
@EnableEurekaServer //for making this application as eureka server.
@SpringBootApplication
public class MicroservicesGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesGatewayApplication.class, args);
	}

}
