package co.com.parking.parkingpractice.business.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.parking.parkingpractice.business.services.TipoVehiculoService;
import co.com.parking.parkingpractice.persistence.repositories.TipoVehiculoRepository;

@Service
public class TipoVehiculoServiceImpl implements TipoVehiculoService {

	@Autowired
	private TipoVehiculoRepository tipoVehiculoRepository;

	@Override
	public int capacidadPorTipo(String tipo) {
		return tipoVehiculoRepository.vehiculosParqueadoPorTipo(tipo);
	}
	
}
