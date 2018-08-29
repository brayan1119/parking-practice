package co.com.parking.parkingpractice.business.services.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.parking.parkingpractice.business.services.VehiculoService;
import co.com.parking.parkingpractice.constantes.MensajesConstantes;
import co.com.parking.parkingpractice.ecxceptions.ExceptionSalidaNoRegistrada;
import co.com.parking.parkingpractice.models.ConsultaParqueadosDTO;
import co.com.parking.parkingpractice.models.VehiculoDTO;
import co.com.parking.parkingpractice.persistence.entities.VehiculoEntity;
import co.com.parking.parkingpractice.persistence.repositories.VehiculoRepository;

@Service
public class VehiculoServiceImpl implements VehiculoService {
	
	@Autowired
	private VehiculoRepository vehiculoRepository;
	
	@Override
	@Transactional
	public void insertarVehivculo(VehiculoDTO vehiculo) {
		vehiculo.setFechaSalida(null);
		vehiculoRepository.save(vehiculo.convertVehiculoToEntity());
	}
	
	@Override
	@Transactional
	public int contarVehiculoXTipo(String tipo) {
		return vehiculoRepository.contarVehiculoXTipo(tipo);
	}
	
	@Override
	@Transactional
	public boolean validarVehiculoEstaAdentro(String placa){
		int cantidadVehiculosEnParqueo = vehiculoRepository.validarVehiculoEstaAdentro(placa);
		return cantidadVehiculosEnParqueo > 0;
	}
	
	@Override
	@Transactional
	public void actualizarSalidaVehiculo(VehiculoDTO vehiculo) throws ExceptionSalidaNoRegistrada {
		int filasActulizadas =vehiculoRepository.actualizarSalidaVehiculo(vehiculo.getPlaca());
		if(filasActulizadas < 1) {
			throw new ExceptionSalidaNoRegistrada(MensajesConstantes.MENSAJE_SALIDA_NO_REGISTRADA);
		}
	}
	
	@Override
	@Transactional
	public List<ConsultaParqueadosDTO> obtenerVehiculosParqueados() {
		return vehiculoRepository.obtenerVehiculosParqueados();
	}
	
	@Override
	@Transactional
	public VehiculoDTO obtenerVehiculoXPlaca(String placa) {
		Optional<VehiculoEntity> vehiculo = vehiculoRepository.findById(placa);
		
		return vehiculo.map(vehiculoEntity -> new VehiculoDTO(vehiculoEntity)).orElse(null);
	}
}
