package hortifruti;

import java.util.ArrayList;
import java.util.List;

public class ItensPedido {

	private int codigoProduto;
	private String nomeProduto;
	private double preco;
	private int quantidade;

	public int getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	// adicionar itens no pedido
	public List<ItensPedido> adicionaItensPedido(List<ItensCarrinho> itenscarrinho) {

		List<ItensPedido> itenspedido = new ArrayList<ItensPedido>();

		for (ItensCarrinho ic : itenscarrinho) {
			ItensPedido itens = new ItensPedido();
			itens.setCodigoProduto(ic.getCodigoProduto());
			itens.setNomeProduto(ic.getNomeProduto());
			itens.setPreco(ic.getPreco());
			itens.setQuantidade(ic.getQuantidade());
			itenspedido.add(itens);
		}
		return itenspedido;
	}

}
