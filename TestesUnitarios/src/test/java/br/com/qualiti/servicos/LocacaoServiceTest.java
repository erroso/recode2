package br.com.qualiti.servicos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.qualiti.entidades.Filme;
import br.com.qualiti.entidades.Locacao;
import br.com.qualiti.entidades.Usuario;
import br.com.qualiti.exceptions.LocadoraException;
import br.com.qualiti.utils.DataUtils;

public class LocacaoServiceTest {

	private LocacaoService service;
	
	@BeforeEach
	public void antesDosMetodos() {
		System.out.println("-- antes de cada metodo --");
		service = new LocacaoService();
	}
	
	@AfterEach
	public void depoisDosMetodos() {
		System.out.println("-- depois  de cada metodo --");
	}
	
	@AfterAll
	static void depoisDeTodosMetodos() {
		System.out.println("-- depois de todos metodos --");
	}
	
	@BeforeAll
	static void antesDeTodosMetodos() {
		System.out.println("-- antes de todos metodo --");
	    
	}
	
	
	@Test
	@DisplayName("Meu primeiro teste no JUnit")
	public void meuPrimeiroTeste() throws Exception {
		System.out.println("-- teste 1 --");		
		// Faça um teste do metodo alugarFilme() apenas usando Java. 
		// Para simplificar vamos verificar apenas o valor do filme, a data de locação e data de retorno
		
		//FIRST
		//{F}ast
		//{i}ndependent
		//{R}epeatable
		//{S}elf-verifying
		//{T}imely
		
		// Todo teste deve ser estruturado da seguinte forma:
		
		// CENARIOS: Montagem de ambiente

		Usuario usuario =new Usuario("Usuario 1");
//		Filme filme = new Filme("Filme 1", 2, 5.0);
		List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 2, 5.0));
		
		// ACAO : O teste
		Locacao locacao = service.alugarFilme(usuario, filmes);

		// VERIFICACAO : Checar resultado do teste
		
		assertTrue(locacao.getValor()==5.0);
		assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
		
	}
	
	
	@Test
	@DisplayName("Verificar filme sem estoque")
	public void verificaFilmeSemEstoque() {
		System.out.println("-- teste 2 --");	
		// cenario
		Usuario usuario = new Usuario("Usuario 1");
		List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 0, 5.0));
		// acao
		
		Exception exceptionEsperada = assertThrows(Exception.class, () -> {
				//metodo que lanca a excecao
				service.alugarFilme(usuario, filmes);
		});
		
		//verificacao
		assertEquals(exceptionEsperada.getMessage(), "Filme sem estoque");
	}
	
	
	@Test
	@DisplayName("Verificar filme eh nulo")
	public void verificaFilmeEhNulo() {
		System.out.println("-- teste 3 --");	
		// cenario
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = null;
		List<Filme> filmes = Arrays.asList(filme);
		// acao
		
		LocadoraException exceptionEsperada = assertThrows(LocadoraException.class, () -> {
				//metodo que lanca a excecao
				service.alugarFilme(usuario, filmes);
		});
		
		//verificacao
		assertEquals(exceptionEsperada.getMessage(), "Filme nulo");
	}
	
	
	@Test
	@DisplayName("Verificar usuario eh nulo")
	public void verificaUsuarioEhNulo() {
		Usuario usuario = null;
		List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 2, 5.0));
		LocadoraException exceptionEsperada = assertThrows(LocadoraException.class, () -> {
				service.alugarFilme(usuario, filmes);
		});
		assertEquals(exceptionEsperada.getMessage(), "Usuario nulo");
	}
	
	// Desafio 5 - 
	// O cliente tem desconto crescentes (n�o acumulativos):
	// - 25% no 3� filme
	// - 50% no 4� filme
	// - 75% no 5� filme
	// - 100% no 6� filme
	// - n�o tem desconto no 7� filme em diante
	
	
	

	
	
	
}
