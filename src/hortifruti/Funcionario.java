package hortifruti;

import java.util.List;

public class Funcionario extends Pessoa {

	private int codFuncionario;

	public int getCodFuncionario() {
		return codFuncionario;
	}

	public void setCodFuncionario(int codFuncionario) {
		this.codFuncionario = codFuncionario;
	}
	
	// cadastrar funcion�rio
	public Funcionario cadastraFuncionario(Funcionario funcionario) {
		if (funcionario.getCodFuncionario() <= 0) {
			throw new ViolacaoCodigoPessoaException("C�DIGO N�O PODE SER MENOR OU IGUAL A ZERO!");
		}
		return funcionario;
	}
	
	// alterar informa��es cadastradas do funcion�rio
	public List<Funcionario> alteraFuncionario(List<Funcionario> funcionarios, Funcionario func) {

		int cont = 0;

		for (Funcionario f : funcionarios) {
			if (f.getCodFuncionario() == func.getCodFuncionario()) {
				funcionarios.remove(f);
				funcionarios.add(func);
				cont++;
				break;
			}
		}
		if (cont == 0) {
			throw new FuncionarioNaoAlteradoException("INFORMA��ES DO FUNCION�RIO N�O FORAM ALTERADAS!");
		}
		return funcionarios;
	}
	
	// remover funcion�rio
	public List<Funcionario> removeFuncionario(List<Funcionario> funcionarios, int codigoFunc) {

		if (codigoFunc <= 0) {
			throw new ViolacaoCodigoPessoaException("C�DIGO N�O PODE SER MENOR OU IGUAL A ZERO!");
		} else {

			int tamanho = funcionarios.size();

			for (Funcionario f : funcionarios) {
				if (f.getCodFuncionario() == codigoFunc) {
					funcionarios.remove(f);
					break;
				}
			}
			if (funcionarios.size() == tamanho) {
				throw new FuncionarioNaoRemovidoException("FUNCION�RIO N�O REMOVIDO!");
			}
			return funcionarios;
		}
	}

	@SuppressWarnings("serial")
	public class ViolacaoCodigoPessoaException extends IllegalArgumentException {
		public ViolacaoCodigoPessoaException(String msg) {
			super(msg);
		}
	}

	@SuppressWarnings("serial")
	public class FuncionariosNaoAdicionadosException extends IllegalArgumentException {
		public FuncionariosNaoAdicionadosException(String msg) {
			super(msg);
		}
	}

	@SuppressWarnings("serial")
	public class FuncionarioNaoAlteradoException extends IllegalArgumentException {
		public FuncionarioNaoAlteradoException(String msg) {
			super(msg);
		}
	}

	@SuppressWarnings("serial")
	public class FuncionarioNaoRemovidoException extends IllegalArgumentException {
		public FuncionarioNaoRemovidoException(String msg) {
			super(msg);
		}
	}

}
