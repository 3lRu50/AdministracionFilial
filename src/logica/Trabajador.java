package logica;

public abstract class Trabajador extends Persona {
	private double salarioBase;

	public Trabajador(String carnetId, String nombre, String direccion, double salarioBase) {
		super(carnetId, nombre, direccion);
		setSalarioBase(salarioBase);
	}

	public final void setSalarioBase(double salarioBase) {
		if(salarioBase <= 0)
			throw new IllegalArgumentException("ERROR: el salario de un trabajador debe ser positivo ("+ salarioBase +")");
		
		this.salarioBase = salarioBase;
	}
	
	public double calcularSalario(){
		return salarioBase;
	}
}
