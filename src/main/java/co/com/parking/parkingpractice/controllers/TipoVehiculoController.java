package co.com.parking.parkingpractice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.parking.parkingpractice.business.services.TipoVehiculoService;
import co.com.parking.parkingpractice.models.TipoVehiculoDTO;

@RestController
@RequestMapping("api/tipo-vehiculo")
@CrossOrigin(origins = "*")
public class TipoVehiculoController {
	
	@Autowired
	private TipoVehiculoService tipoVehiculoService;
	
    @RequestMapping(value = "/obtener-tipos", method = RequestMethod.GET)
    public ResponseEntity<List<TipoVehiculoDTO>> consultaVehiculos() {
        return new ResponseEntity<>(tipoVehiculoService.obtenerTiposVehiculos(), HttpStatus.OK);
    }

}
