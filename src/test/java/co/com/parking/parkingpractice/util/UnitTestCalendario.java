package co.com.parking.parkingpractice.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.com.parking.parkingpractice.ecxceptions.ExcepcionGenerica;
import co.com.parking.parkingpractice.util.Calendario;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UnitTestCalendario {

	@Autowired
	private Calendario calendario;
	
	@Test
	public void esLunesDomingo() {
		int dia = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		boolean esLunesDomingo = dia == Calendar.SUNDAY || dia == Calendar.MONDAY;
		
		assertEquals(esLunesDomingo, calendario.esLunesDomingo());
	}
	
	@Test
	public void cantidadDias() throws ExcepcionGenerica, ParseException {
		//Preparar los datos
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaInicial = dateFormat.parse("2018-02-14");
		Date fechaFinal = dateFormat.parse("2018-02-16");
		//Assert cuando Se obtiene el objeto tipo moto
		assertTrue(48.0 == calendario.diferenciaTiempoHoras(fechaInicial, fechaFinal));
	}
}
