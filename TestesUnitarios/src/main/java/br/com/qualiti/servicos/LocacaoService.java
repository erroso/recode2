package br.com.qualiti.servicos;

import static br.com.qualiti.utils.DataUtils.adicionarDias;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.qualiti.entidades.Filme;
import br.com.qualiti.entidades.Locacao;
import br.com.qualiti.entidades.Usuario;
import br.com.qualiti.exceptions.LocadoraException;
import br.com.qualiti.utils.DataUtils;

public class LocacaoService {
	
	
	public String vPublica;
	protected String vProtegida;
	private String vPrivada;
	String vDefault;
		
	
	// Desafio 2: lançar excecao de filme sem estoque
	// requisito: não deve alugar filmes sem estoque
	
	// Desafio 3: lançar excecao usuario e filme não pode ser nulo
	// Requisito: Usuario e filmes sao obrigatorios
	
	// Desafio 4: Alugar mais de um filme
	// Requisito: O usuario pode alugar mais de um filme
	
	
	
	
	public Locacao alugarFilme(Usuario usuario, List<Filme> filmes) throws LocadoraException {
		if(filmes==null || filmes.isEmpty()) {
			throw new LocadoraException("Filme nulo");
		} 
		
		for(Filme filme : filmes) {
			if(filme==null) {
				throw new LocadoraException("Filme nulo");
			}else if(filme.getEstoque()==0) {
				throw new LocadoraException("Filme sem estoque");
			}
			
		}
		
		if(usuario==null) {
			throw new LocadoraException("Usuario nulo");
		}	
		
		Locacao locacao = new Locacao();
		locacao.setFilmes(filmes);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		Double valorTotal = 0d;
		for (int i=0; i < filmes.size() ; i++) {
			Filme filme = filmes.get(i);
			valorTotal += filme.getPrecoLocacao();
			
		}
		
		locacao.setValor(valorTotal);

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//TODO adicionar mÃ©todo para salvar
		
		return locacao;
	}

	
}