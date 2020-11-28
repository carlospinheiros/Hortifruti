package hortifrutiTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import hortifruti.ItensCarrinho;
import hortifruti.Produto;

public class ItensCarrinhoTest {

	@Test
	public void testAdicionarProdutoCarrinho() {

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

		int qtd1 = 2;
		int qtd2 = 5;
		int qtd3 = 1;

		// insere produtos ao carrinho
		itenscarrinho.add(ic.adicionaItemCarrinho(produtos, codprod1, qtd1));
		itenscarrinho.add(ic.adicionaItemCarrinho(produtos, codprod2, qtd2));
		itenscarrinho.add(ic.adicionaItemCarrinho(produtos, codprod3, qtd3));
		
		// verifica os produtos adicionados
		int expected = 3;

		assertEquals(expected, itenscarrinho.size());

		for (ItensCarrinho icarrinho : itenscarrinho) {
			if (icarrinho.getCodigoProduto() == codprod1) {
				assertEquals(codprod1, icarrinho.getCodigoProduto());
				assertEquals("Banana", icarrinho.getNomeProduto());
				assertEquals(1.20, icarrinho.getPreco(), 0);
				assertEquals(qtd1, icarrinho.getQuantidade());
				break;
			}
		}

		for (ItensCarrinho icarrinho : itenscarrinho) {
			if (icarrinho.getCodigoProduto() == codprod2) {
				assertEquals(codprod2, icarrinho.getCodigoProduto());
				assertEquals("Pêra", icarrinho.getNomeProduto());
				assertEquals(0.85, icarrinho.getPreco(), 0);
				assertEquals(qtd2, icarrinho.getQuantidade());
				break;
			}
		}

		for (ItensCarrinho icarrinho : itenscarrinho) {
			if (icarrinho.getCodigoProduto() == codprod3) {
				assertEquals(codprod3, icarrinho.getCodigoProduto());
				assertEquals("Uva", icarrinho.getNomeProduto());
				assertEquals(0.72, icarrinho.getPreco(), 0);
				assertEquals(qtd3, icarrinho.getQuantidade());
				break;
			}
		}
	}

	@Test
	public void testAlterarQtdProdutoCarrinho() {

		Produto p1 = new Produto();
		p1.setCodigoProduto(900);
		p1.setNomeProduto("Banana");
		p1.setPreco(1.20);
		p1.setQuantidade(15);

		Produto p = new Produto();
		List<Produto> produtos = new ArrayList<>();

		// insere produto
		produtos.add(p.cadastraProduto(p1));

		ItensCarrinho ic = new ItensCarrinho();
		List<ItensCarrinho> itenscarrinho = new ArrayList<>();

		int codprod1 = 900;
		int qtd1 = 2;

		// insere produtos ao carrinho
		itenscarrinho.add(ic.adicionaItemCarrinho(produtos, codprod1, qtd1));

		// altera a quantidade do produto no carrinho
		int qtdAlterada = 5;
		itenscarrinho.add(ic.alteraQtdItemCarrinho(itenscarrinho, codprod1, qtdAlterada));

		// verifica o produtos
		int expected = 1;

		assertEquals(expected, itenscarrinho.size());

		for (ItensCarrinho icarrinho : itenscarrinho) {
			if (icarrinho.getCodigoProduto() == codprod1) {
				assertEquals(codprod1, icarrinho.getCodigoProduto());
				assertEquals("Banana", icarrinho.getNomeProduto());
				assertEquals(1.20, icarrinho.getPreco(), 0);
				assertEquals(qtdAlterada, icarrinho.getQuantidade());
				break;
			}
		}
	}

	@Test
	public void testRemoverProdutoCarrinho() {

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

		int qtd1 = 2;
		int qtd2 = 5;
		int qtd3 = 1;

		// insere produtos ao carrinho
		itenscarrinho.add(ic.adicionaItemCarrinho(produtos, codprod1, qtd1));
		itenscarrinho.add(ic.adicionaItemCarrinho(produtos, codprod2, qtd2));
		itenscarrinho.add(ic.adicionaItemCarrinho(produtos, codprod3, qtd3));

		// remove produto ao carrinho
		int codprodRemover = 920;
		itenscarrinho = ic.removeItemCarrinho(itenscarrinho, codprodRemover);

		// verifica os produtos
		int expected = 2;

		assertEquals(expected, itenscarrinho.size());

		for (ItensCarrinho icarrinho : itenscarrinho) {
			if (icarrinho.getCodigoProduto() == codprod1) {
				assertEquals(codprod1, icarrinho.getCodigoProduto());
				assertEquals("Banana", icarrinho.getNomeProduto());
				assertEquals(1.20, icarrinho.getPreco(), 0);
				assertEquals(qtd1, icarrinho.getQuantidade());
				break;
			}
		}

		for (ItensCarrinho icarrinho : itenscarrinho) {
			if (icarrinho.getCodigoProduto() == codprod2) {
				assertEquals(codprod2, icarrinho.getCodigoProduto());
				assertEquals("Pêra", icarrinho.getNomeProduto());
				assertEquals(0.85, icarrinho.getPreco(), 0);
				assertEquals(qtd2, icarrinho.getQuantidade());
				break;
			}
		}

		// verifica se o produto foi removido
		for (ItensCarrinho icarrinho : itenscarrinho) {
			assertNotEquals(codprodRemover, icarrinho.getCodigoProduto());
		}
	}

	@Test
	public void testLimparCarrinho() {

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

		int qtd1 = 2;
		int qtd2 = 5;
		int qtd3 = 1;

		// insere produtos ao carrinho
		itenscarrinho.add(ic.adicionaItemCarrinho(produtos, codprod1, qtd1));
		itenscarrinho.add(ic.adicionaItemCarrinho(produtos, codprod2, qtd2));
		itenscarrinho.add(ic.adicionaItemCarrinho(produtos, codprod3, qtd3));

		// limpa ao carrinho
		itenscarrinho = ic.limpaItensCarrinho(itenscarrinho);

		int expected = 0;

		assertEquals(expected, itenscarrinho.size());
	}

}
