package co.com.parking.parkingpractice.vigilante;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.when;

import co.com.parking.parkingpractice.business.services.impl.VigilanteServiceImpl;
import co.com.parking.parkingpractice.ecxceptions.ExceptionVehiculoParqueado;
import co.com.parking.parkingpractice.ecxceptions.ExecptionCampoInvalido;
import co.com.parking.parkingpractice.ecxceptions.ExecptionNoHayEspacioTipoVehiculo;
import co.com.parking.parkingpractice.ecxceptions.ExecptionNoPuedeIngresarProresticcionPlacaDia;
import co.com.parking.parkingpractice.models.VehiculoDTO;
import co.com.parking.parkingpractice.util.TiempoUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class UnitTestVigilante {
	
	@MockBean
    private VigilanteServiceImpl vigilanteService;
	
	@Mock
	private TiempoUtil tiempoUtil;
	
	// Prueba que consiste en no ingresar vehiculo por regla del dia lunes o domingo y su  placa empieza por A
	//@Test(expected = ExcepcionGenerica.class)
	public void TestNoInsertPorPlacaYDia() throws ExceptionVehiculoParqueado, ExecptionNoHayEspacioTipoVehiculo, ExecptionCampoInvalido, ExecptionNoPuedeIngresarProresticcionPlacaDia{
		
		// Inicializando los objetos para la prueba
		when(tiempoUtil.getDateToday()).thenReturn(1);
		VehiculoDTO vehiculo = new VehiculoDTO("AGJ93D", "M");
		//Realizando prueba
		vigilanteService.ingresaVehiculo(vehiculo);
		// Assert cuando el metodo arroje la excepcion ExcepcionGenerica
		
	}
	
	@Test(expected = Test.None.class)
	public void TestInsertPorPlacaYDia() throws ExceptionVehiculoParqueado, ExecptionNoHayEspacioTipoVehiculo, ExecptionCampoInvalido, ExecptionNoPuedeIngresarProresticcionPlacaDia {
		
		// Inicializando los objetos para la prueba
		//PowerMockito.mockStatic(VehiculoUtil.class);
		when(tiempoUtil.getDateToday()).thenReturn(3);
		VehiculoDTO vehiculo = new VehiculoDTO("AGJ93D", "M");
		//Realizando prueba
		vigilanteService.ingresaVehiculo(vehiculo);
		// Assert cuando no lanza exepcion
	}
	
	

}
