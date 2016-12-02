package edu.lojavirtual.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.lojavirtual.dao.VendaDAO;
import edu.lojavirtual.entidades.Produto;
import edu.lojavirtual.entidades.Venda;

public class CarrinhoService {

	List<Produto> prodAtual;
	List<Venda> vendaAtual;

	public CarrinhoService(List<Produto> prodAtual) {
		this.prodAtual = prodAtual;
	}
	
	public List<Produto> getProdutos(){
		return prodAtual;
	}

	public List<Venda> getVendas(){
		return vendaAtual;
	}
	
	public List<Venda> somaQuantidade(List<Venda> vendaAtual) {
		this.vendaAtual = vendaAtual;
		for (Venda v : vendaAtual) {
				v.setQuantidade(v.getQuantidade() + 1);
		}

		return vendaAtual;
	}

	public double somarCarrinho(List<Venda> vendaAtual ) {
		this.vendaAtual = vendaAtual;
		double total = 0.0;
		if (!(vendaAtual == null)) {
			for (Venda v : vendaAtual) {
				//total += prodAtual.getPreco() * vendaAtual.getQuantidade();
			}
		}
		return total;
	}


}