package pluralsight.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class PlurasightSpringcloudM2ConfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlurasightSpringcloudM2ConfigserverApplication.class, args);
	}
}
