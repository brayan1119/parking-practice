package co.com.parking.parkingpractice.util;

import java.util.Calendar;

public class TiempoUtil {
	
	public TiempoUtil() {
		super();
	}
	
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
