package hortifruti;

import java.util.List;

public class Produto {
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

	// cadastrar produto
	public Produto cadastraProduto(Produto produto) {
		if (produto.getCodigoProduto() <= 0) {
			throw new ViolacaoCodigoException("CÓDIGO NÃO PODE SER MENOR OU IGUAL A ZERO!");
		} else if (produto.getNomeProduto().length() > 25) {
			throw new IllegalArgumentException("CAMPO PRODUTO EXCEDEU O TAMANHO MÁXIMO! (25 CARACTERES)");
		} else if (produto.getPreco() <= 0) {
			throw new ViolacaoPrecoException("PREÇO NÃO PODE SER MENOR OU IGUAL A ZERO!");
		} else if (produto.getQuantidade() <= 0) {
			throw new ViolacaoQuantidadeException("QUANTIDADE NÃO PODE SER MENOR OU IGUAL A ZERO!");
		}
		return produto;
	}

	// alterar as informações cadastradas do produto
	public List<Produto> alteraProduto(List<Produto> produtos, Produto produto) {

		int cont = 0;

		for (Produto p : produtos) {
			if (p.getCodigoProduto() == produto.getCodigoProduto()) {
				produtos.remove(p);
				produtos.add(produto);
				cont++;
				break;
			}
		}
		if (cont == 0) {
			throw new ProdutoNaoAlteradoException("INFORMAÇÕES DO CLIENTE NÃO FORAM ALTERADAS!");
		}
		return produtos;
	}

	// remove produto
	public List<Produto> removeProduto(List<Produto> produtos, int codigoProd) {

		if (codigoProd <= 0) {
			throw new ViolacaoCodigoException("CÓDIGO NÃO PODE SER MENOR OU IGUAL A ZERO!");
		} else {

			int tamanho = produtos.size();

			for (Produto p : produtos) {
				if (p.getCodigoProduto() == codigoProd) {
					produtos.remove(p);
					break;
				}
			}
			if (produtos.size() == tamanho) {
				throw new ProdutoNaoRemovidoException("PRODUTO NÃO REMOVIDO!");
			}
			return produtos;
		}
	}

	@SuppressWarnings("serial")
	public class ViolacaoCodigoException extends IllegalArgumentException {
		public ViolacaoCodigoException(String msg) {
			super(msg);
		}
	}

	@SuppressWarnings("serial")
	public class ViolacaoPrecoException extends IllegalArgumentException {
		public ViolacaoPrecoException(String msg) {
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
	public class ProdutoNaoAlteradoException extends IllegalArgumentException {
		public ProdutoNaoAlteradoException(String msg) {
			super(msg);
		}
	}

	@SuppressWarnings("serial")
	public class ProdutoNaoRemovidoException extends IllegalArgumentException {
		public ProdutoNaoRemovidoException(String msg) {
			super(msg);
		}
	}

}
