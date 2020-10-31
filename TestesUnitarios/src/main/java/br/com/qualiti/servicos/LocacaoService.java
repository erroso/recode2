package br.com.qualiti.servicos;

import static br.com.qualiti.utils.DataUtils.adicionarDias;

import java.util.Date;

import br.com.qualiti.entidades.Filme;
import br.com.qualiti.entidades.Locacao;
import br.com.qualiti.entidades.Usuario;

public class LocacaoService {
	
	public Locacao alugarFilme(Usuario usuario, Filme filme) {
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(filme.getPrecoLocacao());

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//TODO adicionar método para salvar
		
		return locacao;
	}

	public static void main(String[] args) {
		
		
		// Faça um teste do metodo alugarFilme() apenas usando Java. 
		// Para simplificar vamos verificar apenas o valor do filme, a data de locação e data de retorno
		// Todo teste deve ser estruturado da seguinte forma:
		
		// CENARIOS: Montagem de ambiente
		
		
		
		// ACAO : O teste
		
		
		
		
		// VERIFICACAO : Checar resultado do teste
		
		
		
	}
}