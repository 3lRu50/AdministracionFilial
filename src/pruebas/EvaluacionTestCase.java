package pruebas;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import logica.Evaluacion;

public class EvaluacionTestCase {
	private Evaluacion evaluacionDosNotas;
	private Evaluacion evaluacionNotaFinal;
	private Evaluacion evaluacionAbonada;

	private final String ASIGNATURA_VALIDA = "Programacion";

	@Before
	public void setUp() {
		evaluacionDosNotas = new Evaluacion(ASIGNATURA_VALIDA, 4, 2);
		evaluacionNotaFinal = new Evaluacion("Algebra", 5);
		evaluacionAbonada = new Evaluacion("Ingles", 4, true);
	}

	// Constructores y getters válidos
	@Test
	public void testConstructoresYAsignaturaValidos() {
		assertEquals(ASIGNATURA_VALIDA, evaluacionDosNotas.getAsignatura());
		assertEquals("Algebra", evaluacionNotaFinal.getAsignatura());
		assertEquals("Ingles", evaluacionAbonada.getAsignatura());
		assertTrue(evaluacionAbonada.isAbonado());
		assertFalse(evaluacionDosNotas.isAbonado());
		assertFalse(evaluacionNotaFinal.isAbonado());
	}

	// Validación estática de rangos de nota
	@Test
	public void testNotaValidaEnRango() {
		assertTrue(Evaluacion.notaValida(2, Evaluacion.MIN_NOTA, Evaluacion.MAX_NOTA));
		assertTrue(Evaluacion.notaValida(5, Evaluacion.MIN_NOTA, Evaluacion.MAX_NOTA));
		assertFalse(Evaluacion.notaValida(1, Evaluacion.MIN_NOTA, Evaluacion.MAX_NOTA));
		assertFalse(Evaluacion.notaValida(6, Evaluacion.MIN_NOTA, Evaluacion.MAX_NOTA));
	}

	// Excepciones en constructores (asignatura y rangos)
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorDosNotasAsignaturaNula() {
		new Evaluacion(null, 4, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorDosNotasAsignaturaVacia() {
		new Evaluacion("   ", 4, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorDosNotasPruebaFinalFueraDeRango() {
		new Evaluacion(ASIGNATURA_VALIDA, 1, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorDosNotasRevalorizacionFueraDeRango() {
		new Evaluacion(ASIGNATURA_VALIDA, 3, 6);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNotaFinalMenorAlMinimoAprobado() {
		// En Evaluacion(asignatura, notaFinal) el mínimo exigido es MIN_NOTA + 1 (3)
		new Evaluacion(ASIGNATURA_VALIDA, 2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNotaFinalMayorAlMaximo() {
		new Evaluacion(ASIGNATURA_VALIDA, 6);
	}

	// Estados académicos: PF, revalorización, subir notas, mundialista, aprobado y nota final
	@Test
	public void testAprobadoEnPruebaFinal() {
		Evaluacion ev = new Evaluacion("POO", 4, 2);
		assertTrue(ev.isAprobadoPF());
		assertFalse(ev.isAprobadoRe());
		assertTrue(ev.isAprobado());
		assertTrue(ev.fueSubirNotas());
		assertFalse(ev.isMundialista());
		assertEquals(4, ev.getNotaFinal());
	}

	@Test
	public void testAprobadoEnRevalorizacion() {
		Evaluacion ev = new Evaluacion("Calculo", 2, 4);
		assertFalse(ev.isAprobadoPF());
		assertTrue(ev.isAprobadoRe());
		assertTrue(ev.isAprobado());
		assertTrue(ev.fueSubirNotas());
		assertFalse(ev.isMundialista());
		assertEquals(4, ev.getNotaFinal());
	}

	@Test
	public void testMundialista() {
		Evaluacion ev = new Evaluacion("Fisica", 2, 2);
		assertFalse(ev.isAprobadoPF());
		assertFalse(ev.isAprobadoRe());
		assertFalse(ev.isAprobado());
		assertTrue(ev.isMundialista());
		assertTrue(ev.fueSubirNotas());
		assertEquals(2, ev.getNotaFinal());
	}

	@Test
	public void testNotaFinalDirecta() {
		Evaluacion ev = new Evaluacion("Quimica", 3);
		assertTrue(ev.isAprobadoPF());
		assertFalse(ev.isAprobadoRe());
		assertTrue(ev.isAprobado());
		assertEquals(3, ev.getNotaFinal());
	}
}