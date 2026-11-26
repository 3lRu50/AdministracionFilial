package logica;

public class Evaluacion {
	public static int MAX_NOTA = 5;
	public static int MIN_NOTA = 2;
	
	private String asignatura;
	private int nota1;
	private int nota2;
	private boolean abonado;

	public Evaluacion(String asignatura, int pruebaFinal, int revalorizacion) {
		Persona.stringValido("asignatura", asignatura);
		
		validacionNotaEnRango(pruebaFinal, "prueba final", MIN_NOTA, MAX_NOTA);
		validacionNotaEnRango(revalorizacion, "nota2", MIN_NOTA, MAX_NOTA);
		
		this.asignatura = asignatura;
		this.nota1 = pruebaFinal;
		this.nota2 = revalorizacion;
	}
	
	public Evaluacion(String asignatura, int notaFinal){
		Persona.stringValido("asignatura", asignatura);
		
		validacionNotaEnRango(notaFinal, "nota final", MIN_NOTA+1, MAX_NOTA);
		
		this.asignatura = asignatura;
		nota1 = notaFinal;
	}
	
	public Evaluacion(String asignatura, int notaFinal, boolean abonado){
		this(asignatura, notaFinal);
		
		this.abonado = abonado;
	}
	
	
	public final String getAsignatura(){
		return asignatura;
	}

	
	public static boolean notaValida(int nota,int min, int max){
		boolean notaValida = true;
		
		if(nota > max || nota < min)
			notaValida = false;
		
		return notaValida;
	}

	private static void validacionNotaEnRango(int nota, String tipoNota, int min, int max){
		if(!notaValida(nota, min, max))
			throw new IllegalArgumentException("ERROR: la nota de "+ tipoNota +" debe ser un número entero entre "+ min +" y "+ max);
	}

	
	
	public boolean isAprobadoPF() {
		boolean si = false;
		
		if(nota1 > 2)
			si = true;
		
		return si;
	}
	
	public boolean isAprobadoRe() {
		boolean si = false;
		
		if(nota2 > 2)
			si = true;
		
		return si;
	}
	
	public boolean fueSubirNotas() {
		boolean si = false;
		
		if(nota1 > 2 || nota2 != 0)
			si = true;
		
		return si;
	}
	
	public boolean isMundialista() {
		boolean si = false;
		
		if(nota1 == 2 && nota2 == 2)
			si = true;
		
		return si;
	}

	public boolean isAbonado() {
		return abonado;
	}
	
	public boolean isAprobado() {
		boolean si = false;
		
		if(nota1 > 2 || nota2 > 2)
			si = true;
		
		return si;
	}
	
	
	public int getNotaFinal(){
		int nota = 2;
		
		if(nota1 > 2)
			nota = nota1;
		else if(nota2 > 2)
			nota = nota2;
		
		return nota;
	}

}
