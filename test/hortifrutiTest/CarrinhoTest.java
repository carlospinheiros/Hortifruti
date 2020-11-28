package hortifrutiTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import hortifruti.Carrinho;
import hortifruti.Cliente;
import hortifruti.ItensCarrinho;
import hortifruti.Produto;

public class CarrinhoTest {

	@Test
	public void testCarrinhoValido() {

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

		// cadastra produtos
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

		// insere produtos ao itens do carrinho a partir do código do produto e a
		// quantidade informada
		itenscarrinho.add(ic.adicionaItemCarrinho(produtos, codprod1, qtd1));
		itenscarrinho.add(ic.adicionaItemCarrinho(produtos, codprod2, qtd2));
		itenscarrinho.add(ic.adicionaItemCarrinho(produtos, codprod3, qtd3));

		// insere no carrinho as informações do cliente e dos produtos. também calcula o
		// valor total
		Carrinho carrinho = new Carrinho();
		carrinho = carrinho.valorCarrinho(c1, itenscarrinho);

		int expectedCodCliente = 2000;
		String expectedNomeCliente = "Luiz Souza";
		double expectedTotal = 7.37;

		// verifica cliente e valor total
		assertEquals(expectedCodCliente, carrinho.getCodCliente());
		assertEquals(expectedNomeCliente, carrinho.getNomeCliente());
		assertEquals(expectedTotal, carrinho.getTotal(), 0);

		// verifica os produtos adicionados ao carrinho
		int expected = 3;

		assertEquals(expected, carrinho.getItens().size());

		for (int i = 0; i < carrinho.getItens().size(); i++) {
			if (carrinho.getItens().get(i).getCodigoProduto() == codprod1) {
				assertEquals(codprod1, carrinho.getItens().get(i).getCodigoProduto());
				assertEquals("Banana", carrinho.getItens().get(i).getNomeProduto());
				assertEquals(1.20, carrinho.getItens().get(i).getPreco(), 0);
				assertEquals(qtd1, carrinho.getItens().get(i).getQuantidade());
				break;
			}
		}

		for (int i = 0; i < carrinho.getItens().size(); i++) {
			if (carrinho.getItens().get(i).getCodigoProduto() == codprod2) {
				assertEquals(codprod2, carrinho.getItens().get(i).getCodigoProduto());
				assertEquals("Pêra", carrinho.getItens().get(i).getNomeProduto());
				assertEquals(0.85, carrinho.getItens().get(i).getPreco(), 0);
				assertEquals(qtd2, carrinho.getItens().get(i).getQuantidade());
				break;
			}
		}

		for (int i = 0; i < carrinho.getItens().size(); i++) {
			if (carrinho.getItens().get(i).getCodigoProduto() == codprod3) {
				assertEquals(codprod3, carrinho.getItens().get(i).getCodigoProduto());
				assertEquals("Uva", carrinho.getItens().get(i).getNomeProduto());
				assertEquals(0.72, carrinho.getItens().get(i).getPreco(), 0);
				assertEquals(qtd3, carrinho.getItens().get(i).getQuantidade());
				break;
			}
		}
	}

}
