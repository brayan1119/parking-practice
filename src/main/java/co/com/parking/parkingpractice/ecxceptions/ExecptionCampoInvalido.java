package co.com.parking.parkingpractice.ecxceptions;

public class ExecptionCampoInvalido extends ExcepcionGenerica {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1550194641694756132L;
	private final String nombreCampo;
	
	public ExecptionCampoInvalido(String message, String nombreCampo) {
		super(message);
		this.nombreCampo = nombreCampo;
	}

	public String getNombreCampo() {
		return nombreCampo;
	}
	
}
