package co.com.parking.parkingpractice.vigilante;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.parking.parkingpractice.ecxceptions.ExcepcionGenerica;
import co.com.parking.parkingpractice.util.TipoVehiculo;
import co.com.parking.parkingpractice.util.VehiculoUtil;

@RunWith(SpringRunner.class)
public class UnitTestVehiculoUtil {
	
	
	@Test
	public void testTipoVehiculoMoto() throws ExcepcionGenerica {
		
		//Assert cuando Se obtiene el objeto tipo moto
		assertEquals(TipoVehiculo.MOTO.getTipo(), VehiculoUtil.tipoVehiculo("M").getTipo());
	}

	@Test
	public void testTipoVehiculoCarro() throws ExcepcionGenerica {
		
		//Assert cuando Se obtiene el objeto tipo moto
		assertEquals(TipoVehiculo.CARRO.getTipo(), VehiculoUtil.tipoVehiculo("C").getTipo());
	}

	@Test(expected = ExcepcionGenerica.class)
	public void testTipoVehiculoError() throws ExcepcionGenerica {
		
		//Assert cuando Se obtiene el objeto tipo moto
		assertEquals(TipoVehiculo.CARRO.getTipo(), VehiculoUtil.tipoVehiculo("AA").getTipo());
	}
	
	@Test
	public void puedeEntrarPorDigitoYDia() throws ExcepcionGenerica {
		
		//Preparando Los datos
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		
		boolean passVariable = day == Calendar.SUNDAY || day == Calendar.MONDAY;
		
		//Assert cuando Se obtiene el objeto tipo moto
		
		assertEquals(!passVariable, VehiculoUtil.puedeEntrarPorDigitoYDia("AGJ93D"));
	}
	
	@Test
	public void siPuedeEntrarPorDigitoYDia() throws ExcepcionGenerica {
		//Assert cuando Se obtiene el objeto tipo moto
		assertTrue(VehiculoUtil.puedeEntrarPorDigitoYDia("QGJ93D"));
	}
	
	@Test(expected = ExcepcionGenerica.class)
	public void errorPuedeEntrarPorDigitoYDiaNull() throws ExcepcionGenerica {
		//Assert cuando Se obtiene el objeto tipo moto
		assertTrue(VehiculoUtil.puedeEntrarPorDigitoYDia(null));
	}
	
	@Test(expected = ExcepcionGenerica.class)
	public void errorPuedeEntrarPorDigitoYDiaVacia() throws ExcepcionGenerica {
		//Assert cuando Se obtiene el objeto tipo moto
		assertTrue(VehiculoUtil.puedeEntrarPorDigitoYDia(""));
	}
}
