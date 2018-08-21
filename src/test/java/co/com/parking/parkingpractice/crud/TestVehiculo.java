package co.com.parking.parkingpractice.crud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import co.com.parking.parkingpractice.business.services.VehiculoService;
import co.com.parking.parkingpractice.controllers.VehiculoController;
import co.com.parking.parkingpractice.models.VehiculoDTO;

@RunWith(SpringRunner.class)
@WebMvcTest(VehiculoController.class)
public class TestVehiculo {
	
    @Autowired
    private MockMvc mockMvc;    
    
	@Autowired
	private ObjectMapper mapper;
    
    @MockBean
    private VehiculoService service;
	
    // Prueba para realizar una insercion de un vehiculo 
	@Test
	public void TestInsert() throws Exception {

		// Inicializando los objetos para la prueba
		String json = mapper.writeValueAsString(new VehiculoDTO("AGJ93D"));
		//Realizando la prueba

		this.mockMvc.perform(post("/api/vehiculo")
			       .contentType(MediaType.APPLICATION_JSON)
			       .content(json)
			       .accept(MediaType.APPLICATION_JSON))
					// Assert prueba
			       .andDo(print()).andExpect(status().isOk());
	}
	
	//@Test
	public void TestInsertError() throws Exception {

		// Inicializando los objetos para la prueba
		String json = mapper.writeValueAsString(new VehiculoDTO("AGJ93D"));
		//Realizando la prueba
		System.out.println("va a insertar");
		this.mockMvc.perform(post("/api/vehiculo")
			       .contentType(MediaType.APPLICATION_JSON)
			       .content(json)
			       .accept(MediaType.APPLICATION_JSON))
				.andDo(print());
		// Volviendo a insertar
		System.out.println("Volviendo a insertar");
		this.mockMvc.perform(post("/api/vehiculo")
			       .contentType(MediaType.APPLICATION_JSON)
			       .content(json)
			       .accept(MediaType.APPLICATION_JSON))
					// Assert prueba
			       .andDo(print()).andExpect(status().is5xxServerError());
		System.out.println("termino de insertar");
	}
}
