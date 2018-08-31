package co.com.parking.parkingpractice.business.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.parking.parkingpractice.business.services.TipoVehiculoService;
import co.com.parking.parkingpractice.models.TipoVehiculoDTO;
import co.com.parking.parkingpractice.persistence.repositories.TipoVehiculoRepository;
import co.com.parking.parkingpractice.factories.TipoVehiculoFactory;

@Service
public class TipoVehiculoServiceImpl implements TipoVehiculoService {

	@Autowired
	private TipoVehiculoRepository tipoVehiculoRepository;
	
	@Autowired
	private TipoVehiculoFactory tipoVehiculoFactory;

	@Override
	public int capacidadPorTipo(String tipo) {
		return tipoVehiculoRepository.vehiculosParqueadoPorTipo(tipo);
	}

	@Override
	public List<TipoVehiculoDTO> obtenerTiposVehiculos() {
		return tipoVehiculoRepository.findAll()
				.stream()
				.map(entity -> tipoVehiculoFactory.entityToDTO(entity))
				.collect(Collectors.toList());
	}
	
}
