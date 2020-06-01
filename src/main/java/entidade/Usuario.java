package entidade;

public class Usuario {
	private String email;
	private String senha;
	
	private Pessoa pessoa;

	public Usuario() {
		// ao criar um usuário é preciso instanciar a Pessoa
		// para poder acessar o atributo CPF
		this.pessoa = new Pessoa(); 
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
	
	
	

}
