package logica;

import java.util.ArrayList;

public class Anio {

	private int anioAcademico;
	private ArrayList<Estudiante> estudiantes;
	private  ArrayList<Grupo> grupos;
	private ArrayList<Semestre> semestres;
	private ArrayList<PlanificacionDocente> planificaciones;
	
	public Anio(int numero){

		setAnio(numero);
		estudiantes = new ArrayList<Estudiante>();
		grupos = new ArrayList<Grupo>();
		crearGrupos();
		semestres = new ArrayList<Semestre>();
		crearSemestres();
		planificaciones = new ArrayList<PlanificacionDocente> ();
	}

	public int getAnio(){
		return anioAcademico;
	}

	public void setAnio(int anio){

		if(anio < 1 || anio > 6)
			throw new IllegalArgumentException("Error.El año debe estar entre 1 y 6");

		this.anioAcademico = anio;
	}


	private void crearGrupos(){
		int i = 0;
		for(i = 0; i < 4; i++){
			Grupo g = new Grupo(anioAcademico);
			grupos.add(g);
		}
	}


	private void crearSemestres(){
		int i = 0;
		for(i = 0; i < 2; i++){
			Semestre s = new Semestre(anioAcademico,i+1);
			semestres.add(s);
		}
	}

	public void agregarEstudiante(String carnetId, String nombre, String direccion, String centroLaboral, String organismo){

		Estudiante e = new Estudiante(carnetId,nombre,direccion,centroLaboral,organismo);
		estudiantes.add(e);	
		agregarGrupo(e);
		agregarEnArrastre(e);
	}

	private void agregarGrupo(Estudiante e){

		Grupo menor = grupos.get(0);

		for(Grupo g : grupos){
			if( g.getCantEstudiantes() < menor.getCantEstudiantes()){
				menor = g;
			}
		}

		menor.agregarEstudiante(e);
	}


	private void agregarEnArrastre(Estudiante e){

		if(e.getArrastre() != null){
			for(Asignatura a : e.getArrastre()){
				semestres.get(a.getSemestre()-1).agregarEstudianteArrastres(e, a);
			}	
		}
	}

	public boolean existeId(String id){

		boolean encontrado = false;
		int i;
		for(i = 0; i < estudiantes.size() && !encontrado; i++){
			if(e.carnetEs(id))
				encontrado = true;
		}
		return encontrado;
	}
	
	public void crearPlanificacion(Profesor profesor, Asignatura asignatura, Grupo grupo){
		
		if(profesor == null || asignatura == null || grupo == null)
		throw new IllegalArgumentException("Error. Debe ingresar todos los datos");
		
		if(asignatura.getAnio() != anioAcademico)
			throw new IllegalArgumentException("Error. La asignatura no corresponde a este año");
		
		if(grupo.getAnio() != anioAcademico)
			throw new IllegalArgumentException("Error. El grupo no corresponde a este año");
		
		PlanificacionDocente plan = new PlanificacionDocente(profesor,asignatura,grupo);
		existePlanificacion(plan);
		planificaciones.add(plan);
			
	}
	
	private void existePlanificacion(PlanificacionDocente p){
		
		for(PlanificacionDocente plan : planificaciones){
			if(p.getAsignatura() == plan.getAsignatura() && p.getGrupo() == plan.getGrupo() && p.getProfesor() == plan.getProfesor())
				throw new IllegalArgumentException("Error. Esta planificación ya existe"); 
		}
	}
}


