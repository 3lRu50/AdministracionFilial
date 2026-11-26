package pruebas;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import logica.Estudiante;

public class EstudianteTestCase {
	private Estudiante estudianteValido;
	private final String CARNET_VALIDO = "03081512345"; // Mayor de 16 años (siglo XXI)
	private final String NOMBRE_VALIDO = "Camila";
	private final String DIRECCION_VALIDA = "Calle 25 #501, Plaza";
	private final String CENTRO_VALIDO = "CUJAE";
	private final String ORGANISMO_VALIDO = "MES";

	@Before
	public void setUp() {
		estudianteValido = new Estudiante(
			CARNET_VALIDO,
			NOMBRE_VALIDO,
			DIRECCION_VALIDA,
			CENTRO_VALIDO,
			ORGANISMO_VALIDO
		);
	}

	// Constructor y herencia de Persona
	@Test
	public void testConstructorYGettersValidos() {
		assertEquals(CARNET_VALIDO, estudianteValido.getCarnetId());
		assertEquals(NOMBRE_VALIDO, estudianteValido.getNombre());
		assertEquals(DIRECCION_VALIDA, estudianteValido.getDireccion());
		assertEquals(CENTRO_VALIDO, estudianteValido.getCentroLaboral());
		assertEquals(ORGANISMO_VALIDO, estudianteValido.getOrganismo());
		assertTrue(estudianteValido.getAprobadas().isEmpty());
		assertTrue(estudianteValido.getAprobadasPruebaF().isEmpty());
		assertTrue(estudianteValido.getAprobadasRe().isEmpty());
		assertTrue(estudianteValido.getAbonadas().isEmpty());
		assertTrue(estudianteValido.getMundiales().isEmpty());
	}

	// Centro laboral y Organismo
	@Test
	public void testSetCentroLaboralValido() {
		estudianteValido.setCentroLaboral("UH");
		assertEquals("UH", estudianteValido.getCentroLaboral());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorCentroLaboralNulo() {
		new Estudiante(CARNET_VALIDO, NOMBRE_VALIDO, DIRECCION_VALIDA, null, ORGANISMO_VALIDO);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetCentroLaboralVacio() {
		estudianteValido.setCentroLaboral("   ");
	}

	@Test
	public void testSetOrganismoValido() {
		estudianteValido.setOrganismo("CITMA");
		assertEquals("CITMA", estudianteValido.getOrganismo());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorOrganismoNulo() {
		new Estudiante(CARNET_VALIDO, NOMBRE_VALIDO, DIRECCION_VALIDA, CENTRO_VALIDO, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetOrganismoVacio() {
		estudianteValido.setOrganismo("");
	}

	// Agregar notas y validaciones de entrada
	@Test
	public void testAgregarNotaFinalDirecta() {
		assertFalse(estudianteValido.asignaturaEvaluada("POO"));
		estudianteValido.agregarNota("POO", 5);
		assertTrue(estudianteValido.asignaturaEvaluada("POO"));
		assertTrue(estudianteValido.asignaturaEvaluada("poo"));
	}

	@Test
	public void testAgregarNotaPruebaFinalYRevalorizacion() {
		estudianteValido.agregarNota("Calculo", 2, 4);
		assertTrue(estudianteValido.asignaturaEvaluada("Calculo"));
	}

	@Test
	public void testAgregarAbonada() {
		estudianteValido.agregarAbonada("Ingles", 5);
		assertTrue(estudianteValido.asignaturaEvaluada("Ingles"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNoPermiteAsignaturaDuplicada() {
		estudianteValido.agregarNota("POO", 4);
		estudianteValido.agregarNota("poo", 5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAgregarNotaFinalMenorA3LanzaExcepcion() {
		estudianteValido.agregarNota("Fisica", 2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAgregarNotaFueraDeRangoSuperior() {
		estudianteValido.agregarNota("Quimica", 6, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAgregarNotaFueraDeRangoInferior() {
		estudianteValido.agregarNota("Quimica", 1, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAgregarAsignaturaVacia() {
		estudianteValido.agregarNota("   ", 4);
	}

	// Consultas de asignaturas por estado
	@Test
	public void testConsultasAprobadasPruebaFRevalorizacionAbonadasYMundiales() {
		estudianteValido.agregarNota("POO", 5);             // Aprobada en PF
		estudianteValido.agregarNota("Calculo", 2, 4);      // Aprobada en revalorización
		estudianteValido.agregarNota("Algebra", 2, 2);      // Mundialista (no aprobada)
		estudianteValido.agregarAbonada("Historia", 5);     // Abonada

		ArrayList<String> aprobadas = estudianteValido.getAprobadas();
		assertEquals(3, aprobadas.size());
		assertTrue(aprobadas.contains("POO"));
		assertTrue(aprobadas.contains("Calculo"));
		assertTrue(aprobadas.contains("Historia"));
		assertFalse(aprobadas.contains("Algebra"));

		ArrayList<String> aprobadasPF = estudianteValido.getAprobadasPruebaF();
		assertTrue(aprobadasPF.contains("POO"));
		assertFalse(aprobadasPF.contains("Calculo"));

		ArrayList<String> aprobadasRe = estudianteValido.getAprobadasRe();
		assertEquals(1, aprobadasRe.size());
		assertTrue(aprobadasRe.contains("Calculo"));

		ArrayList<String> abonadas = estudianteValido.getAbonadas();
		assertEquals(1, abonadas.size());
		assertTrue(abonadas.contains("Historia"));

		ArrayList<String> mundiales = estudianteValido.getMundiales();
		assertEquals(1, mundiales.size());
		assertTrue(mundiales.contains("Algebra"));
	}
}