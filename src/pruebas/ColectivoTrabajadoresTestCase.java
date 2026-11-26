package pruebas;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import enums.AreaLaboral;
import enums.CategoriaCientifica;
import enums.CategoriaDocente;
import logica.ColectivoTrabajadores;

public class ColectivoTrabajadoresTestCase {
	private ColectivoTrabajadores colectivoVacio;
	private ColectivoTrabajadores colectivoPoblado;

	private final double DELTA = 0.001;

	private final String CARNET_DOC1 = "95051212345";
	private final String CARNET_DOC2 = "94031011223";
	private final String CARNET_DOC_EMPATE = "93082055443";
	private final String CARNET_NODOC1 = "9601011890";
	private final String CARNET_NODOC2 = "92111599887";
	private final String CARNET_NO_REGISTRADO = "91070433221";

	// Salarios calculados según los pagos definidos en CategoriaCientifica y CategoriaDocente:
	// doc1: 5000 + MASTER(550) + PROFESOR_TITULAR(540) = 6090.0
	// doc2: 4000 + DOCTOR(380) + PROFESOR_AUXILIAR(300) = 4680.0
	// docEmpate: 5890 + NINGUNA(0) + ASISTENTE(200) = 6090.0
	private double salarioDoc1;
	private double salarioDoc2;
	private double salarioDocEmpate;
	private double salarioNoDoc1;
	private double salarioNoDoc2;

	@Before
	public void setUp() {
		colectivoVacio = new ColectivoTrabajadores();
		colectivoPoblado = new ColectivoTrabajadores();

		double baseDoc1 = 5000.0;
		double baseDoc2 = 4000.0;
		double baseDocEmpate = 5890.0;

		salarioDoc1 = baseDoc1 + CategoriaCientifica.MASTER.getPago() + CategoriaDocente.PROFESOR_TITULAR.getPago();
		salarioDoc2 = baseDoc2 + CategoriaCientifica.DOCTOR.getPago() + CategoriaDocente.PROFESOR_AUXILIAR.getPago();
		salarioDocEmpate = baseDocEmpate + CategoriaCientifica.NINGUNA.getPago() + CategoriaDocente.ASISTENTE.getPago();

		salarioNoDoc1 = 3000.0;
		salarioNoDoc2 = 4500.0;

		colectivoPoblado.addProfesor(CARNET_DOC1, "Elena", "Avenida 5ta #1202, Playa",
				baseDoc1, CategoriaCientifica.MASTER, CategoriaDocente.PROFESOR_TITULAR, "MES", "UH");
		colectivoPoblado.addProfesor(CARNET_DOC2, "Carlos", "Calle 23 #456, Vedado",
				baseDoc2, CategoriaCientifica.DOCTOR, CategoriaDocente.PROFESOR_AUXILIAR, "MES", "UH");
		colectivoPoblado.addProfesor(CARNET_DOC_EMPATE, "Lucía", "Calle Línea #89, Vedado",
				baseDocEmpate, CategoriaCientifica.NINGUNA, CategoriaDocente.ASISTENTE, "MES", "UH");

		colectivoPoblado.addNoDocente(CARNET_NODOC1, "Marcos", "San Lázaro #301",
				salarioNoDoc1, AreaLaboral.SECRETARIA);
		colectivoPoblado.addNoDocente(CARNET_NODOC2, "Sofía", "Galiano #104",
				salarioNoDoc2, AreaLaboral.LABORATORIO);
	}

	// --- Colectivo vacío ---

	@Test
	public void testTotalPagadoColectivoVacio() {
		assertEquals(0.0, colectivoVacio.getTotalPagado(), DELTA);
	}

	@Test
	public void testTotalPagoProfesoresColectivoVacio() {
		assertEquals(0.0, colectivoVacio.getTotalPagoProfesores(), DELTA);
	}

	@Test
	public void testTotalPagoNoDocentesColectivoVacio() {
		assertEquals(0.0, colectivoVacio.getTotalPagoNoDocentews(), DELTA);
	}

	@Test
	public void testProfesoresMejorPagadosColectivoVacio() {
		assertTrue(colectivoVacio.profesoresMejorPagados().isEmpty());
	}

	@Test
	public void testNoDocentesMejorPagadosColectivoVacio() {
		assertTrue(colectivoVacio.noDocentesMejorPagados().isEmpty());
	}

	@Test
	public void testCarnetYaRegistradoEnColectivoVacio() {
		assertFalse(colectivoVacio.carnetYaRegistrado(CARNET_DOC1));
	}

	// --- Totales con categorías específicas ---

	@Test
	public void testGetTotalPagadoSumaTodosLosTrabajadores() {
		double esperado = salarioDoc1 + salarioDoc2 + salarioDocEmpate + salarioNoDoc1 + salarioNoDoc2;
		assertEquals(esperado, colectivoPoblado.getTotalPagado(), DELTA);
	}

	@Test
	public void testGetTotalPagoProfesoresIncluyePlusCientificoYDocente() {
		double esperado = 6090.0 + 4680.0 + 6090.0;
		assertEquals(esperado, colectivoPoblado.getTotalPagoProfesores(), DELTA);
	}

	@Test
	public void testGetTotalPagoNoDocentesSoloSumaNoDocentes() {
		double esperado = 3000.0 + 4500.0;
		assertEquals(esperado, colectivoPoblado.getTotalPagoNoDocentews(), DELTA);
	}

	// --- Mejores pagados ---

	@Test
	public void testProfesoresMejorPagadosConEmpatePorCategorias() {
		ArrayList<String> ganadores = colectivoPoblado.profesoresMejorPagados();
		List<String> esperados = Arrays.asList("Elena", "Lucía");

		assertEquals(2, ganadores.size());
		assertTrue(ganadores.containsAll(esperados));
	}

	@Test
	public void testNoDocentesMejorPagadosUnicoGanador() {
		ArrayList<String> ganadores = colectivoPoblado.noDocentesMejorPagados();
		assertEquals(Collections.singletonList("Sofía"), ganadores);
	}

	// --- Búsqueda por carné ---

	@Test
	public void testCarnetYaRegistradoEnProfesor() {
		assertTrue(colectivoPoblado.carnetYaRegistrado(CARNET_DOC1));
	}

	@Test
	public void testCarnetYaRegistradoEnNoDocente() {
		assertTrue(colectivoPoblado.carnetYaRegistrado(CARNET_NODOC2));
	}

	@Test
	public void testCarnetNoRegistrado() {
		assertFalse(colectivoPoblado.carnetYaRegistrado(CARNET_NO_REGISTRADO));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCarnetYaRegistradoConArgumentoNulo() {
		colectivoPoblado.carnetYaRegistrado(null);
	}

	// --- Validación de enums nulos ---

	@Test(expected = IllegalArgumentException.class)
	public void testAddProfesorConCategoriaCientificaNula() {
		colectivoVacio.addProfesor(CARNET_DOC1, "Pedro", "Calle 10", 3000.0,
				null, CategoriaDocente.INSTRUCTOR, "MES", "UH");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddProfesorConCategoriaDocenteNula() {
		colectivoVacio.addProfesor(CARNET_DOC1, "Pedro", "Calle 10", 3000.0,
				CategoriaCientifica.NINGUNA, null, "MES", "UH");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddNoDocenteConAreaLaboralNula() {
		colectivoVacio.addNoDocente(CARNET_DOC1, "Pedro", "Calle 10", 3000.0, null);
	}
}