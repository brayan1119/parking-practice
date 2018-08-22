package co.com.parking.parkingpractice.business.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.parking.parkingpractice.business.services.VehiculoService;
import co.com.parking.parkingpractice.ecxceptions.ExcepcionGenerica;
import co.com.parking.parkingpractice.models.VehiculoDTO;
import co.com.parking.parkingpractice.persistence.repositories.VehiculoRepository;

@Service
public class VehiculoServiceImpl implements VehiculoService {
	
	@Autowired
	private VehiculoRepository vehiculoRepository;
	
	@Transactional
	public void insertarVehivculo(VehiculoDTO vehiculo) throws ExcepcionGenerica {
		vehiculoRepository.save(vehiculo.convertVehiculoToEntity());
	}
	
	@Transactional
	public int contarVehiculoXTipo(String tipo) {
		return vehiculoRepository.contarVehiculoXTipo(tipo);
	}
}
