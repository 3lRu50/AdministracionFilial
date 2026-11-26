package logica;


public class Asignatura {

	private final String id;
	private String nombre;
	private int anio;
	private int semestre;
	private int horasLectivas;

	private static int contador = 0;
	
	public Asignatura(String nombre, int anio, int semestre, int horas){
	
		
		
		this.id = String.format("ASG-%d", ++contador);
		setNombre(nombre);
		setAnio(anio);
		setSemestre(semestre);
		setHorasLect(horas);
		
	}
	
	public String getId(){
		return id;
	}
	
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		
		stringValido("nombre", nombre);
		if(!nombre.matches("\\[a-zA-Z0-9áéíóúÁÉÍÓÚñÑüÜ ]+"))
			throw new IllegalArgumentException("ERROR: el nombre debe tener solo letras o números("+ nombre + ")");
		
		this.nombre = nombre;
		
	}
	
	public int getAnio(){
		return anio;
	}
	
	public void setAnio(int anio){
		if(!validarRango(anio,1,6)){
			throw new IllegalArgumentException("Escribe un número entre 1 y 6");
		}
		this.anio = anio;
	}
	
	public int getSemestre(){
		return semestre;
	}
	
	public void setSemestre(int semestre){
		
		if(!validarRango(semestre,1,2)){
			throw new IllegalArgumentException("Escribe un número entre 1 y 2");
		}
		this.semestre = semestre;
	}
	
	public int getHorasLect(){
		return horasLectivas;
	}
	
	public void setHorasLect(int horas){
		
		if(!validarRango(horas,1,200)){
			throw new IllegalArgumentException("Escribe un número entre 1 y 200");
		}
		this.horasLectivas = horas;
	}
	
	//utiles
	private static boolean validarRango(int numero, int inicio, int fin){
		return numero >= inicio && numero <= fin;
	}
	private static void stringValido(String tipo, String entrada){
		if(entrada == null || entrada.trim().isEmpty())
			throw new IllegalArgumentException("ERROR: ingrese un parametro " + tipo + " valido " + "("+ entrada +")");
	}
	
	//comprobar que no se repita
	@Override
	public boolean equals(Object obj) {

		boolean iguales = true;

	    if (this != obj) {

	        if (obj == null || getClass() != obj.getClass()) {
	            iguales = false;
	        } else {

	            Asignatura otra = (Asignatura) obj;

	            if (!nombre.equalsIgnoreCase(otra.nombre) || anio != otra.anio || semestre != otra.semestre) {
	                iguales = false;
	            }
	        }
	    }
		  
	    return iguales;
	}
	

}
