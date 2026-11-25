package enums;

public enum CategoriaDocente {
	PROFESOR_TITULAR(540),
	PROFESOR_AUXILIAR(300),
	ASISTENTE(200),
	INSTRUCTOR(0);
	
	private double pago;
	
	
	private CategoriaDocente(double pago){
		this.pago = pago;
	}
	
	
	public double getPago(){
		return pago;
	}
	
}
