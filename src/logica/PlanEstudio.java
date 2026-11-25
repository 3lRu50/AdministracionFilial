package logica;

import java.util.ArrayList;

public class PlanEstudio {

	private String nombre;
	private ArrayList<Asignatura> asignaturas;
	
	private static final PlanEstudio instancia = new PlanEstudio();
	
	  private PlanEstudio() {
	        asignaturas = new ArrayList<>();
	        this.nombre = "Plan de Estudio FCT";
	    }
	
	  public static PlanEstudio getInstancia() {
	        return instancia;
	    }
	
	public void agregarAsignatura(String nombre, int anio, int semestre, int horas){
	
		  Asignatura nueva = new Asignatura(nombre, anio, semestre, horas);
	        if (asignaturas.contains(nueva))
	            throw new IllegalArgumentException("Error. La asignatura ya existe en el plan: " + nombre);
	        asignaturas.add(nueva);
	}
	public ArrayList<Asignatura> getAsignatura(){
		
		return asignaturas;
	}
}
