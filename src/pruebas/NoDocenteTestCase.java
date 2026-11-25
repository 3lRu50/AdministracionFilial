package pruebas;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import enums.AreaLaboral;
import logica.NoDocente;

public class NoDocenteTestCase {
	private NoDocente noDocenteValido;
	private final String CARNET_VALIDO = "95051212345";
	private final String NOMBRE_VALIDO = "Carlos";
	private final String DIRECCION_VALIDA = "Calle Línea #804, Vedado";
	private final double SALARIO_VALIDO = 3800.00;
	private final double DELTA = 0.001;

	@Before
	public void setUp() {
		noDocenteValido = new NoDocente(
			CARNET_VALIDO, 
			NOMBRE_VALIDO, 
			DIRECCION_VALIDA, 
			SALARIO_VALIDO, 
			AreaLaboral.SECRETARIA
		);
	}

	//probar herencia
	@Test
	public void testConstructorYGettersValidos() {
		assertEquals(CARNET_VALIDO, noDocenteValido.getCarnetId());
		assertEquals(NOMBRE_VALIDO, noDocenteValido.getNombre());
		assertEquals(DIRECCION_VALIDA, noDocenteValido.getDireccion());
		assertEquals(SALARIO_VALIDO, noDocenteValido.calcularSalario(), DELTA);
		assertEquals(AreaLaboral.SECRETARIA, noDocenteValido.getAreaLaboral());
	}


	//area de Trabajo
	@Test
	public void testSetAreaLaboralValida() {
		noDocenteValido.setAreaLaboral(AreaLaboral.BIBLIOTECA);
		assertEquals(AreaLaboral.BIBLIOTECA, noDocenteValido.getAreaLaboral());

		noDocenteValido.setAreaLaboral(AreaLaboral.LABORATORIO);
		assertEquals(AreaLaboral.LABORATORIO, noDocenteValido.getAreaLaboral());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorAreaLaboralNula() {
		new NoDocente(CARNET_VALIDO, NOMBRE_VALIDO, DIRECCION_VALIDA, SALARIO_VALIDO, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetAreaLaboralNula() {
		noDocenteValido.setAreaLaboral(null);
	}

	//atributos heredados
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorSalarioInvalido() {
		new NoDocente(CARNET_VALIDO, NOMBRE_VALIDO, DIRECCION_VALIDA, -500.0, AreaLaboral.SECRETARIA);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorCarnetInvalido() {
		new NoDocente("12345", NOMBRE_VALIDO, DIRECCION_VALIDA, SALARIO_VALIDO, AreaLaboral.SECRETARIA);
	}
}