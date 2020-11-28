package hortifruti;

import java.util.List;

public class Cliente extends Pessoa {

	private int codcliente;

	public int getCodCliente() {
		return codcliente;
	}

	public void setCodCliente(int codcliente) {
		this.codcliente = codcliente;
	}
	
	// cadastrar cliente
	public Cliente cadastraCliente(Cliente cliente) {
		if (cliente.getCodCliente() <= 0) {
			throw new ViolacaoCodigoPessoaException("CÓDIGO NÃO PODE SER MENOR OU IGUAL A ZERO!");
		}
		return cliente;
	}
	
	// alterar as informações cadastradas do cliente
	public List<Cliente> alteraCliente(List<Cliente> clientes, Cliente cli) {

		int cont = 0;

		for (Cliente c : clientes) {
			if (c.getCodCliente() == cli.getCodCliente()) {
				clientes.remove(c);
				clientes.add(cli);
				cont++;
				break;
			}
		}
		if (cont == 0) {
			throw new ClienteNaoAlteradoException("INFORMAÇÕES DO CLIENTE NÃO FORAM ALTERADAS!");
		}
		return clientes;
	}
	
	// remover cliente
	public List<Cliente> removeCliente(List<Cliente> clientes, int codigoCli) {

		if (codigoCli <= 0) {
			throw new ViolacaoCodigoPessoaException("CÓDIGO NÃO PODE SER MENOR OU IGUAL A ZERO!");
		} else {
			int tamanho = clientes.size();

			for (Cliente c : clientes) {
				if (c.getCodCliente() == codigoCli) {
					clientes.remove(c);
					break;
				}
			}
			if (clientes.size() == tamanho) {
				throw new ClienteNaoRemovidoException("CLIENTE NÃO REMOVIDO!");
			}
			return clientes;
		}
	}

	@SuppressWarnings("serial")
	public class ViolacaoCodigoPessoaException extends IllegalArgumentException {
		public ViolacaoCodigoPessoaException(String msg) {
			super(msg);
		}
	}

	@SuppressWarnings("serial")
	public class ClientesNaoAdicionadosException extends IllegalArgumentException {
		public ClientesNaoAdicionadosException(String msg) {
			super(msg);
		}
	}

	@SuppressWarnings("serial")
	public class ClienteNaoAlteradoException extends IllegalArgumentException {
		public ClienteNaoAlteradoException(String msg) {
			super(msg);
		}
	}

	@SuppressWarnings("serial")
	public class ClienteNaoRemovidoException extends IllegalArgumentException {
		public ClienteNaoRemovidoException(String msg) {
			super(msg);
		}
	}

}
