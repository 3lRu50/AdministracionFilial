package logica;

import java.util.ArrayList;

import enums.AreaLaboral;
import enums.CategoriaCientifica;
import enums.CategoriaDocente;

public class ColectivoTrabajadores {
	private ArrayList<Trabajador> trabajadores = new ArrayList<>();
	
	public double getTotalPagado(){
		double total = 0;
		
		for(Trabajador trabajador : trabajadores)
			total += trabajador.calcularSalario();
		
		return total;
	}
	
	public double getTotalPagoProfesores(){
		double total = 0;
		
		for(Trabajador trabajador : trabajadores)
			if(trabajador instanceof Profesor)
				total += ((Profesor) trabajador).calcularSalario();
		
		return total;
	}
	
	public double getTotalPagoNoDocentews(){
		double total = 0;
		
		for(Trabajador trabajador : trabajadores)
			if(trabajador instanceof NoDocente)
				total += ((NoDocente) trabajador).calcularSalario();
		
		return total;
	}

	public ArrayList<String> profesoresMejorPagados(){
		ArrayList<String> mejoresPagados = new ArrayList<>();
		double mejorPago = 0;
		
		for(Trabajador trabajador : trabajadores)
			if(trabajador instanceof Profesor){
				double pagoProfe = ((Profesor) trabajador).calcularSalario();
				
				if(mejorPago == pagoProfe){
					mejoresPagados.add(trabajador.getNombre());
				}
				else if (mejorPago < pagoProfe){
					mejorPago = pagoProfe;
					mejoresPagados.clear();
					mejoresPagados.add(trabajador.getNombre());
				}
					
			}
		
		return mejoresPagados;		
	}
	
	public ArrayList<String> noDocentesMejorPagados(){
		ArrayList<String> mejoresPagados = new ArrayList<>();
		double mejorPago = 0;
		
		for(Trabajador trabajador : trabajadores)
			if(trabajador instanceof NoDocente){
				double pagoNoDocente = ((NoDocente) trabajador).calcularSalario();
				
				if(mejorPago == pagoNoDocente){
					mejoresPagados.add(trabajador.getNombre());
				}
				else if (mejorPago < pagoNoDocente){
					mejorPago = pagoNoDocente;
					mejoresPagados.clear();
					mejoresPagados.add(trabajador.getNombre());
				}
					
			}
		
		return mejoresPagados;		
	}
	
	
	
	public void addProfesor(String id, String nombre, String direccion, double salarioBase, 
			CategoriaCientifica catCientifica, CategoriaDocente catDocente, String organismo, 
			String centroLaboral){
		trabajadores.add(new Profesor(id, nombre, direccion, salarioBase, catCientifica, catDocente, organismo, centroLaboral));
	}
	
	public void addNoDocente(String id, String nombre, String direccion, double salarioBase, AreaLaboral areaLaboral){
		trabajadores.add(new NoDocente(id, nombre, direccion, salarioBase, areaLaboral));
	}
	
	
	public boolean carnetYaRegistrado(String carnet){
		boolean yaRegistrado = false;
		
		for(int trab = 0; trab < trabajadores.size() && !yaRegistrado; trab++)
			if(trabajadores.get(trab).carnetEs(carnet))
				yaRegistrado = true;
			
		return yaRegistrado;
	}
	
	
	public ArrayList<Profesor> getProfesores(){
		ArrayList<Profesor> profes = new ArrayList<>();
		
		for(Trabajador profe : trabajadores)
			if(profe instanceof Profesor)
				profes.add((Profesor) profe);
		
		return profes;
	}
}
