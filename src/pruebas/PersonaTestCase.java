package pruebas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import logica.Persona;

public class PersonaTestCase {
	Persona p;
	

	@Before
	public void setUp() throws Exception {
		p = new Persona();
	}

	@After
	public void tearDown() throws Exception {
		p = null;
	}

	
	
	@Test
	public void nombreNull() {
		try{
			p.setNombre(null);
			fail("No deberia llegar a este punto");
		}
		catch(IllegalArgumentException e){
			assertEquals("ERROR: ingrese una cadena de caracteres que no vacía para nombre (null)", e.getMessage());
		}
	}
	
	@Test
	public void nombreVacio() {
		try{
			p.setNombre("");
			fail("No deberia llegar a este punto");
		}
		catch(IllegalArgumentException e){
			assertEquals("ERROR: ingrese una cadena de caracteres que no vacía para nombre ()", e.getMessage());
		}
	}

	@Test
	public void nombreEspaciado() {
		try{
			p.setNombre("   ");
			fail("No deberia llegar a este punto");
		}
		catch(IllegalArgumentException e){
			assertEquals("ERROR: ingrese una cadena de caracteres que no vacía para nombre (   )", e.getMessage());
		}
	}

	@Test
	public void nombreTildes() {
			p.setNombre("áéíóúüÁÉÍÓÚÜñÑ");
			assertTrue(true);
	}

	
}
