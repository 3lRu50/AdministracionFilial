package pruebas; // Cambia al paquete donde ubiques tus tests (o déjalo en logica)

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import logica.Persona;

public class PersonaTestCase {
	private Persona personaValida;
	private final String CARNET_VALIDO = "95051212345"; // 12/05/1995 (siglo XX)
	private final String NOMBRE_VALIDO = "Alejandro";
	private final String DIRECCION_VALIDA = "Calle 23 #456, Vedado";

	@Before
	public void setUp() {
		personaValida = new PersonaTest(CARNET_VALIDO, NOMBRE_VALIDO, DIRECCION_VALIDA);
	}

	@Test
	public void testConstructorYGettersValidos() {
		assertEquals(CARNET_VALIDO, personaValida.getCarnetId());
		assertEquals(NOMBRE_VALIDO, personaValida.getNombre());
		assertEquals(DIRECCION_VALIDA, personaValida.getDireccion());
	}

	
	//nombre
	@Test
	public void testNombreConTildesYEnie() {
		personaValida.setNombre("  JoséÑandúÜ  "); // Prueba también el .trim()
		assertEquals("JoséÑandúÜ", personaValida.getNombre());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNombreNulo() {
		new PersonaTest(CARNET_VALIDO, null, DIRECCION_VALIDA);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNombreVacio() {
		personaValida.setNombre("   ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNombreConNumeros() {
		personaValida.setNombre("Carlos123");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNombreConCaracteresEspeciales() {
		personaValida.setNombre("Ana_Maria");
	}

	
	//direccion
	@Test(expected = IllegalArgumentException.class)
	public void testDireccionNula() {
		new PersonaTest(CARNET_VALIDO, NOMBRE_VALIDO, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDireccionVacia() {
		personaValida.setDireccion("   ");
	}

	//carnet
	@Test(expected = IllegalArgumentException.class)
	public void testCarnetInvalidoEnPersona() {
		personaValida.setCarnetId("123");
	}

}

class PersonaTest extends Persona {
	public PersonaTest(String carnetId, String nombre, String direccion) {
		super(carnetId, nombre, direccion);
	}
}
