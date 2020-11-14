package br.com.qualiti.exemplo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.qualiti.entidades.Filme;
import br.com.qualiti.entidades.Locacao;
import br.com.qualiti.entidades.Usuario;
import br.com.qualiti.servicos.LocacaoService;
import br.com.qualiti.utils.DataUtils;

public class ExemploTest {

	
	@Test
	@DisplayName("Meu primeiro teste no JUnit")
	public void meuPrimeiroTeste() throws Exception {
		
		
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
		List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 2, 5.0));
	
		
		// ACAO : O teste
		
		Locacao locacao = service.alugarFilme(usuario, filmes);
		
		
		
		// VERIFICACAO : Checar resultado do teste
		
		System.out.println(locacao.getValor()==5.0);
		System.out.println(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		System.out.println(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
		
	}
}
