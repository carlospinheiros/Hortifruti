package hortifrutiTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import hortifruti.Funcionario;

public class FuncionarioTest {

	@Test
	public void testCadastrarFuncionario() {

		// funcionarios
		Funcionario f1 = new Funcionario();
		f1.setCodFuncionario(1001);
		f1.setNome("André Marques");
		f1.setTelefone("(21)96565-2201");
		f1.setEndereco("Rua Souza Muniz, 36.");
		f1.setCep("18851-211");

		Funcionario f2 = new Funcionario();
		f2.setCodFuncionario(1002);
		f2.setNome("Lucas Souza");
		f2.setTelefone("(21)91111-2201");
		f2.setEndereco("Rua Oliveira, 115.");
		f2.setCep("29951-111");

		Funcionario f3 = new Funcionario();
		f3.setCodFuncionario(1003);
		f3.setNome("Mateus Mello");
		f3.setTelefone("(21)2222-3301");
		f3.setEndereco("Ruas Martins Santos, 23.");
		f3.setCep("28899-121");

		Funcionario f = new Funcionario();
		List<Funcionario> funcionarios = new ArrayList<>();

		// insere funcionario
		funcionarios.add(f.cadastraFuncionario(f1));
		funcionarios.add(f.cadastraFuncionario(f2));
		funcionarios.add(f.cadastraFuncionario(f3));

		int expected = 3;

		assertEquals(expected, funcionarios.size());
		assertTrue(funcionarios.contains(f1));
		assertTrue(funcionarios.contains(f2));
		assertTrue(funcionarios.contains(f3));

	}

	@Test
	public void testAlterarFuncionario() {

		// funcionários
		Funcionario f1 = new Funcionario();
		f1.setCodFuncionario(1001);
		f1.setNome("André Marques");
		f1.setTelefone("(21)96565-2201");
		f1.setEndereco("Rua Souza Muniz, 36.");
		f1.setCep("18851-211");

		Funcionario f2 = new Funcionario();
		f2.setCodFuncionario(1002);
		f2.setNome("Lucas Souza");
		f2.setTelefone("(21)91111-2201");
		f2.setEndereco("Rua Oliveira, 115.");
		f2.setCep("29951-111");

		Funcionario f3 = new Funcionario();
		f3.setCodFuncionario(1003);
		f3.setNome("Mateus Mello");
		f3.setTelefone("(21)2222-3301");
		f3.setEndereco("Ruas Martins Santos, 23.");
		f3.setCep("28899-121");

		Funcionario f = new Funcionario();
		List<Funcionario> funcionarios = new ArrayList<>();

		// insere funcionario
		funcionarios.add(f.cadastraFuncionario(f1));
		funcionarios.add(f.cadastraFuncionario(f2));
		funcionarios.add(f.cadastraFuncionario(f3));

		// funcionario a ser alterado
		Funcionario f4 = new Funcionario();
		f4.setCodFuncionario(1003);
		f4.setNome("Luan Moreira");
		f4.setTelefone("(21)1111-2222");
		f4.setEndereco("Ruas Lopes Neto, 62.");
		f4.setCep("27771-121");

		// altera funcionario
		funcionarios = f.alteraFuncionario(funcionarios, f4);

		int expected = 3;

		assertEquals(expected, funcionarios.size());
		assertTrue(funcionarios.contains(f1));
		assertTrue(funcionarios.contains(f2));
		assertFalse(funcionarios.contains(f3));
		assertTrue(funcionarios.contains(f4));

	}

	@Test
	public void testRemoverFuncionario() {

		// funcionarios
		Funcionario f1 = new Funcionario();
		f1.setCodFuncionario(1001);
		f1.setNome("André Marques");
		f1.setTelefone("(21)96565-2201");
		f1.setEndereco("Rua Souza Muniz, 36.");
		f1.setCep("18851-211");

		Funcionario f2 = new Funcionario();
		f2.setCodFuncionario(1002);
		f2.setNome("Lucas Souza");
		f2.setTelefone("(21)91111-2201");
		f2.setEndereco("Rua Oliveira, 115.");
		f2.setCep("29951-111");

		Funcionario f3 = new Funcionario();
		f3.setCodFuncionario(1003);
		f3.setNome("Mateus Mello");
		f3.setTelefone("(21)2222-3301");
		f3.setEndereco("Ruas Martins Santos, 23.");
		f3.setCep("28899-121");

		Funcionario f = new Funcionario();
		List<Funcionario> funcionarios = new ArrayList<>();

		// insere funcionario
		funcionarios.add(f.cadastraFuncionario(f1));
		funcionarios.add(f.cadastraFuncionario(f2));
		funcionarios.add(f.cadastraFuncionario(f3));

		int codfuncionario = 1003; // código do funcionário a ser removido

		// remove funcionário
		funcionarios = f.removeFuncionario(funcionarios, codfuncionario);

		int expected = 2;

		assertEquals(expected, funcionarios.size());
		assertTrue(funcionarios.contains(f1));
		assertTrue(funcionarios.contains(f2));
		assertFalse(funcionarios.contains(f3));
	}

}
