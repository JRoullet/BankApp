package jroullet.msdiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MsdiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsdiscoveryApplication.class, args);
	}

}
