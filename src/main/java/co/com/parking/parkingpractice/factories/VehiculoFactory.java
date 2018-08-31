package co.com.parking.parkingpractice.factories;

import org.springframework.stereotype.Component;

import co.com.parking.parkingpractice.models.VehiculoDTO;
import co.com.parking.parkingpractice.persistence.entities.TipoVehiculoEntity;
import co.com.parking.parkingpractice.persistence.entities.VehiculoEntity;

@Component
public class VehiculoFactory {
	
	public VehiculoEntity convertVehiculoToEntity(VehiculoDTO vehiculoDTO) {
		VehiculoEntity entity = new VehiculoEntity();
		entity.setTipo(new TipoVehiculoEntity(vehiculoDTO.getTipo()));
		entity.setPlaca(vehiculoDTO.getPlaca());
		entity.setFechaIngreso(vehiculoDTO.getFechaIngreso());
		entity.setFechaSalida(vehiculoDTO.getFechaSalida());
		entity.setCilindraje(vehiculoDTO.getCilindraje());
		return entity;
	}
	
	public VehiculoDTO convertEntityToVehiculoDTO(VehiculoEntity vehiculoEntity) {
		return new VehiculoDTO(vehiculoEntity.getPlaca(),
				vehiculoEntity.getTipo().getNombre(), vehiculoEntity.getCilindraje(),
				vehiculoEntity.getFechaIngreso(), vehiculoEntity.getFechaSalida());
	}

}
