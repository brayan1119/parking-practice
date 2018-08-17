package co.com.parking.parkingpractice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.parking.parkingpractice.business.services.VehiculoService;
import co.com.parking.parkingpractice.models.VehiculoDTO;

@RestController
@RequestMapping("api")
public class VehiculoController {
	
	@Autowired
	private VehiculoService vehiculoService;
	
    @RequestMapping(value = "/people", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<VehiculoDTO> getPeople(VehiculoDTO vehiculoDTO) {
        return new ResponseEntity<>(vehiculoService.saveVehivculo(vehiculoDTO), HttpStatus.OK);
    }

}
