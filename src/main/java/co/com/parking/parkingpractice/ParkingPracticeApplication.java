package co.com.parking.parkingpractice;

import org.apache.catalina.security.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({SecurityConfig.class})
public class ParkingPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingPracticeApplication.class, args);
	}
}
