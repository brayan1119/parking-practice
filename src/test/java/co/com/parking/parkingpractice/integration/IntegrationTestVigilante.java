package co.com.parking.parkingpractice.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import co.com.parking.parkingpractice.ecxceptions.ExceptionSalidaNoRegistrada;
import co.com.parking.parkingpractice.ecxceptions.ExceptionVehiculoParqueado;
import co.com.parking.parkingpractice.models.SalidaVehiculoDTO;
import co.com.parking.parkingpractice.models.VehiculoDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTestVigilante {
	

    @Autowired
    private TestRestTemplate restTemplate;
	
    // Prueba para realizar una insercion de un vehiculo 
	@Test
	public void TestInsert() throws Exception {

		//Realizando la prueba
		
        ResponseEntity<String> responseEntity =
            restTemplate.postForEntity("/api/ingresar", new VehiculoDTO("LGJ93D", "M"), String.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	@Test
	public void TestInsertError() throws Exception {

		// Inicializando los objetos para la prueba
		
	    restTemplate.postForEntity("/api/ingresar", new VehiculoDTO("KXZ66E", "M"), String.class);
		ResponseEntity<ExceptionVehiculoParqueado> responseEntity =
	            restTemplate.postForEntity("/api/ingresar", new VehiculoDTO("KXZ66E", "M"), ExceptionVehiculoParqueado.class);
		
		assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
		assertTrue(ExceptionVehiculoParqueado.class == responseEntity.getBody().getClass());
	}
	
	@Test
	public void TestSalir() throws Exception {

		// Inicializando los objetos para la prueba
		VehiculoDTO vehiculoDTO = new VehiculoDTO("SXZ66E", "M");
		
		restTemplate.postForEntity("/api/ingresar", vehiculoDTO, String.class);
		ResponseEntity<SalidaVehiculoDTO> responseEntity =
	            restTemplate.postForEntity("/api/salir", vehiculoDTO, SalidaVehiculoDTO.class);
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(vehiculoDTO.getPlaca(), responseEntity.getBody().getPlaca());
		
	}
	
	@Test()
	public void TestSalirError() throws Exception {

		// Inicializando los objetos para la prueba
		VehiculoDTO vehiculoDTO = new VehiculoDTO("QXZ66E", "M");
		
		ResponseEntity<ExceptionSalidaNoRegistrada> responseEntity =
	            restTemplate.postForEntity("/api/salir", vehiculoDTO, ExceptionSalidaNoRegistrada.class);
		// Error vehiculo no parquedo
		assertEquals(HttpStatus.CONFLICT, responseEntity.getStatusCode());
		assertTrue(ExceptionSalidaNoRegistrada.class == responseEntity.getBody().getClass());
		
	}
	
	@Test
	public void TestSalirDias() throws Exception {

		// Inicializando los objetos para la prueba
		VehiculoDTO vehiculoDTO = new VehiculoDTO("KXZ66E", "M");
		
		ResponseEntity<SalidaVehiculoDTO> responseEntity1 =
	            restTemplate.postForEntity("/api/salir", vehiculoDTO, SalidaVehiculoDTO.class);
		
		assertEquals(HttpStatus.OK, responseEntity1.getStatusCode());
		assertEquals(vehiculoDTO.getPlaca(), responseEntity1.getBody().getPlaca());
		
	}
}
