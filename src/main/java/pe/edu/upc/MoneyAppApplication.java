package pe.edu.upc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"pe.edu.upc.entities"})
public class MoneyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoneyAppApplication.class, args);
	}
}
