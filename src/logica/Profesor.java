package logica;

import enums.CargoConsejoDirectivo;
import enums.CategoriaCientifica;
import enums.CategoriaDocente;

public class Profesor extends Trabajador {
	private String  centroLaboral;
	private String organismo;
	private CategoriaCientifica catCientifica;
	private CategoriaDocente catDocente;
	private CargoConsejoDirectivo cargo;

	public Profesor(String carnetId, String nombre, String direccion, double salarioBase, CategoriaCientifica catCientifica,CategoriaDocente catDocente,
			String organismo, String centroLaboral) {
		super(carnetId, nombre, direccion, salarioBase);
		
		
		setCatDocente(catDocente);
		setCatCientifica(catCientifica);
		setCentroLaboral(centroLaboral);
		setOrganismo(organismo);
	}
	
	
	
	
	
	
	
	public final String getCentroLaboral() {
		return centroLaboral;
	}







	public final void setCentroLaboral(String centroLaboral) {
		stringValido("centro laboral", centroLaboral);
		
		this.centroLaboral = centroLaboral;
	}













	public final String getOrganismo() {
		return organismo;
	}







	public final void setOrganismo(String organismo) {
		stringValido("organismo", organismo);
		
		this.organismo = organismo;
	}







	public final CategoriaCientifica getCatCientifica() {
		return catCientifica;
	}




	public final void setCatCientifica(CategoriaCientifica catCientifica) {
		if(catCientifica == null)
			throw new IllegalArgumentException("ERROR: fue ingresada una instancia null de CategoriaCientifica");
		
		this.catCientifica = catCientifica;
	}




	public final CategoriaDocente getCatDocente() {
		return catDocente;
	}




	public final void setCatDocente(CategoriaDocente catDocente) {
		if(catDocente == null)
			throw new IllegalArgumentException("ERROR: fue ingresada una instancia null de CategoriaDocente");
		
		this.catDocente = catDocente;
	}


	
	


	public final CargoConsejoDirectivo getCargo() {
		return cargo;
	}




	public final void setCargo(CargoConsejoDirectivo cargo) {
		if(cargo == null)
			throw new IllegalArgumentException("ERROR: fue ingresada una instancia null de CargoConsejoDirectivo");
		
		this.cargo = cargo;
	}
	
	
	




	@Override
	public double calcularSalario(){
		return super.calcularSalario() + catCientifica.getPago() + catDocente.getPago();
	}
	
}
