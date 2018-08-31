package co.com.parking.parkingpractice.factories;

import org.springframework.stereotype.Component;

import co.com.parking.parkingpractice.models.TipoVehiculoDTO;
import co.com.parking.parkingpractice.persistence.entities.TipoVehiculoEntity;

@Component
public class TipoVehiculoFactory {
	
	public TipoVehiculoDTO entityToDTO(TipoVehiculoEntity entity) {
		return new TipoVehiculoDTO(entity.getTipo(), entity.getNombre());
	}

}
