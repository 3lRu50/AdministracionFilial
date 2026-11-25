package logica;

import java.time.DateTimeException;
import java.time.LocalDate;

public final class CarnetIdentidad {
	private String numero;
	
	public CarnetIdentidad(String numero){
		if(numero == null || numero.trim().isEmpty())
			throw new IllegalArgumentException("ERROR: ingrese una cadena de caracteres que no vacía para carnet de identidad" + "("+ numero +")");
		
		if(numero.length() != 11)
			throw new IllegalArgumentException("ERROR: el carnet de identidad debe tener 11 dígitos (tamaño actual: "+ numero.length() +")");
		
		if( !numero.matches("\\d+") )
			throw new IllegalArgumentException("ERROR: el carnet de identidad solo puede tener números");
		
		int siglo = getParDigitosInt(numero, 6, 7),
			anio = getCentenasSigloNacimiento(siglo) * 100 + getParDigitosInt(numero, 0, 2),
			mes = getParDigitosInt(numero, 2, 4),
			dia = getParDigitosInt(numero, 4, 6);
		
		LocalDate nacimiento;
		try {
			nacimiento = LocalDate.of(anio, mes, dia);
		} catch (DateTimeException e) {
			throw new IllegalArgumentException("ERROR: la fecha de nacimiento no es válida (" + dia + "/" + mes + "/" + anio + ")", e);
		}
		
		
		LocalDate fechaMinimaEdad = LocalDate.now().minusYears(16);
		if (nacimiento.isAfter(fechaMinimaEdad)) 
			throw new IllegalArgumentException("ERROR: la persona debe tener al menos 16 años cumplidos (" + dia + "/" + mes + "/" + anio + ")");
		
		
		this.numero = numero;
	}
	
	public String getCarnetIdentidad(){ return numero; }
	
	
	
	private static int getCentenasSigloNacimiento(int digito){
		if(digito > 9 || digito < 0)
			throw new IllegalArgumentException("ERROR: el siglo se representa en el carnet como un solo digito");
		
		int siglo = 0;
		
		switch(digito){
			case 0: case 1: case 2: case 3: case 4: case 5:
				siglo = 19; break;
				
			case 6: case 7: case 8:
				siglo = 20; break;
			
			case 9: 
				siglo = 18; break;
		}
		
		return siglo;
	}
	
	private static int getParDigitosInt(String numero, int inicio, int fin){
		String par = numero.substring(inicio, fin); // conjunto semiabierto
	
		return Integer.parseInt(par);
	}
	
	@Override
	public String toString(){
		return numero;
	}
	
}
