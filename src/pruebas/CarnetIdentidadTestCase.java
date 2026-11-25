package pruebas;

import static org.junit.Assert.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.Test;
import logica.CarnetIdentidad;

public class CarnetIdentidadTestCase {

	// metodo para fabricar un carnet de 11 digitos segun una fecha
	private String generarCarnetDesdeFecha(LocalDate fecha) {
		String ultimosCuatroDigitos = "2356";
		String yyMMdd = fecha.format(DateTimeFormatter.ofPattern("yyMMdd"));
		int anio = fecha.getYear();
		char digitoSiglo;

		if (anio >= 1800 && anio <= 1899) 
			digitoSiglo = '9';
		else if (anio >= 1900 && anio <= 1999)
			digitoSiglo = '0'; 
		else if (anio >= 2000 && anio <= 2099)
			digitoSiglo = '6'; 
		else
			throw new IllegalArgumentException("Año fuera de rango soportado por el CI cubano: " + anio);
		

		return yyMMdd + digitoSiglo + ultimosCuatroDigitos;
	}
	//validos
	@Test
	public void testCarnetSigloXXValido() {
		String ci = "95051212345"; // 12/05/1995
		CarnetIdentidad carnet = new CarnetIdentidad(ci);
		assertEquals(ci, carnet.getCarnetIdentidad());
	}

	@Test
	public void testCarnetSigloXXIValido() {
		String ci = "04112063456"; // 20/11/2004
		CarnetIdentidad carnet = new CarnetIdentidad(ci);
		assertEquals(ci, carnet.getCarnetIdentidad());
	}

	@Test
	public void testCarnetAnioBisiestoValido() {
		String ci = "00022962345"; // 29/02/2000
		CarnetIdentidad carnet = new CarnetIdentidad(ci);
		assertEquals(ci, carnet.getCarnetIdentidad());
	}

	//16 años
	@Test
	public void testEdadExacta16AniosHoyValido() {
		LocalDate hoyHace16Anios = LocalDate.now().minusYears(16);
		String ci = generarCarnetDesdeFecha(hoyHace16Anios);

		CarnetIdentidad carnet = new CarnetIdentidad(ci);
		assertEquals(ci, carnet.getCarnetIdentidad());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEdad16AniosManianaInvalido() {
		LocalDate mananaHace16Anios = LocalDate.now().minusYears(16).plusDays(1);
		String ci = generarCarnetDesdeFecha(mananaHace16Anios);

		new CarnetIdentidad(ci);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMenorDe16AniosInvalido() {
		LocalDate hace10Anios = LocalDate.now().minusYears(10);
		String ci = generarCarnetDesdeFecha(hace10Anios);

		new CarnetIdentidad(ci);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSigloXXIFuturaFechaInvalida() {
		new CarnetIdentidad("99010161234");
	}



	//bien escrito
	@Test(expected = IllegalArgumentException.class)
	public void testCarnetNulo() {
		new CarnetIdentidad(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCarnetVacio() {
		new CarnetIdentidad("   ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCarnetMenosDe11Digitos() {
		new CarnetIdentidad("9505121234"); // 10 dígitos
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCarnetMasDe11Digitos() {
		new CarnetIdentidad("950512123456"); // 12 dígitos
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCarnetConLetras() {
		new CarnetIdentidad("9505121234A");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCarnetConEspaciosInternos() {
		new CarnetIdentidad("950512 2345");
	}


	//fuera limite calendario
	@Test(expected = IllegalArgumentException.class)
	public void testMesInvalido() {
		new CarnetIdentidad("95131212345");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDiaInvalido() {
		new CarnetIdentidad("95053212345");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFebreroNoBisiestoInvalido() {
		new CarnetIdentidad("99022912345");
	}
}