package br.com.qualiti.servicos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.qualiti.entidades.Filme;
import br.com.qualiti.entidades.Locacao;
import br.com.qualiti.entidades.Usuario;
import br.com.qualiti.utils.DataUtils;

public class LocacaoServiceTest {

	
	@Test
	@DisplayName("Meu primeiro teste no JUnit")
	public void meuPrimeiroTeste() {
				
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
		
		LocacaoService service = new LocacaoService();
		Usuario usuario =new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 2, 5.0);
		
		// ACAO : O teste
		
		Locacao locacao = service.alugarFilme(usuario, filme);
		
		
		// VERIFICACAO : Checar resultado do teste
		
		assertTrue(locacao.getValor()==5.0);
		assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
		
	}
}
