package pruebas;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import logica.CentroLaboral;

public class CentroLaboralTestCase {
	private CentroLaboral centroValido;
	private final String CENTRO_VALIDO = "CUJAE";
	private final String ORGANISMO_VALIDO = "MES";

	@Before
	public void setUp() {
		centroValido = new CentroLaboral(CENTRO_VALIDO, ORGANISMO_VALIDO);
	}

	// Constructor y getters válidos
	@Test
	public void testConstructorYGettersValidos() {
		assertEquals(CENTRO_VALIDO, centroValido.getCentroLaboral());
		assertEquals(ORGANISMO_VALIDO, centroValido.getOrganismo());
	}

	// Centro laboral
	@Test
	public void testSetCentroLaboralValido() {
		centroValido.setCentroLaboral("Universidad de La Habana");
		assertEquals("Universidad de La Habana", centroValido.getCentroLaboral());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorCentroLaboralNulo() {
		new CentroLaboral(null, ORGANISMO_VALIDO);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorCentroLaboralVacio() {
		new CentroLaboral("   ", ORGANISMO_VALIDO);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetCentroLaboralNulo() {
		centroValido.setCentroLaboral(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetCentroLaboralVacio() {
		centroValido.setCentroLaboral("");
	}

	// Organismo
	@Test
	public void testSetOrganismoValido() {
		centroValido.setOrganismo("CITMA");
		assertEquals("CITMA", centroValido.getOrganismo());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorOrganismoNulo() {
		new CentroLaboral(CENTRO_VALIDO, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorOrganismoVacio() {
		new CentroLaboral(CENTRO_VALIDO, "   ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetOrganismoNulo() {
		centroValido.setOrganismo(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetOrganismoVacio() {
		centroValido.setOrganismo("");
	}
}
