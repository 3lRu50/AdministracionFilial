package pruebas;

import static org.junit.Assert.*;
import logica.Asignatura;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class AsignaturaTestCase {

	private Asignatura asignatura;
	
	@Before
	public void setUp(){
		asignatura = new Asignatura("Matemática1", 1,1,80);
	}
	
	 @Test
	    void testConstructorCorrecto() {

	        assertNotNull(asignatura);

	        assertEquals("Matemática1", asignatura.getNombre());
	        assertEquals(1, asignatura.getAnio());
	        assertEquals(1, asignatura.getSemestre());
	        assertEquals(80, asignatura.getHorasLect());
	    }

	 @Test
	    void testGeneracionId() {

	        assertNotNull(asignatura.getId());

	        assertTrue(asignatura.getId().matches("ASG-\\d{2,}"));
	    }
	 
	    @Test
	    void testIdDiferentes() {

	        Asignatura otra = new Asignatura("Fisica", 1, 2, 80);

	        assertNotEquals(asignatura.getId(), otra.getId());
	    }
}
