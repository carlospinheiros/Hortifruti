package hortifruti;

public class Pessoa {
	private String nome;
	private String telefone;
	private String endereco;
	private String cep;

	public String getNome() {
		return nome;
	}
	
	// verifica o tamanho m�ximo de caracteres do campo nome, se exceder informa erro
	public void setNome(String nome) {
		if (nome.length() > 40) {
			throw new IllegalArgumentException("CAMPO NOME EXCEDEU O TAMANHO M�XIMO! (40 CARACTERES)");
		}
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}
	
	// verifica o tamanho m�ximo de caracteres do campo telefone, se exceder informa erro
	public void setTelefone(String telefone) {
		if (telefone.length() > 18) {
			throw new IllegalArgumentException("CAMPO TELEFONE EXCEDEU O TAMANHO M�XIMO! (XX)XXXXX-XXXX");
		}
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}
	
	// verifica o tamanho m�ximo de caracteres do campo endere�o, se exceder informa erro
	public void setEndereco(String endereco) {
		if (endereco.length() > 60) {
			throw new IllegalArgumentException("CAMPO ENDERE�O EXCEDEU O TAMANHO M�XIMO! (60 CARACTERES)");
		}
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}
	
	// verifica o tamanho m�ximo de caracteres do campo cep, se exceder informa erro
	public void setCep(String cep) {
		if (cep.length() > 9) {
			throw new IllegalArgumentException("CAMPO CEP EXCEDEU O TAMANHO M�XIMO! XXXXX-XXX");
		}
		this.cep = cep;
	}

}
