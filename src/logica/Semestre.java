package logica;

import java.util.ArrayList;

public class Semestre {

	private int anio;
	private int numeroSemestre;
	private  ArrayList<Arrastre> gruposArrastre;

	public Semestre(int anio, int numero){

		setAnio(anio);
		setNumeroSemestre(numero);
		gruposArrastre = new ArrayList<Arrastre>();

	}


	public int getAnio(){
		return anio;
	}

	public void setAnio(int anio){

		if(anio < 1 || anio > 6)
			throw new IllegalArgumentException("Error.El año debe estar entre 1 y 6");

		this.anio = anio;
	}

	public int getNumeroSemestre(){
		return numeroSemestre;
	}

	public void setNumeroSemestre(int numero){

		if(numero != 1 && numero != 2)
			throw new IllegalArgumentException("Error.El número debe estar entre 1 y 2");

		this.numeroSemestre = numero;
	}

	public ArrayList<Arrastre> getGruposArrastre(){

		return gruposArrastre;
	}


	public void agregarEstudianteArrastres(Estudiante e,String a){

		PlanEstudio plan = PlanEstudio.getInstancia();
		
		if(plan.getSemestre(a) == numeroSemestre){

			boolean agregado = false;
			int i;

			for(i = 0; i < gruposArrastre.size() && !agregado; i++){

				if(a.equals((gruposArrastre.get(i)).getAsignatura())){
					agregado = true;
					gruposArrastre.get(i).agregarEstudiante(e);
				}		
			}
			if(!agregado){
				Arrastre g = new Arrastre(anio,a);
				g.agregarEstudiante(e);
				gruposArrastre.add(g);
			}
		}

	}


}
