package co.com.parking.parkingpractice.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "co.com.parking.parkingpractice.persistence.repositories")
@EntityScan(basePackages = "co.com.parking.parkingpractice.persistence.entities")
@EnableTransactionManagement
public class ApplicationConfig {

}
