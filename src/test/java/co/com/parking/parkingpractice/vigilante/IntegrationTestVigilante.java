package co.com.parking.parkingpractice.vigilante;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

import co.com.parking.parkingpractice.models.SalidaVehiculoDTO;
import co.com.parking.parkingpractice.models.VehiculoDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTestVigilante {
	

    @Autowired
    private TestRestTemplate restTemplate;
    
    /*@Before
    public void setUp() {
    	VehiculoDTO vehiculoDTO = new VehiculoDTO("LGG93D", "M");
    	vehiculoDTO.setFechaIngreso(new Date());
    	service.insertarVehivculo(vehiculoDTO);
    }
    
    @After
    public void Restart() throws ExceptionSalidaNoRegistrada {
    	VehiculoDTO vehiculoDTO = new VehiculoDTO("LGG93D", "M");
    	vehiculoDTO.setFechaIngreso(new Date());
    	service.actualizarSalidaVehiculo(vehiculoDTO);
    }*/
	
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
		
		ResponseEntity<String> responseEntity =
	            restTemplate.postForEntity("/api/ingresar", new VehiculoDTO("KXZ66E", "M"), String.class);
		responseEntity =
	            restTemplate.postForEntity("/api/ingresar", new VehiculoDTO("KXZ66E", "M"), String.class);
		
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
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
	
	@Test
	public void TestSalirError() throws Exception {

		// Inicializando los objetos para la prueba
		VehiculoDTO vehiculoDTO = new VehiculoDTO("QXZ66E", "M");
		
		ResponseEntity<SalidaVehiculoDTO> responseEntity =
	            restTemplate.postForEntity("/api/salir", vehiculoDTO, SalidaVehiculoDTO.class);
		
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
		
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
