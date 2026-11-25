package pruebas;

import static org.junit.Assert.*;
import logica.CarnetIdentidad;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CarnetIdentidadTestCase {
	CarnetIdentidad c;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		c = null;
	}

	
	
	
	
	@Test
	public void carnetNull() {
		try{
			c = new CarnetIdentidad(null);
			fail("no deberia llegar a este lugar");
		}
		catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}
	
	@Test
	public void carnetVacio() {
		try{
			c = new CarnetIdentidad("");
			fail("no deberia llegar a este lugar");
		}
		catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}
	
	
	@Test
	public void carnet12Numeros() {
		try{
			c = new CarnetIdentidad("123456789012");
			fail("no deberia llegar a este lugar");
		}
		catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}
	
	@Test
	public void carnet10Numeros() {
		try{
			c = new CarnetIdentidad("1234567890");
			fail("no deberia llegar a este lugar");
		}
		catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}
	
	@Test
	public void carnetCorrecto1() {
		c = new CarnetIdentidad("06020483840");
		assertTrue(true);
	}
	
	@Test
	public void carnetCorrecto2() {
		c = new CarnetIdentidad("66011726807");
		assertTrue(true);
	}

	@Test
	public void carnetDiaDespues() {
		try{
			c = new CarnetIdentidad("2611256239");
			fail("no deberia llegar a este lugar");
		}
		catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}
	
	@Test
	public void carnetHoy() {
		try{
			c = new CarnetIdentidad("2611246239");
			fail("no deberia llegar a este lugar");
		}
		catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}
}
