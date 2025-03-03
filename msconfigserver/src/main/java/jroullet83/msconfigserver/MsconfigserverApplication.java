package jroullet83.msconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
@EnableConfigServer
@SpringBootApplication
public class MsconfigserverApplication {

	public static void main(String[] args) {
//		EnvLoader.load();
		SpringApplication.run(MsconfigserverApplication.class, args);
	}

}
