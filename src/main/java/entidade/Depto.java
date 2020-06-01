package entidade;

import java.util.List;

public class Depto {

	private int id;
	private String nome;
	
	private List<Pessoa> funcionarios;

	public Depto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		System.out.println("Id Depto: " + this.id);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Pessoa> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Pessoa> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	
	
	
}
