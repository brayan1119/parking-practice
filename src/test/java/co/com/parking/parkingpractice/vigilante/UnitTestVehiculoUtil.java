package co.com.parking.parkingpractice.vigilante;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.com.parking.parkingpractice.ecxceptions.ExecptionCampoInvalido;
import co.com.parking.parkingpractice.util.TiempoUtil;
import co.com.parking.parkingpractice.util.TipoVehiculo;
import co.com.parking.parkingpractice.util.VehiculoUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class UnitTestVehiculoUtil {
	
	//Preparando objeto
	private VehiculoUtil vehiculoUtil = new VehiculoUtil();
	
	@Mock
	TiempoUtil tiempoUtil;
	
	@Test
	public void testTipoVehiculoMoto() throws ExecptionCampoInvalido {
		//Assert cuando Se obtiene el objeto tipo moto
		assertEquals(TipoVehiculo.MOTO.getTipo(), vehiculoUtil.tipoVehiculo("M").getTipo());
	}

	@Test
	public void testTipoVehiculoCarro() throws ExecptionCampoInvalido {
		//Assert cuando Se obtiene el objeto tipo moto
		assertEquals(TipoVehiculo.CARRO.getTipo(), vehiculoUtil.tipoVehiculo("C").getTipo());
	}

	@Test(expected = ExecptionCampoInvalido.class)
	public void testTipoVehiculoError() throws ExecptionCampoInvalido {
		
		//Assert cuando Se obtiene el objeto tipo moto
		assertEquals(TipoVehiculo.CARRO.getTipo(), vehiculoUtil.tipoVehiculo("AA").getTipo());
	}
	
	@Test
	public void puedeEntrarPorDigitoYDia() throws ExecptionCampoInvalido {
		
		//Preparando Los datos
		when(tiempoUtil.getDateToday()).thenReturn(3);
		
		//Assert cuando Se obtiene el objeto tipo moto
		assertTrue(vehiculoUtil.puedeEntrarPorDigitoYDia("AGJ93D"));
	}
	
	@Test
	public void siPuedeEntrarPorDigitoYDia() throws ExecptionCampoInvalido {
		//Assert cuando Se obtiene el objeto tipo moto
		assertTrue(vehiculoUtil.puedeEntrarPorDigitoYDia("QGJ93D"));
	}
	
	@Test(expected = ExecptionCampoInvalido.class)
	public void errorPuedeEntrarPorDigitoYDiaNull() throws ExecptionCampoInvalido {
		//Assert cuando Se obtiene el objeto tipo moto
		vehiculoUtil.puedeEntrarPorDigitoYDia(null);
	}
	
	@Test(expected = ExecptionCampoInvalido.class)
	public void errorPuedeEntrarPorDigitoYDiaVacia() throws ExecptionCampoInvalido {
		//Assert cuando Se obtiene el objeto tipo moto
		vehiculoUtil.puedeEntrarPorDigitoYDia("");
	}
	
	//@Test(expected = ExcepcionGenerica.class)
	public void errorNoPuedeEntrarPorDigitoYDiaDomingo() throws ExecptionCampoInvalido {
		
		//Preparando Los datos
		when(tiempoUtil.getDateToday()).thenReturn(1);
		//Assert cuando Se obtiene el objeto tipo moto
		System.out.println(vehiculoUtil.puedeEntrarPorDigitoYDia("AAJ93D"));
	}
}
