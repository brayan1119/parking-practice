package co.com.parking.parkingpractice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.parking.parkingpractice.business.services.VehiculoService;
import co.com.parking.parkingpractice.models.ConsultaParqueadosDTO;

@RestController
@RequestMapping("api/vehiculo")
@CrossOrigin(origins = "*")
public class VehiculoContorller {

	@Autowired
	private VehiculoService vehiculoService;
	
    @RequestMapping(value = "/consultar-vehiculos-parqueados", method = RequestMethod.GET)
    public ResponseEntity<List<ConsultaParqueadosDTO>> consultaVehiculos() {
        return new ResponseEntity<>(vehiculoService.obtenerVehiculosParqueados(), HttpStatus.OK);
    }
}
