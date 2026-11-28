package logica;

import java.util.ArrayList;

import enums.AreaLaboral;
import enums.CategoriaCientifica;
import enums.CategoriaDocente;
import static logica.Persona.stringValido;

public final class Filial {
	private static Filial filial;
	
	private ArrayList<Anio> anios = new ArrayList<>();
	private ColectivoTrabajadores colectivoTrabajadores = new ColectivoTrabajadores();
	private PlanEstudio planEstudio = PlanEstudio.getInstancia();
	
	//Singleton
	private Filial() {
		for(int anio = 1; anio <= 6; anio++)
			anios.add(new Anio(anio));
	}
	
	public static Filial getInstancia() {
		if(filial == null)
			filial = new Filial();
		
		return filial;	
	}

	
	
	//crearActores
	public void addEstudiante(int anio, String carnetId, String nombre, String direccion, String centroLaboral, String organismo){
		validacionCarnetYaRegistrado(carnetId);
		validacionAnioEnRango(anio);
		
		anios.get(anio).agregarEstudiante(carnetId, nombre, direccion, centroLaboral, organismo);
	}

	public void addProfesor(String carnetId, String nombre, String direccion, double salarioBase, CategoriaCientifica catCientifica, CategoriaDocente catDocente, String centroLaboral, String organismo){
		validacionCarnetYaRegistrado(carnetId);
		
		colectivoTrabajadores.addProfesor(carnetId, nombre, direccion, salarioBase, catCientifica, catDocente, organismo, centroLaboral);
	}
	
	public void addNoDocente(String carnetId, String nombre, String direccion, double salarioBase, AreaLaboral areaLaboral){
		validacionCarnetYaRegistrado(carnetId);
		
		colectivoTrabajadores.addNoDocente(carnetId, nombre, direccion, salarioBase, areaLaboral);
	}

	
	
	//Notas
	public void agregarNota(String carnetIdEstudiante, int anio, String asignatura){
		validacionAnioEnRango(anio);
		
	}
	
	
	//utiles
	public boolean carnetYaRegistrado(String carnet){
		stringValido("carnet de identidad", carnet);
		
		boolean registrado = colectivoTrabajadores.carnetYaRegistrado(carnet);
		
		
		for(int anio = 0; anio < anios.size() && !registrado; anio++)
			if(anios.get(anio).existeId(carnet))
				registrado = true;
		
		return registrado;
	}
	
	public void validacionCarnetYaRegistrado(String carnetId){
		if(carnetYaRegistrado(carnetId))
			throw new IllegalArgumentException("ERROR: ya existe una persona con ese número de carnet");
	}

	public static boolean anioEnRango(int anio){
		return anio >= 1 && anio <= 5;
	}

	public void validacionAnioEnRango(int anio){
		if(!anioEnRango(anio))
			throw new IllegalArgumentException("ERROR: el año debe ser un entero entre 1 y 6");
	}
}
