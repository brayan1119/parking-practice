package co.com.parking.parkingpractice.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.parking.parkingpractice.persistence.entities.TipoVehiculoEntity;

@Repository
public interface TipoVehiculoRepository extends JpaRepository<TipoVehiculoEntity, String>{
	
	@Query("SELECT t.tope "
			+ "FROM tipo_vehiculo t "
			+ "WHERE t.tipo = :tipo ")
	public int vehiculosParqueadoPorTipo(@Param("tipo") String tipo);

}
