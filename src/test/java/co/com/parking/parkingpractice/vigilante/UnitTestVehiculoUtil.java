package co.com.parking.parkingpractice.vigilante;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.com.parking.parkingpractice.ecxceptions.ExecptionCampoInvalido;
import co.com.parking.parkingpractice.util.TiempoUtil;
import co.com.parking.parkingpractice.util.TipoVehiculo;
import co.com.parking.parkingpractice.util.VehiculoUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UnitTestVehiculoUtil {
	
	@Autowired
	private VehiculoUtil vehiculoUtil ;
	
	@MockBean
	private TiempoUtil tiempoUtil;
	
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
		
		//Assert cuando Lanza la excepcion de tipo invalido el objeto tipo moto
		vehiculoUtil.tipoVehiculo("AA").getTipo();
	}
	
	@Test
	public void puedeEntrarPorDigitoYDia() throws ExecptionCampoInvalido {
		
		//Preparando Los datos
		when(tiempoUtil.esLunesDomingo()).thenReturn(true);
		
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
	
	@Test()
	public void errorNoPuedeEntrarPorDigitoYDiaDomingo() throws ExecptionCampoInvalido {
		
		//Preparando Los datos
		when(tiempoUtil.esLunesDomingo()).thenReturn(false);
		//Assert cuando Se obtiene el objeto tipo moto
		assertFalse(vehiculoUtil.puedeEntrarPorDigitoYDia("AAJ93D"));
	}
}
