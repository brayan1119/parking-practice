package co.com.parking.parkingpractice.vigilante;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.com.parking.parkingpractice.business.services.TipoVehiculoService;
import co.com.parking.parkingpractice.business.services.VigilanteService;
import co.com.parking.parkingpractice.ecxceptions.ExcepcionGenerica;
import co.com.parking.parkingpractice.ecxceptions.ExecptionNoHayEspacioTipoVehiculo;
import co.com.parking.parkingpractice.ecxceptions.ExecptionNoPuedeIngresarProresticcionPlacaDia;
import co.com.parking.parkingpractice.models.VehiculoDTO;
import co.com.parking.parkingpractice.util.Calendario;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UnitTestVigilanteServiceImpl {

	@Autowired
	private VigilanteService vigilanteService;
	
	@MockBean
	private TipoVehiculoService tipoVehiculoService;
	
	@MockBean
	private Calendario calendario;
	
	@Test(expected = ExecptionNoHayEspacioTipoVehiculo.class)
	public void noHayEspacioMoto() throws ExcepcionGenerica {
		
		//Preparando Los datos
		when(tipoVehiculoService.capacidadPorTipo("M")).thenReturn(0);
		
		//Assert cuando Se obtiene el objeto tipo moto
		vigilanteService.ingresaVehiculo(new VehiculoDTO("LGJ93D", "M"));
	}
	
	@Test(expected = ExecptionNoPuedeIngresarProresticcionPlacaDia.class)
	public void puedeEntrarPorDigitoYDia() throws ExcepcionGenerica {
		
		//Preparando Los datos
		when(tipoVehiculoService.capacidadPorTipo("M")).thenReturn(10);
		when(calendario.esLunesDomingo()).thenReturn(false);
		
		//Assert cuando Se obtiene el objeto tipo moto
		vigilanteService.ingresaVehiculo(new VehiculoDTO("AQJ93D", "M"));
	}
}
