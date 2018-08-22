package co.com.parking.parkingpractice.vigilante;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

import co.com.parking.parkingpractice.business.services.VehiculoService;
import co.com.parking.parkingpractice.business.services.VigilanteService;
import co.com.parking.parkingpractice.ecxceptions.ExcepcionGenerica;
import co.com.parking.parkingpractice.models.VehiculoDTO;
import co.com.parking.parkingpractice.util.VehiculoUtil;

@RunWith(SpringRunner.class)
@PrepareForTest({VehiculoUtil.class})
public class UnitTestVigilante {
	
	@Autowired
    private VigilanteService vigilanteService;
	
	@MockBean
	private VehiculoService vehiculoService;
	
	// Prueba que consiste en no ingresar vehiculo por regla del dia lunes o domingo y su  placa empieza por A
	//@Test(expected = ExcepcionGenerica.class)
	public void TestNoInsertPorPlacaYDia() throws ExcepcionGenerica {
		
		// Inicializando los objetos para la prueba
		PowerMockito.mockStatic(VehiculoUtil.class);
		when(VehiculoUtil.puedeEntrarPorDigitoYDia("AGJ93D")).thenReturn(false);
		VehiculoDTO vehiculo = new VehiculoDTO("AGJ93D", "M");
		//Realizando prueba
		vigilanteService.ingresaVehiculo(vehiculo);
		// Assert cuando el metodo arroje la excepcion ExcepcionGenerica
		
	}
	
	

}
