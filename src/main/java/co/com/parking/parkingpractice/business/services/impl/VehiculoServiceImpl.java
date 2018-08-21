package co.com.parking.parkingpractice.business.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.parking.parkingpractice.business.services.VehiculoService;
import co.com.parking.parkingpractice.models.VehiculoDTO;
import co.com.parking.parkingpractice.persistence.repositories.VehiculoRepository;

@Service
public class VehiculoServiceImpl implements VehiculoService {
	
	@Autowired
	private VehiculoRepository vehiculoRepository;
	
	@Transactional
	public void saveVehivculo(VehiculoDTO vehiculo) {
		vehiculoRepository.save(vehiculo.convertVehiculoToEntity());
	}
}
