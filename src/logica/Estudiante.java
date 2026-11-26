package logica;

import java.util.ArrayList;

public class Estudiante extends Persona {
	private ArrayList<Evaluacion> notas = new ArrayList<>();
	private CentroLaboral centro;

	public Estudiante(String carnetId, String nombre, String direccion, String centroLaboral, String organismo) {
		super(carnetId, nombre, direccion);
		centro = new CentroLaboral(centroLaboral, organismo);
	}

	public final void setCentroLaboral(String centroLaboral) {
		centro.setCentroLaboral(centroLaboral);
	}

	public final String getOrganismo() {
		return centro.getOrganismo();
	}

	public final void setOrganismo(String organismo) {
		centro.setOrganismo(organismo);
	}
	
	public final String getCentroLaboral(){ 
		return centro.getCentroLaboral(); 
	}


	
	
	
	public final void agregarNota(String asignatura, int pruebaFinal, int revalorizacion){
		validacionExisteAsignatura(asignatura);
		
		notas.add(new Evaluacion(asignatura, pruebaFinal, revalorizacion));
	}
	
	public final void agregarNota(String asignatura, int notaFinal){
			validacionExisteAsignatura(asignatura);
			
			notas.add(new Evaluacion(asignatura, notaFinal));
	}


	public final void agregarAbonada(String asignatura, int nota){
		validacionExisteAsignatura(asignatura);
		
		notas.add(new Evaluacion(asignatura, nota, true));
	}
	
	
	
	
	
	public final boolean asignaturaEvaluada(String asignatura){
		boolean evaluada = false;
		
		for(int asig = 0; asig < notas.size() && !evaluada; asig++)
			if(notas.get(asig).getAsignatura().equalsIgnoreCase(asignatura))
				evaluada = true;
		
		return evaluada;
	}
	
	private final void validacionExisteAsignatura(String asignatura){
		if(asignaturaEvaluada(asignatura))
			throw new IllegalArgumentException("ERROR: asignatura "+ asignatura +" ya evaluada");
	}

	
	
	
	public final ArrayList<String> getAprobadas(){
		ArrayList<String> aprobadas = new ArrayList<>();
		
		for(Evaluacion nota : notas)
			if(nota.isAprobado())
				aprobadas.add(nota.getAsignatura());
		
		return aprobadas;
	}
	
	
	public final ArrayList<String> getAprobadasPruebaF(){
		ArrayList<String> aprobadas = new ArrayList<>();
		
		for(Evaluacion nota : notas)
			if(nota.isAprobadoPF())
				aprobadas.add(nota.getAsignatura());
		
		return aprobadas;
	}


	public final ArrayList<String> getAprobadasRe(){
		ArrayList<String> aprobadas = new ArrayList<>();
		
		for(Evaluacion nota : notas)
			if(nota.isAprobadoRe())
				aprobadas.add(nota.getAsignatura());
		
		return aprobadas;
	}

	

	public final ArrayList<String> getAbonadas(){
		ArrayList<String> abonadas = new ArrayList<>();
		
		for(Evaluacion nota : notas)
			if(nota.isAbonado())
				abonadas.add(nota.getAsignatura());
		
		return abonadas;
	}


	public final ArrayList<String> getMundiales(){
		ArrayList<String> mundiales = new ArrayList<>();
		
		for(Evaluacion nota : notas)
			if(nota.isMundialista())
				mundiales.add(nota.getAsignatura());
		
		return mundiales;
	}

	
}

