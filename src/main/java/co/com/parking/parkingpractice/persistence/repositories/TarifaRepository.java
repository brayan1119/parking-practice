package co.com.parking.parkingpractice.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.parking.parkingpractice.persistence.entities.TarifasEntity;

@Repository
public interface TarifaRepository extends JpaRepository<TarifasEntity, Integer>{

}
