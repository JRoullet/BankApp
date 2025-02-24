package jroullet83.msaccounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class MsaccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaccountsApplication.class, args);
	}

}
