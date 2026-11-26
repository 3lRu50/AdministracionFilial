/**
 * 
 */
package logica;

/**
 * @author Grar2
 *
 */
public abstract class Persona {
	private String nombre;
	private CarnetIdentidad carnetId;
	private String direccion;
	
	
	public Persona(String carnetId, String nombre, String direccion){
		setNombre(nombre);
		setCarnetId(carnetId);
		setDireccion(direccion);
	}
	
	
	public final String getNombre() { return nombre; }
	
	public final void setNombre(String nombre) {
		stringValido("nombre", nombre);
		nombre = nombre.trim();
		if(!nombre.matches("[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò—¸‹ ]+"))
			throw new IllegalArgumentException("ERROR: el nombre debe tener solo letras ("+ nombre + ")");
		
		this.nombre = nombre;
	}
	
	public final String getCarnetId() { return carnetId.getCarnetIdentidad(); }
	
	
	public final void setCarnetId(String carnetId) {
		this.carnetId = new CarnetIdentidad(carnetId);
	}
	
	
	public final String getDireccion() { return direccion; }
	
	
	public final void setDireccion(String direccion) {
		stringValido("direcciÛn", direccion);
		
		this.direccion = direccion;
	}
	
	
	
	public final boolean carnetEs(String carnet){
		return carnetId.equals(carnet);
	}
	
	
	
	///utiles
	protected static void stringValido(String tipo, String entrada){
		if(entrada == null || entrada.trim().isEmpty())
				throw new IllegalArgumentException("ERROR: ingrese una cadena de caracteres que no vacÌa para "+ tipo + " ("+ entrada +")");
	}
	
}
