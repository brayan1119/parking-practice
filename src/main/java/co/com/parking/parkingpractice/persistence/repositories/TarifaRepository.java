package co.com.parking.parkingpractice.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.parking.parkingpractice.persistence.entities.TarifasEntity;

public interface TarifaRepository extends JpaRepository<TarifasEntity, Integer>{

}
