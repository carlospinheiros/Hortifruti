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
	
	// cadastrar funcionário
	public Funcionario cadastraFuncionario(Funcionario funcionario) {
		if (funcionario.getCodFuncionario() <= 0) {
			throw new ViolacaoCodigoPessoaException("CÓDIGO NÃO PODE SER MENOR OU IGUAL A ZERO!");
		}
		return funcionario;
	}
	
	// alterar informações cadastradas do funcionário
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
			throw new FuncionarioNaoAlteradoException("INFORMAÇÕES DO FUNCIONÁRIO NÃO FORAM ALTERADAS!");
		}
		return funcionarios;
	}
	
	// remover funcionário
	public List<Funcionario> removeFuncionario(List<Funcionario> funcionarios, int codigoFunc) {

		if (codigoFunc <= 0) {
			throw new ViolacaoCodigoPessoaException("CÓDIGO NÃO PODE SER MENOR OU IGUAL A ZERO!");
		} else {

			int tamanho = funcionarios.size();

			for (Funcionario f : funcionarios) {
				if (f.getCodFuncionario() == codigoFunc) {
					funcionarios.remove(f);
					break;
				}
			}
			if (funcionarios.size() == tamanho) {
				throw new FuncionarioNaoRemovidoException("FUNCIONÁRIO NÃO REMOVIDO!");
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
