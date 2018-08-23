package co.com.parking.parkingpractice.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "tarifas")
public class TarifasEntity {

    @Id
    private Integer id;
    
    @Column(name = "nombre_tarifa", nullable = false)
    private String nombreTarifa;
    
    @Column(name = "costo_tarifa", nullable = false)
    private int costoTarifa;
    
    public int getCostoTarifa() {
    	return this.costoTarifa;
    }
}
