package co.com.parking.parkingpractice.util;

import java.util.Calendar;

public final class TiempoUtil {
	
	private TiempoUtil() {
		super();
	}
	
	public static boolean esLunesDomingo() {
		
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		
		return day == Calendar.SUNDAY || day == Calendar.MONDAY;
	}

}
