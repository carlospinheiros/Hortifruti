package hortifruti;

public class Pessoa {
	private String nome;
	private String telefone;
	private String endereco;
	private String cep;

	public String getNome() {
		return nome;
	}
	
	// verifica o tamanho máximo de caracteres do campo nome, se exceder informa erro
	public void setNome(String nome) {
		if (nome.length() > 40) {
			throw new IllegalArgumentException("CAMPO NOME EXCEDEU O TAMANHO MÁXIMO! (40 CARACTERES)");
		}
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}
	
	// verifica o tamanho máximo de caracteres do campo telefone, se exceder informa erro
	public void setTelefone(String telefone) {
		if (telefone.length() > 18) {
			throw new IllegalArgumentException("CAMPO TELEFONE EXCEDEU O TAMANHO MÁXIMO! (XX)XXXXX-XXXX");
		}
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}
	
	// verifica o tamanho máximo de caracteres do campo endereço, se exceder informa erro
	public void setEndereco(String endereco) {
		if (endereco.length() > 60) {
			throw new IllegalArgumentException("CAMPO ENDEREÇO EXCEDEU O TAMANHO MÁXIMO! (60 CARACTERES)");
		}
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}
	
	// verifica o tamanho máximo de caracteres do campo cep, se exceder informa erro
	public void setCep(String cep) {
		if (cep.length() > 9) {
			throw new IllegalArgumentException("CAMPO CEP EXCEDEU O TAMANHO MÁXIMO! XXXXX-XXX");
		}
		this.cep = cep;
	}

}
