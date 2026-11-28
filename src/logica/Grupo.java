package logica;

import java.util.ArrayList;

public class Grupo {

	private String id;
	private int anio;
	private ArrayList<Estudiante> estudiantes;

	//contador estático
	private static int contador = 0;

	public Grupo(int anio){

		this.id = String.format("IF-%d", ++contador);
		estudiantes = new ArrayList<Estudiante>();
		setAnio(anio);
	}

	public String getId(){
		return id;
	}


	public void agregarEstudiante(Estudiante e){
			estudiantes.add(e);
	}

	public int getAnio(){
		return anio;
	}

	public void setAnio(int anio){

		if(anio < 1 || anio > 6)
			throw new IllegalArgumentException("Error.El año debe estar entre 1 y 6");

		this.anio = anio;
	}

	public int getCantEstudiantes(){
		return estudiantes.size();
	}
}
