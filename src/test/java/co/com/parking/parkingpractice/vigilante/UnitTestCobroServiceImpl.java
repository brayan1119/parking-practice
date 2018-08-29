package co.com.parking.parkingpractice.vigilante;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.com.parking.parkingpractice.business.services.impl.CobroServiceImpl;
import co.com.parking.parkingpractice.ecxceptions.ExcepcionGenerica;
import co.com.parking.parkingpractice.ecxceptions.ExceptionTarifaNoEncontrada;
import co.com.parking.parkingpractice.models.VehiculoDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class UnitTestCobroServiceImpl {
	
	CobroServiceImpl  cobroService = new CobroServiceImpl();
	
	private static final int DIAS_HORAS = 24;
	private static final int HORAS_MINUTOS = 60;	
	@Test
	public void cantidadDias() throws ExcepcionGenerica, ParseException {
		//Preparar los datos
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaInicial = dateFormat.parse("2018-02-14");
		Date fechaFinal = dateFormat.parse("2018-02-16");
		//Assert cuando Se obtiene el objeto tipo moto
		assertTrue(48.0 == cobroService.diferenciaTiempoHoras(fechaInicial, fechaFinal));
	}
	
	
	//@Test
	public void calcularParteEnteraParteDecimalHoras() throws ExcepcionGenerica, ParseException, ExceptionTarifaNoEncontrada {
		//Preparar los datos
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		Date fechaInicial = dateFormat.parse("2018-08-23 11:00");
		Date fechaFinal = dateFormat.parse("2018-08-23 15:30");
		
		double tiempoMilisegundos = cobroService.diferenciaTiempoHoras(fechaInicial, fechaFinal);
		double resultados = 4;
		VehiculoDTO vehiculo = new VehiculoDTO();
		//Assert cuando Se obtiene el objeto tipo moto
		assertTrue(resultados == cobroService.calcularHorasParaCobrar(tiempoMilisegundos, vehiculo));
	}
	
	//@Test
	public void calcularCobroVehiculo() throws ParseException, ExceptionTarifaNoEncontrada {
		//Preparar los datos
		when(cobroService.calcularCobro(3, 500)).thenReturn(1500);
		VehiculoDTO vehiculo = new VehiculoDTO("AGJ93D", "M");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		Date fechaInicial = dateFormat.parse("2018-08-23 11:00");
		Date fechaFinal = dateFormat.parse("2018-08-23 14:00");
		vehiculo.setFechaIngreso(fechaInicial);
		vehiculo.setFechaSalida(fechaFinal);
		
		//Assert cuando Se obtiene el objeto tipo moto
		assertTrue(1500 == cobroService.calcularCobroVehiculo(vehiculo));
	}
	
	
	
	

}
