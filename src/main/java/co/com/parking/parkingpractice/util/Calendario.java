package co.com.parking.parkingpractice.util;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Calendario {


	private static final int HORAS_MILISEGUNDOS = 3600000;
	
	public boolean esLunesDomingo() {
		
		int day = getDateToday();
		return day == Calendar.SUNDAY || day == Calendar.MONDAY;
	}

	public Calendar getDateInstant() {
		return Calendar.getInstance();
	}
	
	public int getDateToday() {
		return getDateInstant().get(Calendar.DAY_OF_WEEK);
	}
	
	public double diferenciaTiempoHoras(Date fechaInicio, Date fechaFin) {
		return (double)(fechaFin.getTime() - fechaInicio.getTime()) / HORAS_MILISEGUNDOS;
	}

}
