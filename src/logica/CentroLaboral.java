package logica;

import static logica.Persona.stringValido;

public class CentroLaboral {
	private String centroLaboral;
	private String organismo;




	public CentroLaboral(String centroLaboral, String organismo) {
		setCentroLaboral(centroLaboral);
		setOrganismo(organismo);
	}

	public final void setCentroLaboral(String centroLaboral) {
		stringValido("centro laboral", centroLaboral);

		this.centroLaboral = centroLaboral;
	}

	public final String getOrganismo() {
		return organismo;
	}

	public final void setOrganismo(String organismo) {
		stringValido("organismo", organismo);

		this.organismo = organismo;
	}

	public final String getCentroLaboral(){ 
		return centroLaboral; 
	}

}
