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
	public String getNombre(){

		return nombre;

	}

	public boolean existeAsignatura(String nombre){

		return buscarAsignatura(nombre) != null;
	}

	public int getSemestre(String a1){

		int num = 0;

		Asignatura a = buscarAsignatura(a1);
		if(a != null)
			num = a.getSemestre();

		return num;
	}

	private Asignatura buscarAsignatura(String nombre){
		Asignatura a = null;
		int i;
		if(nombre != null){
			for(i = 0; i < asignaturas.size() && a == null; i++){
				if(nombre.equals(asignaturas.get(i).getNombre()))
					a = asignaturas.get(i);
			}
		}
		return a;
	}
}
