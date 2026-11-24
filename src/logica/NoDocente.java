package logica;

import enums.AreaLaboral;

public class NoDocente extends Trabajador {
	private AreaLaboral areaLaboral;

	public NoDocente(String carnetId, String nombre, String direccion, double salario, AreaLaboral areaLaboral) {
		super(carnetId, nombre, direccion, salario);
		
		setAreaLaboral(areaLaboral);
	}

	public final AreaLaboral getAreaLaboral() {
		return areaLaboral;
	}

	public final void setAreaLaboral(AreaLaboral areaLaboral) {
		this.areaLaboral = areaLaboral;
	}	
}
