package hortifrutiTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import hortifruti.Pessoa;

public class PessoaTest {
	
	// realiza testes em todas as variaveis da classe pessoa
	@Test
	public void testNomeValido() {

		Pessoa p1 = new Pessoa();
		String nome = "Manoela Assis";
		String expected = "Manoela Assis";
		p1.setNome(nome);
		assertEquals(expected, p1.getNome());
	}

	@Test
	public void testNomeInvalido() {
		try {
			Pessoa p2 = new Pessoa();
			p2.setNome("Manoela Assis Brandão de Lima Cavalcante Bragança");
			fail();
		} catch (IllegalArgumentException ex) {
			assertEquals("CAMPO NOME EXCEDEU O TAMANHO MÁXIMO! (40 CARACTERES)", ex.getMessage());
		}
	}

	@Test
	public void testTelefoneValido() {

		Pessoa p3 = new Pessoa();
		String telefone = "(21)96565-2220";
		String expected = "(21)96565-2220";
		p3.setTelefone(telefone);
		assertEquals(expected, p3.getTelefone());
	}

	@Test
	public void testTelefoneInvalido() {
		try {
			Pessoa p4 = new Pessoa();
			p4.setTelefone(" (21) 96565 - 2220 ");
			fail();
		} catch (IllegalArgumentException ex) {
			assertEquals("CAMPO TELEFONE EXCEDEU O TAMANHO MÁXIMO! (XX)XXXXX-XXXX", ex.getMessage());
		}
	}

	@Test
	public void testEnderecoValido() {

		Pessoa p5 = new Pessoa();
		String endereco = "Rua Assis Brandão, 125.";
		String expected = "Rua Assis Brandão, 125.";
		p5.setEndereco(endereco);
		assertEquals(expected, p5.getEndereco());
	}

	@Test
	public void testEnderecoInvalido() {
		try {
			Pessoa p6 = new Pessoa();
			p6.setEndereco(
					"Avenida Pedro de Alcântara Francisco Antônio João Carlos Xavier de Paula Miguel Rafael Joaquim José Gonzaga Pascoal Cipriano Serafim de Bragança e Bourbon, 200.");
			fail();
		} catch (IllegalArgumentException ex) {
			assertEquals("CAMPO ENDEREÇO EXCEDEU O TAMANHO MÁXIMO! (60 CARACTERES)", ex.getMessage());
		}
	}

	@Test
	public void testCEPValido() {

		Pessoa p7 = new Pessoa();
		String cep = "27765-220";
		String expected = "27765-220";
		p7.setCep(cep);
		assertEquals(expected, p7.getCep());
	}

	@Test
	public void testCEPInvalido() {
		try {
			Pessoa p8 = new Pessoa();
			p8.setCep(" 27765 - 220 ");
			fail();
		} catch (IllegalArgumentException ex) {
			assertEquals("CAMPO CEP EXCEDEU O TAMANHO MÁXIMO! XXXXX-XXX", ex.getMessage());
		}
	}

}
