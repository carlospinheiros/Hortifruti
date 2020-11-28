package hortifruti;

import java.util.List;

public class ItensCarrinho {

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

	// adicionar produto
	public ItensCarrinho adicionaItemCarrinho(List<Produto> produto, int codigoProd, int quantidade) {

		if (codigoProd <= 0) {
			throw new ViolacaoCodigoException("CÓDIGO NÃO PODE SER MENOR OU IGUAL A ZERO!");
		} else if (quantidade <= 0) {
			throw new ViolacaoQuantidadeException("QUANTIDADE NÃO PODE SER MENOR OU IGUAL A ZERO!");
		} else {
			ItensCarrinho itemCarrinho = new ItensCarrinho();

			for (Produto p : produto) {
				if (p.getCodigoProduto() == codigoProd) {
					itemCarrinho.setCodigoProduto(p.getCodigoProduto());
					itemCarrinho.setNomeProduto(p.getNomeProduto());
					itemCarrinho.setPreco(p.getPreco());
					itemCarrinho.setQuantidade(quantidade);
					break;
				}
			}
			return itemCarrinho;
		}
	}

	// alterar a quantidade de determinado produto. cliente deve informar o código
	// do
	// produto
	public ItensCarrinho alteraQtdItemCarrinho(List<ItensCarrinho> produto, int codigoProd, int quantidade) {

		if (codigoProd <= 0) {
			throw new ViolacaoCodigoException("CÓDIGO NÃO PODE SER MENOR OU IGUAL A ZERO!");
		} else if (quantidade <= 0) {
			throw new ViolacaoQuantidadeException("QUANTIDADE NÃO PODE SER MENOR OU IGUAL A ZERO!");
		} else {
			ItensCarrinho itemCarrinho = new ItensCarrinho();

			for (ItensCarrinho p : produto) {
				if (p.getCodigoProduto() == codigoProd) {
					produto.remove(p);
					itemCarrinho.setCodigoProduto(p.getCodigoProduto());
					itemCarrinho.setNomeProduto(p.getNomeProduto());
					itemCarrinho.setPreco(p.getPreco());
					itemCarrinho.setQuantidade(quantidade);
					break;
				}
			}
			return itemCarrinho;
		}
	}

	// remover determinado produto com a informação do código do produto pelo
	// cliente
	public List<ItensCarrinho> removeItemCarrinho(List<ItensCarrinho> produto, int codigoProd) {

		int tamanho = produto.size();

		for (ItensCarrinho c : produto) {
			if (c.getCodigoProduto() == codigoProd) {
				produto.remove(c);
				break;
			}
		}
		if (produto.size() == tamanho) {
			throw new ProdutoNaoRemovidoException("PRODUTO NÃO REMOVIDO DO CARRINHO!");
		}
		return produto;
	}

	// retira todos os produtos
	public List<ItensCarrinho> limpaItensCarrinho(List<ItensCarrinho> carrinho) {

		int tamanho = 0;

		carrinho.clear();

		if (carrinho.size() > tamanho) {
			throw new LimpaCarrinhoException("NÃO FORAM REMOVIDOS OS PRODUTOS DO CARRINHO!");
		}
		return carrinho;
	}

	@SuppressWarnings("serial")
	public class ViolacaoCodigoException extends IllegalArgumentException {
		public ViolacaoCodigoException(String msg) {
			super(msg);
		}
	}

	@SuppressWarnings("serial")
	public class ViolacaoQuantidadeException extends IllegalArgumentException {
		public ViolacaoQuantidadeException(String msg) {
			super(msg);
		}
	}

	@SuppressWarnings("serial")
	public class ProdutosNaoAdicionadosException extends IllegalArgumentException {
		public ProdutosNaoAdicionadosException(String msg) {
			super(msg);
		}
	}

	@SuppressWarnings("serial")
	public class ProdutoNaoRemovidoException extends IllegalArgumentException {
		public ProdutoNaoRemovidoException(String msg) {
			super(msg);
		}
	}

	@SuppressWarnings("serial")
	public class LimpaCarrinhoException extends IllegalArgumentException {
		public LimpaCarrinhoException(String msg) {
			super(msg);
		}
	}

}
