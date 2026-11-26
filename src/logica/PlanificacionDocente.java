package logica;

public class PlanificacionDocente {

	private Profesor profesor;
	private Asignatura asignatura;
	private Grupo grupo;
	
	
	public PlanificacionDocente(Profesor profesor, Asignatura asignatura, Grupo grupo){
		
		setProfesor(profesor);
		setAsignatura(asignatura);
		setGrupo(grupo);
	}

	public Profesor getProfesor(){
		return this.profesor;
	}
	
	public void setProfesor(Profesor profesor){
		
		this.profesor = profesor;
	}
	
	public Asignatura getAsignatura(){
		return this.asignatura;
	}
	
	public void setAsignatura(Asignatura asignatura){
		
		this.asignatura = asignatura;
	}
	
	public Grupo getGrupo(){
		return this.grupo;
	}
	
	public void setGrupo(Grupo grupo){
		
		this.grupo = grupo;
	}
	
}
