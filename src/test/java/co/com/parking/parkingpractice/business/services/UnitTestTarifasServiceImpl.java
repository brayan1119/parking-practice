package co.com.parking.parkingpractice.business.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.when;

import java.util.Optional;

import co.com.parking.parkingpractice.business.services.TarifasService;
import co.com.parking.parkingpractice.ecxceptions.ExceptionTarifaNoEncontrada;
import co.com.parking.parkingpractice.persistence.repositories.TarifaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UnitTestTarifasServiceImpl {
	
	@Autowired
	private TarifasService tarifasService;
	
	@MockBean
	private TarifaRepository tarifaRepository;
	
	@Test(expected = ExceptionTarifaNoEncontrada.class)
	public void test() throws ExceptionTarifaNoEncontrada {
	
		when(tarifaRepository.findById(5)).thenReturn(Optional.empty());
		
		tarifasService.consultaTarifaDeVehiculo(5);
	}

}
