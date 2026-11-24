/**
 * 
 */
package logica;

/**
 * @author Grar2
 *
 */
public class Persona {
	private String nombre;
	private String carnetId;
	private String direccion;
	
	public Persona(){}
	
	
	public Persona(String carnetId, String nombre, String direccion){
		setNombre(nombre);
		setCarnetId(carnetId);
		setDireccion(direccion);
	}
	
	
	public final String getNombre() { return nombre; }
	
	public final void setNombre(String nombre) {
		stringValido("nombre", nombre);
		if(!nombre.matches("\\[a-zA-Z]+"))
			throw new IllegalArgumentException("ERROR: el nombre debe tener solo letras ("+ nombre + ")");
		
		this.nombre = nombre;
	}
	
	public final String getCarnetId() { return carnetId; }
	
	
	public final void setCarnetId(String carnetId) {
		this.carnetId = carnetId;
	}
	
	
	public final String getDireccion() { return direccion; }
	
	
	public final void setDireccion(String direccion) {
		if(direccion == null || direccion.isEmpty())
			throw new IllegalArgumentException("ERROR: dirección no permitida (" + direccion + ")");
		
		this.direccion = direccion;
	}
	
	
	
	///utiles
	private static void stringValido(String tipo, String entrada){
		if(entrada == null || entrada.isEmpty())
			throw new IllegalArgumentException("ERROR: ingrese un parametro " + tipo + " valido " + "("+ entrada +")");
	}
	
}
