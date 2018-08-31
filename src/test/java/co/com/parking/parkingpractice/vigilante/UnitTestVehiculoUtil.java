package co.com.parking.parkingpractice.vigilante;

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

import co.com.parking.parkingpractice.auxiliar.VigilanteAuxiliar;
import co.com.parking.parkingpractice.ecxceptions.ExecptionCampoInvalido;
import co.com.parking.parkingpractice.util.Calendario;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UnitTestVehiculoUtil {
	
	@Autowired
	private VigilanteAuxiliar vigilanteAuxiliar;
	
	@MockBean
	private Calendario calendario;
	
	@Test
	public void puedeEntrarPorDigitoYDia() throws ExecptionCampoInvalido {
		
		//Preparando Los datos
		when(calendario.esLunesDomingo()).thenReturn(true);
		
		//Assert cuando Se obtiene el objeto tipo moto
		assertTrue(vigilanteAuxiliar.puedeEntrarPorDigitoYDia("AGJ93D"));
	}
	
	@Test
	public void siPuedeEntrarPorDigitoYDia() throws ExecptionCampoInvalido {
		//Assert cuando Se obtiene el objeto tipo moto
		assertTrue(vigilanteAuxiliar.puedeEntrarPorDigitoYDia("QGJ93D"));
	}
	
	@Test(expected = ExecptionCampoInvalido.class)
	public void errorPuedeEntrarPorDigitoYDiaNull() throws ExecptionCampoInvalido {
		//Assert cuando Se obtiene el objeto tipo moto
		vigilanteAuxiliar.puedeEntrarPorDigitoYDia(null);
	}
	
	@Test(expected = ExecptionCampoInvalido.class)
	public void errorPuedeEntrarPorDigitoYDiaVacia() throws ExecptionCampoInvalido {
		//Assert cuando Se obtiene el objeto tipo moto
		vigilanteAuxiliar.puedeEntrarPorDigitoYDia("");
	}
	
	@Test()
	public void errorNoPuedeEntrarPorDigitoYDiaDomingo() throws ExecptionCampoInvalido {
		
		//Preparando Los datos
		when(calendario.esLunesDomingo()).thenReturn(false);
		//Assert cuando Se obtiene el objeto tipo moto
		assertFalse(vigilanteAuxiliar.puedeEntrarPorDigitoYDia("AAJ93D"));
	}
}
