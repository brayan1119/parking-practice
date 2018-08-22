package co.com.parking.parkingpractice.ecxceptions;

public class ExcepcionGenerica extends Exception {

	private static final long serialVersionUID = -6933619244805228385L;
	
	  public ExcepcionGenerica() {
		  super(); 
	  }
	  public ExcepcionGenerica(String message) {
		  super(message);
	  }
	  public ExcepcionGenerica(String message, Throwable cause) {
		  super(message, cause);
	  }
	  public ExcepcionGenerica(Throwable cause) {
		  super(cause);
	 }

}
