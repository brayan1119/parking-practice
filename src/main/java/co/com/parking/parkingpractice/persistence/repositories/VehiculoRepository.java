package co.com.parking.parkingpractice.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.parking.parkingpractice.persistence.entities.VehiculoEntity;

@Repository
public interface VehiculoRepository extends JpaRepository<VehiculoEntity, Integer>{
	
	@Query(value = "SELECT count(*) FROM vehiculo v WHERE v.tipo = :tipo", 
		  nativeQuery = true)
	public int contarVehiculoXTipo(@Param("tipo") String tipo);
}
