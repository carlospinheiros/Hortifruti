package hortifrutiTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import hortifruti.Carrinho;
import hortifruti.Cliente;
import hortifruti.ItensCarrinho;
import hortifruti.ItensPedido;
import hortifruti.Pedido;
import hortifruti.Produto;

public class PedidoTest {

	@Test
	public void testPedidoValido() {

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

		ItensPedido ip = new ItensPedido();
		List<ItensPedido> itenspedido = new ArrayList<>();
		itenspedido = ip.adicionaItensPedido(itenscarrinho);

		Pedido pedido = new Pedido();
		pedido = pedido.validaPedido(c1, carrinho, itenspedido);

		int expectedCodCliente = 2000;
		String expectedNomeCliente = "Luiz Souza";
		String expectedTelefone = "(21)94444-2222";
		String expectedEndereco = "Ruas Manoel Bezerra, 125.";
		String expectedCep = "27750-002";
		double expectedTotal = 7.37;

		assertEquals(expectedCodCliente, pedido.getCodigoCliente());
		assertEquals(expectedNomeCliente, pedido.getNome());
		assertEquals(expectedTelefone, pedido.getTelefone());
		assertEquals(expectedEndereco, pedido.getEndereco());
		assertEquals(expectedCep, pedido.getCep());
		assertEquals(expectedTotal, pedido.getTotal(), 0);

		// verifica os produtos adicionados
		int expected = 3;

		assertEquals(expected, pedido.getItens().size());

		for (int i = 0; i < 3; i++) {
			if (pedido.getItens().get(i).getCodigoProduto() == codprod1) {
				assertEquals(codprod1, pedido.getItens().get(i).getCodigoProduto());
				assertEquals("Banana", pedido.getItens().get(i).getNomeProduto());
				assertEquals(1.20, pedido.getItens().get(i).getPreco(), 0);
				assertEquals(qtd1, pedido.getItens().get(i).getQuantidade());
				break;
			}
		}

		for (int i = 0; i < pedido.getItens().size(); i++) {
			if (pedido.getItens().get(i).getCodigoProduto() == codprod2) {
				assertEquals(codprod2, pedido.getItens().get(i).getCodigoProduto());
				assertEquals("Pêra", pedido.getItens().get(i).getNomeProduto());
				assertEquals(0.85, pedido.getItens().get(i).getPreco(), 0);
				assertEquals(qtd2, pedido.getItens().get(i).getQuantidade());
				break;
			}
		}

		for (int i = 0; i < pedido.getItens().size(); i++) {
			if (pedido.getItens().get(i).getCodigoProduto() == codprod3) {
				assertEquals(codprod3, pedido.getItens().get(i).getCodigoProduto());
				assertEquals("Uva", pedido.getItens().get(i).getNomeProduto());
				assertEquals(0.72, pedido.getItens().get(i).getPreco(), 0);
				assertEquals(qtd3, pedido.getItens().get(i).getQuantidade());
				break;
			}
		}

	}

	@Test
	public void testPedidoValorInvalido() {
		try {

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

			int qtd1 = 1; // 1.20
			int qtd2 = 1; // 0.85
			int qtd3 = 1; // 0.72

			// insere produtos ao carrinho
			itenscarrinho.add(ic.adicionaItemCarrinho(produtos, codprod1, qtd1));
			itenscarrinho.add(ic.adicionaItemCarrinho(produtos, codprod2, qtd2));
			itenscarrinho.add(ic.adicionaItemCarrinho(produtos, codprod3, qtd3));

			Carrinho carrinho = new Carrinho();
			carrinho = carrinho.valorCarrinho(c1, itenscarrinho);

			ItensPedido ip = new ItensPedido();
			List<ItensPedido> itenspedido = new ArrayList<>();
			itenspedido = ip.adicionaItensPedido(itenscarrinho);

			Pedido pedido = new Pedido();

			pedido = pedido.validaPedido(c1, carrinho, itenspedido);
			fail();
		} catch (IllegalArgumentException ex) {
			assertEquals("VALOR MINÍMO PARA COMPRA É R$ 5,00!", ex.getMessage());
		}
	}

	@Test
	public void testPedidoClienteInvalido() {
		try {
			// clientes
			Cliente c1 = new Cliente();
			c1.setCodCliente(2000);
			c1.setNome("Luiz Souza");
			c1.setTelefone("(21)94444-2222");
			c1.setEndereco("Rua Manoel Bezerra, 125.");
			c1.setCep("27750-002");

			Cliente c2 = new Cliente();
			c2.setCodCliente(2001);
			c2.setNome("André de Souza");
			c2.setTelefone("(21)91111-0000");
			c2.setEndereco("Rua Oliveira 121.");
			c2.setCep("27880-012");

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

			int qtd1 = 3; // 1.20
			int qtd2 = 4; // 0.85
			int qtd3 = 10; // 0.72

			// insere produtos ao carrinho
			itenscarrinho.add(ic.adicionaItemCarrinho(produtos, codprod1, qtd1));
			itenscarrinho.add(ic.adicionaItemCarrinho(produtos, codprod2, qtd2));
			itenscarrinho.add(ic.adicionaItemCarrinho(produtos, codprod3, qtd3));

			Carrinho carrinho = new Carrinho();
			carrinho = carrinho.valorCarrinho(c1, itenscarrinho); // cliente que armazenou itens ao carrinho foi Luiz
																	// Souza (c1)

			ItensPedido ip = new ItensPedido();
			List<ItensPedido> itenspedido = new ArrayList<>();
			itenspedido = ip.adicionaItensPedido(itenscarrinho);

			Pedido pedido = new Pedido();

			pedido = pedido.validaPedido(c2, carrinho, itenspedido); // pedido está sendo realizado por outro cliente
																		// (André de Souza (c2))
			fail();
		} catch (IllegalArgumentException ex) {
			assertEquals("ERRO EM FINALIZAR O PEDIDO! VERIFIQUE O CÓDIGO DO CLIENTE!", ex.getMessage());
		}
	}

}
