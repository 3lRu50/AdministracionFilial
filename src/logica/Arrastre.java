package logica;

public class Arrastre extends Grupo {

	private Asignatura arrastre;

	public Arrastre(int anio, Asignatura arrastre){

		super(anio);
		setAsignatura(arrastre);

	}

	public Asignatura getAsignatura(){

		return arrastre;
	}

	public void setAsignatura(Asignatura arrastre){

		if(arrastre == null || arrastre.getAnio() != super.getAnio()-1)
			throw new IllegalArgumentException("Error.La asignatura es incorrecta");

		this.arrastre = arrastre;
	}

}
