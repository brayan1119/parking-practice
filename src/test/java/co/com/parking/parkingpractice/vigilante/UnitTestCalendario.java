package co.com.parking.parkingpractice.vigilante;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import co.com.parking.parkingpractice.util.Calendario;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UnitTestCalendario {

	@Autowired
	private Calendario calendario;
	
	@Test
	public void esLunesDomingo() {
		int dia = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		boolean esLunesDomingo = dia == Calendar.SUNDAY || dia == Calendar.MONDAY;
		
		assertEquals(esLunesDomingo, calendario.esLunesDomingo());
	}
}
