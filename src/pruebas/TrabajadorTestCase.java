package pruebas;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import logica.Trabajador;

public class TrabajadorTestCase {
	private Trabajador trabajadorValido;
	private final String CARNET_VALIDO = "95051212345";
	private final String NOMBRE_VALIDO = "Elena";
	private final String DIRECCION_VALIDA = "Avenida 5ta #1202, Playa";
	private final double SALARIO_VALIDO = 4500.50;
	private final double DELTA = 0.001; // tolerancia ya que double no es preciso

	@Before
	public void setUp() {
		trabajadorValido = new TrabajadorTest(CARNET_VALIDO, NOMBRE_VALIDO, DIRECCION_VALIDA, SALARIO_VALIDO);
	}

	//bien herencia
	@Test
	public void nombreCorrecto(){
		assertEquals(NOMBRE_VALIDO, trabajadorValido.getNombre());
	}

	//salario
	@Test
	public void testConstructorYCalcularSalarioValido() {
		assertEquals(SALARIO_VALIDO, trabajadorValido.calcularSalario(), DELTA);
	}

	@Test
	public void testSetSalarioBaseValido() {
		double nuevoSalario = 5200.75;
		trabajadorValido.setSalarioBase(nuevoSalario);
		assertEquals(nuevoSalario, trabajadorValido.calcularSalario(), DELTA);
	}

	@Test
	public void testSalarioBaseLimiteMinimoPositivo() {
		trabajadorValido.setSalarioBase(0.01);
		assertEquals(0.01, trabajadorValido.calcularSalario(), DELTA);
	}
	

	// salario invalido
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorSalarioCero() {
		new TrabajadorTest(CARNET_VALIDO, NOMBRE_VALIDO, DIRECCION_VALIDA, 0.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorSalarioNegativo() {
		new TrabajadorTest(CARNET_VALIDO, NOMBRE_VALIDO, DIRECCION_VALIDA, -1500.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetSalarioBaseCero() {
		trabajadorValido.setSalarioBase(0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetSalarioBaseNegativo() {
		trabajadorValido.setSalarioBase(-0.01);
	}
}


class TrabajadorTest extends Trabajador {
		public TrabajadorTest(String carnetId, String nombre, String direccion, double salarioBase) {
			super(carnetId, nombre, direccion, salarioBase);
		}
	}
