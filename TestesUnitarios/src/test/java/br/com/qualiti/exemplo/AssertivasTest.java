package br.com.qualiti.exemplo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.qualiti.entidades.Usuario;

public class AssertivasTest {

	
	@Test
	@DisplayName("Testes de Condições")
	public void testandoCondicoes() {
		
		assertTrue(true);
		assertFalse(false);
	}
	
	@Test
	@DisplayName("Testes de Long")
	public void testandoLong() {
		
		assertEquals(1 , 1);
		assertNotEquals(1 , 2);
	}
	
	@Test
	@DisplayName("Testes de Double")
	public void testandoDouble() {
		
		assertEquals(0.123 , 0.123);
		assertNotEquals(1.1 , 2.1);
		
		assertEquals(0.123 , 0.123, 0.001);
		assertEquals(Math.PI , 3.14, 0.01);
	}
	
	@Test
	@DisplayName("Testes de Inteiro")
	public void testandoInteiro() {
		
		int i=5;
		Integer i2=5;
		assertEquals(i ,i2);
		
	}
	
	
	@Test
	@DisplayName("Testes de String")
	public void testandoString() {
		
		assertEquals("recode" ,"recode");
		assertNotEquals("recode" ,"Recode");
		assertTrue("recode".equalsIgnoreCase("Recode"));
		assertTrue("recode".startsWith("re"));
	
	}
	
	
	@Test
	@DisplayName("Testes de objetos")
	public void testandoObjetos() {
		
		Usuario usuario1 = new Usuario("Usuario 1");
		Usuario usuario2 = new Usuario("Usuario 1");
		Usuario usuario3 = null;
		
		assertEquals(usuario1,usuario2);
		assertNotSame(usuario1,usuario2);
		assertNull(usuario3);
		assertNotNull(usuario2);
	}
	
	@Test
	@DisplayName("Testes de grupo de asserts")
	public void testandoGrupoDeAsserts() {
		
		int[] numbers = {0 , 1, 2, 3, 4 };
		
		assertAll("numbers",
				() -> assertEquals(numbers[0], 0),
				() -> assertEquals(numbers[1], 1),
				() -> assertEquals(numbers[2], 2)
		);
		
		
		
	}
	
	
}
