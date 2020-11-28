package hortifruti;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

	private int codCliente;
	private String nomeCliente;
	private double total;
	private List<ItensCarrinho> itenscarrinho = new ArrayList<ItensCarrinho>();

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<ItensCarrinho> getItens() {
		return this.itenscarrinho;
	}

	public void setItens(List<ItensCarrinho> itenscarrinho) {
		this.itenscarrinho = itenscarrinho;
	}
	
	// calcula valor total do carrinho, carrega código e nome do cliente e carrega os produtos.
	public Carrinho valorCarrinho(Cliente cliente, List<ItensCarrinho> itenscarrinho) {

		Carrinho carrinho = new Carrinho();

		double total = 0;

		for (ItensCarrinho ic : itenscarrinho) {
			total += ic.getPreco() * ic.getQuantidade();
			itenscarrinho.add(ic);
		}

		carrinho.setCodCliente(cliente.getCodCliente());
		carrinho.setNomeCliente(cliente.getNome());
		carrinho.setTotal(total);
		carrinho.setItens(itenscarrinho);

		return carrinho;
	}

	@SuppressWarnings("serial")
	public class ViolacaoTotalException extends IllegalArgumentException {
		public ViolacaoTotalException(String msg) {
			super(msg);
		}
	}

}
