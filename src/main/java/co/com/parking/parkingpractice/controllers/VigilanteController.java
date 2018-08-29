package co.com.parking.parkingpractice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.parking.parkingpractice.business.services.VigilanteService;
import co.com.parking.parkingpractice.ecxceptions.ExcepcionGenerica;
import co.com.parking.parkingpractice.models.SalidaVehiculoDTO;
import co.com.parking.parkingpractice.models.VehiculoDTO;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*")
public class VigilanteController {
	
	@Autowired
	private VigilanteService vigilanteService;
	
    @RequestMapping(value = "/ingresar", method = RequestMethod.POST)
    public void ingresarVehiculo(@RequestBody VehiculoDTO vehiculoDTO) throws ExcepcionGenerica {
    	vigilanteService.ingresaVehiculo(vehiculoDTO);
    }

    @RequestMapping(value = "/salir", method = RequestMethod.POST)
    public ResponseEntity<SalidaVehiculoDTO> salirVehiculo(@RequestBody VehiculoDTO vehiculoDTO) throws ExcepcionGenerica {
    	return new ResponseEntity<>(vigilanteService.salirVehiculo(vehiculoDTO), HttpStatus.OK);
    }
}
