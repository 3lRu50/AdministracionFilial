package logica;

import enums.CargoConsejoDirectivo;
import enums.CategoriaCientifica;
import enums.CategoriaDocente;

public class Profesor extends Trabajador {
	private CategoriaCientifica catCientifica;
	private CategoriaDocente catDocente;
	private CargoConsejoDirectivo cargo;
	private CentroLaboral centro;

	public Profesor(String carnetId, String nombre, String direccion, double salarioBase, CategoriaCientifica catCientifica,CategoriaDocente catDocente,
			String organismo, String centroLaboral) {
		super(carnetId, nombre, direccion, salarioBase);
		
		setCargo(CargoConsejoDirectivo.NINGUNO);
		setCatDocente(catDocente);
		setCatCientifica(catCientifica);
		centro = new CentroLaboral(centroLaboral, organismo);
	}
	
	
	
	
	
	
	
	public final String getCentroLaboral() {
		return centro.getCentroLaboral();
	}




	public final void setCentroLaboral(String centroLaboral) {
		centro.setCentroLaboral(centroLaboral);
	}




	public final String getOrganismo() {
		return centro.getOrganismo();
	}



	public final void setOrganismo(String organismo) {
		centro.setOrganismo(organismo);
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
