package logica;

public class Arrastre extends Grupo {

	private String arrastre;

	public Arrastre(int anio, String arrastre){

		super(anio);
		setAsignatura(arrastre);

	}

	public String getAsignatura(){

		return arrastre;
	}

	public void setAsignatura(String arrastre){

		PlanEstudio plan = PlanEstudio.getInstancia();
		if(!plan.existeAsignatura(arrastre))
			throw new IllegalArgumentException("Error.La asignatura es incorrecta");

		this.arrastre = arrastre;
	}

}
