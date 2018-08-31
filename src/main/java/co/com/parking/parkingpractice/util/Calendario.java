package co.com.parking.parkingpractice.util;

import java.util.Calendar;

import org.springframework.stereotype.Component;

@Component
public class Calendario {
	
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


}