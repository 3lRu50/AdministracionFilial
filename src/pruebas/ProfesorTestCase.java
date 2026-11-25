package pruebas;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import enums.CargoConsejoDirectivo;
import enums.CategoriaCientifica;
import enums.CategoriaDocente;
import logica.Profesor;

public class ProfesorTestCase {
	private Profesor profesorValido;
	private final String CARNET_VALIDO = "88031512345";
	private final String NOMBRE_VALIDO = "Beatriz";
	private final String DIRECCION_VALIDA = "Calle 17 #302, Vedado";
	private final double SALARIO_BASE = 5000.00;
	private final String ORGANISMO_VALIDO = "MES";
	private final String CENTRO_VALIDO = "CUJAE";
	private final double DELTA = 0.001;

	@Before
	public void setUp() {
		profesorValido = new Profesor(
			CARNET_VALIDO,
			NOMBRE_VALIDO,
			DIRECCION_VALIDA,
			SALARIO_BASE,
			CategoriaCientifica.MASTER,       
			CategoriaDocente.PROFESOR_TITULAR,
			ORGANISMO_VALIDO,
			CENTRO_VALIDO
		);
	}

	//constructor
	@Test
	public void testConstructorYGettersValidos() {
		assertEquals(CARNET_VALIDO, profesorValido.getCarnetId());
		assertEquals(NOMBRE_VALIDO, profesorValido.getNombre());
		assertEquals(DIRECCION_VALIDA, profesorValido.getDireccion());
		assertEquals(CategoriaCientifica.MASTER, profesorValido.getCatCientifica());
		assertEquals(CategoriaDocente.PROFESOR_TITULAR, profesorValido.getCatDocente());
		assertEquals(ORGANISMO_VALIDO, profesorValido.getOrganismo());
		assertEquals(CENTRO_VALIDO, profesorValido.getCentroLaboral());
		assertNull(profesorValido.getCargo()); // No se inicializa en el constructor
	}

	//salario
	@Test
	public void testCalcularSalarioMasterYTitular() {
		// 5000 + 550 (MASTER) + 540 (PROFESOR_TITULAR) = 6090
		assertEquals(6090.0, profesorValido.calcularSalario(), DELTA);
	}

	@Test
	public void testCalcularSalarioDoctorYAuxiliar() {
		profesorValido.setCatCientifica(CategoriaCientifica.DOCTOR); // +380
		profesorValido.setCatDocente(CategoriaDocente.PROFESOR_AUXILIAR); // +300
		// 5000 + 380 + 300 = 5680
		assertEquals(5680.0, profesorValido.calcularSalario(), DELTA);
	}

	@Test
	public void testCalcularSalarioSinCategoriasPagadas() {
		profesorValido.setCatCientifica(CategoriaCientifica.NINGUNA); // +0
		profesorValido.setCatDocente(CategoriaDocente.INSTRUCTOR); // +0
		// 5000 + 0 + 0 = 5000
		assertEquals(5000.0, profesorValido.calcularSalario(), DELTA);
	}

	@Test
	public void testCalcularSalarioConAsistente() {
		profesorValido.setCatCientifica(CategoriaCientifica.NINGUNA); // +0
		profesorValido.setCatDocente(CategoriaDocente.ASISTENTE); // +200
		assertEquals(5200.0, profesorValido.calcularSalario(), DELTA);
	}

	//cargo
	@Test
	public void testSetCargoConsejoDirectivoValido() {
		profesorValido.setCargo(CargoConsejoDirectivo.DIRECTOR);
		
		profesorValido.setCargo(CargoConsejoDirectivo.SUBDIRECTOR_DOCENTE);
		assertEquals(CargoConsejoDirectivo.SUBDIRECTOR_DOCENTE, profesorValido.getCargo());
	}

	//cantegorias
	@Test(expected = IllegalArgumentException.class)
	public void testSetCatCientificaNula() {
		profesorValido.setCatCientifica(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetCatDocenteNula() {
		profesorValido.setCatDocente(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorCatCientificaNula() {
		new Profesor(CARNET_VALIDO, NOMBRE_VALIDO, DIRECCION_VALIDA, SALARIO_BASE, 
			null, CategoriaDocente.INSTRUCTOR, ORGANISMO_VALIDO, CENTRO_VALIDO);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorCatDocenteNula() {
		new Profesor(CARNET_VALIDO, NOMBRE_VALIDO, DIRECCION_VALIDA, SALARIO_BASE, 
			CategoriaCientifica.NINGUNA, null, ORGANISMO_VALIDO, CENTRO_VALIDO);
	}

	//organizacion y centro
	@Test(expected = IllegalArgumentException.class)
	public void testSetCentroLaboralVacio() {
		profesorValido.setCentroLaboral("   ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetCentroLaboralNulo() {
		profesorValido.setCentroLaboral(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetOrganismoVacio() {
		profesorValido.setOrganismo("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetOrganismoNulo() {
		profesorValido.setOrganismo(null);
	}
}