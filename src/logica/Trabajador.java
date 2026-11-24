package logica;

public abstract class Trabajador extends Persona {
	private double salario;

	public Trabajador(){
		
	}
	
	public Trabajador(String carnetId, String nombre, String direccion, double salario) {
		super(carnetId, nombre, direccion);
		setSalario(salario);
	}

	public final double getSalario() {return salario;}

	public final void setSalario(double salario) {
		if(salario <= 0)
			throw new IllegalArgumentException("ERROR: el salario de un trabajador debe ser positivo ("+ salario +")");
		
		this.salario = salario;
	}
}
