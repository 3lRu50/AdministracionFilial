package enums;

public enum CategoriaCientifica {
	MASTER(550),
	DOCTOR(380),
	NINGUNA(0);


	private double pago;
	
	private CategoriaCientifica(double pago) {
		this.pago = pago;
	}

	
	public double getPago(){ 
		return pago;
	}
}
