package co.com.parking.parkingpractice.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.parking.parkingpractice.models.ConsultaParqueadosDTO;
import co.com.parking.parkingpractice.persistence.entities.VehiculoEntity;

@Repository
public interface VehiculoRepository extends JpaRepository<VehiculoEntity, String>{
	
	@Query(value = "SELECT count(*) "
			+ "FROM vehiculo v "
			+ "WHERE v.tipo = :tipo", 
		  nativeQuery = true)
	public int contarVehiculoXTipo(@Param("tipo") String tipo);
	
	@Query(value = "SELECT count(*) "
			+ "FROM vehiculo v "
			+ "WHERE v.placa = :placa "
			+ "AND v.fecha_salida is null", 
			  nativeQuery = true)
	public int validarVehiculoEstaAdentro(@Param("placa") String placa);
	
	@Modifying
	@Query("update vehiculo v set v.fechaSalida = SYSDATE where v.placa = :placa")
	public int actualizarSalidaVehiculo(@Param("placa") String placa);
	
	@Query(value = "SELECT new co.com.parking.parkingpractice.models.ConsultaParqueadosDTO("
			+ "v.placa, "
			+ "v.tipo, "
			+ "v.fechaIngreso) "
			+ "FROM vehiculo v "
			+ "WHERE v.fechaSalida is null")
	public List<ConsultaParqueadosDTO> obtenerVehiculosParqueados();
}
