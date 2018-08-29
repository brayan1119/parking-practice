package co.com.parking.parkingpractice.vigilante;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.com.parking.parkingpractice.business.services.CobroService;
import co.com.parking.parkingpractice.business.services.TarifasService;
import co.com.parking.parkingpractice.ecxceptions.ExcepcionGenerica;
import co.com.parking.parkingpractice.ecxceptions.ExceptionTarifaNoEncontrada;
import co.com.parking.parkingpractice.models.VehiculoDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UnitTestCobroServiceImpl {
	
	@Autowired
	private CobroService  cobroService;
	
	@MockBean
	private TarifasService tarifasService;
	
	@Test
	public void cantidadDias() throws ExcepcionGenerica, ParseException {
		//Preparar los datos
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaInicial = dateFormat.parse("2018-02-14");
		Date fechaFinal = dateFormat.parse("2018-02-16");
		//Assert cuando Se obtiene el objeto tipo moto
		assertTrue(48.0 == cobroService.diferenciaTiempoHoras(fechaInicial, fechaFinal));
	}
	
	@Test
	public void calcularCobroMotoHora() throws ParseException, ExceptionTarifaNoEncontrada {
		//Preparar los datos
		when(tarifasService.consultaTarifaDeVehiculo(3)).thenReturn(500);
		VehiculoDTO vehiculo = new VehiculoDTO("AGJ93D", "M");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		Date fechaInicial = dateFormat.parse("2018-08-23 11:00");
		Date fechaFinal = dateFormat.parse("2018-08-23 14:00");
		vehiculo.setFechaIngreso(fechaInicial);
		vehiculo.setFechaSalida(fechaFinal);
		
		//Assert cuando Se obtiene el objeto tipo moto
		assertEquals(1500, cobroService.calcularCobroVehiculo(vehiculo));
	}
	
	@Test
	public void calcularCobroMotoHoraSobreCosto() throws ParseException, ExceptionTarifaNoEncontrada {
		//Preparar los datos
		when(tarifasService.consultaTarifaDeVehiculo(3)).thenReturn(500);
		VehiculoDTO vehiculo = new VehiculoDTO("AGJ93D", "M");
		vehiculo.setCilindraje(700);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		Date fechaInicial = dateFormat.parse("2018-08-23 11:00");
		Date fechaFinal = dateFormat.parse("2018-08-23 14:00");
		vehiculo.setFechaIngreso(fechaInicial);
		vehiculo.setFechaSalida(fechaFinal);
		
		//Assert cuando Se obtiene el objeto tipo moto
		assertEquals(3500, cobroService.calcularCobroVehiculo(vehiculo));
	}
	
	@Test
	public void calcularCobroMotoDias() throws ParseException, ExceptionTarifaNoEncontrada {
		//Preparar los datos
		when(tarifasService.consultaTarifaDeVehiculo(4)).thenReturn(4000);
		VehiculoDTO vehiculo = new VehiculoDTO("AGJ93D", "M");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		Date fechaInicial = dateFormat.parse("2018-08-23 11:00");
		Date fechaFinal = dateFormat.parse("2018-08-24 21:00");
		vehiculo.setFechaIngreso(fechaInicial);
		vehiculo.setFechaSalida(fechaFinal);
		
		//Assert cuando Se obtiene el objeto tipo moto
		assertEquals(8000, cobroService.calcularCobroVehiculo(vehiculo));
	}

	@Test
	public void calcularCobroCarroHora() throws ParseException, ExceptionTarifaNoEncontrada {
		//Preparar los datos
		when(tarifasService.consultaTarifaDeVehiculo(1)).thenReturn(1000);
		VehiculoDTO vehiculo = new VehiculoDTO("GGG598", "C");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		Date fechaInicial = dateFormat.parse("2018-08-23 11:00");
		Date fechaFinal = dateFormat.parse("2018-08-23 14:00");
		vehiculo.setFechaIngreso(fechaInicial);
		vehiculo.setFechaSalida(fechaFinal);
		
		//Assert cuando Se obtiene el objeto tipo moto
		assertEquals(3000, cobroService.calcularCobroVehiculo(vehiculo));
	}
	
	@Test
	public void calcularCobroCarroDias() throws ParseException, ExceptionTarifaNoEncontrada {
		//Preparar los datos
		when(tarifasService.consultaTarifaDeVehiculo(2)).thenReturn(16000);
		when(tarifasService.consultaTarifaDeVehiculo(1)).thenReturn(1000);
		VehiculoDTO vehiculo = new VehiculoDTO("AGJ935", "C");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		Date fechaInicial = dateFormat.parse("2018-08-23 11:00");
		Date fechaFinal = dateFormat.parse("2018-08-25 19:00");
		vehiculo.setFechaIngreso(fechaInicial);
		vehiculo.setFechaSalida(fechaFinal);
		
		//Assert cuando Se obtiene el objeto tipo moto
		assertEquals(40000, cobroService.calcularCobroVehiculo(vehiculo));
	}
}
