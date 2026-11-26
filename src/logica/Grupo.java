package logica;



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


	public ArrayList<Estudiante> getEstudiantes(){

		return estudiantes;

	}

	public void agregarEstudiante(Estudiante e){

		if(e == null)
			throw new IllegalArgumentException("Error.El estudiante no puede ser nulo");

		if (!estudiantes.contains(e)) {
			estudiantes.add(e);
		}
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
