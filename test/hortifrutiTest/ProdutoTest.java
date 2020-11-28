package hortifrutiTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import hortifruti.Produto;

public class ProdutoTest {

	@Test
	public void testCadastrarProduto() {

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

		int expected = 3;

		assertEquals(expected, produtos.size());
		assertTrue(produtos.contains(p1));
		assertTrue(produtos.contains(p2));
		assertTrue(produtos.contains(p3));

	}

	@Test
	public void testAlterarProduto() {

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

		Produto p4 = new Produto();
		p4.setCodigoProduto(910);
		p4.setNomeProduto("Pêra");
		p4.setPreco(0.96);
		p4.setQuantidade(12);

		// altera produto
		produtos = p.alteraProduto(produtos, p4);

		int expected = 3;

		assertEquals(expected, produtos.size());
		assertTrue(produtos.contains(p1));
		assertTrue(produtos.contains(p3));
		assertFalse(produtos.contains(p2));
		assertTrue(produtos.contains(p4));

	}

	@Test
	public void testRemoverProduto() {

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

		int codproduto = 920; // código do produto a ser removido

		// remove produto
		produtos = p.removeProduto(produtos, codproduto);

		int expected = 2;

		assertEquals(expected, produtos.size());
		assertTrue(produtos.contains(p1));
		assertTrue(produtos.contains(p2));
		assertFalse(produtos.contains(p3));

	}

}
