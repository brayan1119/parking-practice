package co.com.parking.parkingpractice.auxiliar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import co.com.parking.parkingpractice.constantes.CamposConstantes;
import co.com.parking.parkingpractice.constantes.MensajesConstantes;
import co.com.parking.parkingpractice.ecxceptions.ExecptionCampoInvalido;
import co.com.parking.parkingpractice.util.Calendario;

@Component
public class VigilanteAuxiliar {
	
	@Autowired
	private Calendario calendario;
	
	public boolean puedeEntrarPorDigitoYDia(String placa) throws ExecptionCampoInvalido {

		if(StringUtils.isEmpty(placa)) {
			throw new ExecptionCampoInvalido(MensajesConstantes.MENSAJE_PLACA_VACIA, CamposConstantes.NOMBRE_CAMPO_PLACA);
		}
		
		return (!placa.startsWith(CamposConstantes.INICIAL_PLACA)) || calendario.esLunesDomingo();
	}
	
}
