package hortifruti;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private int codigoCliente;
	private String nome;
	private String telefone;
	private String endereco;
	private String cep;
	private double total;
	private List<ItensPedido> itenspedido = new ArrayList<ItensPedido>();

	public int getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<ItensPedido> getItens() {
		return this.itenspedido;
	}

	public void setItens(List<ItensPedido> itenspedido) {
		this.itenspedido = itenspedido;
	}

	// valida pedido. verifica se o cliente é cadastrado e verifica o valor de
	// compra mínimo
	public Pedido validaPedido(Cliente cliente, Carrinho carrinho, List<ItensPedido> itenspedido) {

		Pedido pedido = new Pedido();

		if (cliente.getCodCliente() != carrinho.getCodCliente()) {
			throw new ClientesNaoCadastradoException("ERRO EM FINALIZAR O PEDIDO! VERIFIQUE O CÓDIGO DO CLIENTE!");
		} else {
			if (carrinho.getTotal() < 5.00) {
				throw new ValorMinimoException("VALOR MINÍMO PARA COMPRA É R$ 5,00!");
			} else {
				pedido.setCodigoCliente(cliente.getCodCliente());
				pedido.setNome(cliente.getNome());
				pedido.setTelefone(cliente.getTelefone());
				pedido.setEndereco(cliente.getEndereco());
				pedido.setCep(cliente.getCep());
				pedido.setTotal(carrinho.getTotal());
				pedido.setItens(itenspedido);
			}
		}
		return pedido;
	}

	@SuppressWarnings("serial")
	public class ClientesNaoCadastradoException extends IllegalArgumentException {
		public ClientesNaoCadastradoException(String msg) {
			super(msg);
		}
	}

	@SuppressWarnings("serial")
	public class ValorMinimoException extends IllegalArgumentException {
		public ValorMinimoException(String msg) {
			super(msg);
		}
	}

}
