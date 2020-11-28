package hortifrutiTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import hortifruti.Carrinho;
import hortifruti.Cliente;
import hortifruti.ItensCarrinho;
import hortifruti.ItensPedido;
import hortifruti.Produto;

public class ItensPedidoTest {

	@Test
	public void testadicionaItensPedido() {

		// cliente
		Cliente c1 = new Cliente();
		c1.setCodCliente(2000);
		c1.setNome("Luiz Souza");
		c1.setTelefone("(21)94444-2222");
		c1.setEndereco("Ruas Manoel Bezerra, 125.");
		c1.setCep("27750-002");

		// produtos
		Produto p1 = new Produto();
		p1.setCodigoProduto(900);
		p1.setNomeProduto("Banana");
		p1.setPreco(1.20);
		p1.setQuantidade(15);

		Produto p2 = new Produto();
		p2.setCodigoProduto(910);
		p2.setNomeProduto("Pêra");
		p2.setPreco(0.85);
		p2.setQuantidade(10);

		Produto p3 = new Produto();
		p3.setCodigoProduto(920);
		p3.setNomeProduto("Uva");
		p3.setPreco(0.72);
		p3.setQuantidade(35);

		Produto p = new Produto();
		List<Produto> produtos = new ArrayList<>();

		// insere produto
		produtos.add(p.cadastraProduto(p1));
		produtos.add(p.cadastraProduto(p2));
		produtos.add(p.cadastraProduto(p3));

		ItensCarrinho ic = new ItensCarrinho();
		List<ItensCarrinho> itenscarrinho = new ArrayList<>();

		int codprod1 = 900;
		int codprod2 = 910;
		int codprod3 = 920;

		int qtd1 = 2; // 1.20
		int qtd2 = 5; // 0.85
		int qtd3 = 1; // 0.72

		// insere produtos ao carrinho
		itenscarrinho.add(ic.adicionaItemCarrinho(produtos, codprod1, qtd1));
		itenscarrinho.add(ic.adicionaItemCarrinho(produtos, codprod2, qtd2));
		itenscarrinho.add(ic.adicionaItemCarrinho(produtos, codprod3, qtd3));

		Carrinho carrinho = new Carrinho();
		carrinho = carrinho.valorCarrinho(c1, itenscarrinho);

		// adiciona itens do carrinho ao itens do pedido
		ItensPedido ip = new ItensPedido();
		List<ItensPedido> itenspedido = new ArrayList<>();
		itenspedido = ip.adicionaItensPedido(itenscarrinho);

		// verifica os produtos adicionados
		int expected = 3;

		assertEquals(expected, itenspedido.size());

		for (ItensPedido ipedido : itenspedido) {
			if (ipedido.getCodigoProduto() == codprod1) {
				assertEquals(codprod1, ipedido.getCodigoProduto());
				assertEquals("Banana", ipedido.getNomeProduto());
				assertEquals(1.20, ipedido.getPreco(), 0);
				assertEquals(qtd1, ipedido.getQuantidade());
				break;
			}
		}

		for (ItensPedido ipedido : itenspedido) {
			if (ipedido.getCodigoProduto() == codprod2) {
				assertEquals(codprod2, ipedido.getCodigoProduto());
				assertEquals("Pêra", ipedido.getNomeProduto());
				assertEquals(0.85, ipedido.getPreco(), 0);
				assertEquals(qtd2, ipedido.getQuantidade());
				break;
			}
		}

		for (ItensPedido ipedido : itenspedido) {
			if (ipedido.getCodigoProduto() == codprod3) {
				assertEquals(codprod3, ipedido.getCodigoProduto());
				assertEquals("Uva", ipedido.getNomeProduto());
				assertEquals(0.72, ipedido.getPreco(), 0);
				assertEquals(qtd3, ipedido.getQuantidade());
				break;
			}
		}
	}

}
