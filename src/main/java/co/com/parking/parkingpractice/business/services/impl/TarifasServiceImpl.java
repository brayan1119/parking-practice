package co.com.parking.parkingpractice.business.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.parking.parkingpractice.business.services.TarifasService;
import co.com.parking.parkingpractice.constantes.MensajesConstantes;
import co.com.parking.parkingpractice.ecxceptions.ExceptionTarifaNoEncontrada;
import co.com.parking.parkingpractice.persistence.entities.TarifasEntity;
import co.com.parking.parkingpractice.persistence.repositories.TarifaRepository;

@Service
public class TarifasServiceImpl implements TarifasService {

	@Autowired
	private TarifaRepository tarifaRepository;
	
	@Override
	public int consultaTarifaDeVehiculo(Integer idTarifa) throws ExceptionTarifaNoEncontrada {
		Optional<TarifasEntity> tarifaEntity = tarifaRepository.findById(idTarifa);
	
		if(tarifaEntity.isPresent()) {
			return tarifaEntity.get().getCostoTarifa();
		}else {
			throw new ExceptionTarifaNoEncontrada(MensajesConstantes.MENSAJE_TARIFA_NO_ENCONTRADA);	
		}
	}

}
