package co.com.parking.parkingpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories("co.com.parking.parkingpractice.repositories")
public class ParkingPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingPracticeApplication.class, args);
	}
}
