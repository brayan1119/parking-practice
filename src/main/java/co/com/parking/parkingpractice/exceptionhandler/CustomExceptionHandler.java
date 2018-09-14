package co.com.parking.parkingpractice.exceptionhandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.com.parking.parkingpractice.ecxceptions.ExcepcionGenerica;
import co.com.parking.parkingpractice.ecxceptions.ExceptionSalidaNoRegistrada;
import co.com.parking.parkingpractice.ecxceptions.ExceptionTarifaNoEncontrada;
import co.com.parking.parkingpractice.ecxceptions.ExceptionVehiculoParqueado;
import co.com.parking.parkingpractice.ecxceptions.ExecptionCampoInvalido;
import co.com.parking.parkingpractice.ecxceptions.ExecptionNoHayEspacioTipoVehiculo;
import co.com.parking.parkingpractice.ecxceptions.ExecptionNoPuedeIngresarProresticcionPlacaDia;
import co.com.parking.parkingpractice.ecxceptions.ExecptionVehiculoNoPaqueado;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	
	  @ExceptionHandler(value = {ExceptionSalidaNoRegistrada.class,
			  ExceptionTarifaNoEncontrada.class,
			  ExceptionVehiculoParqueado.class,
			  ExecptionCampoInvalido.class,
			  ExecptionNoHayEspacioTipoVehiculo.class,
			  ExecptionNoPuedeIngresarProresticcionPlacaDia.class,
			  ExecptionVehiculoNoPaqueado.class})
	  public final ResponseEntity<ExcepcionGenerica> handleSalidaNoRegistrada(ExcepcionGenerica ex) {
	    return new ResponseEntity<>(ex, HttpStatus.CONFLICT);
	  }

}
