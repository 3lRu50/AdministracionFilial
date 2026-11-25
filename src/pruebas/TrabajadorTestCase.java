package pruebas;

import static org.junit.Assert.*;
import logica.Trabajador;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TrabajadorTestCase {
	Trabajador p;

	@Before
	public void setUp() throws Exception {
		p = new Trabajador();
	}

	@After
	public void tearDown() throws Exception {
		p = null;
	}

	@Test
	public void salario0() {
		try{
			p.setSalario(0);
			fail("no debe llegar a aqui");
		}
		catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}

	@Test
	public void salarioNeg() {
		try{
			p.setSalario(-1);
			fail("no debe llegar a aqui");
		}
		catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}

	@Test
	public void salarioPos() {
		p.setSalario(1);
		assertTrue(true);
	}
}
