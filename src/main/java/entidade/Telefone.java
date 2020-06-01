package entidade;

public class Telefone {
	private int id_telefone;
	private String ddd;
	private String fone;
	private Boolean foneDeEmergencia;
	
	private Pessoa pessoa;

	public Telefone() {
	}

	public int getId_telefone() {
		return id_telefone;
	}

	public void setId_telefone(int id_telefone) {
		this.id_telefone = id_telefone;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public Boolean getFoneDeEmergencia() {
		return foneDeEmergencia;
	}

	public void setFoneDeEmergencia(Boolean foneDeEmergencia) {
		this.foneDeEmergencia = foneDeEmergencia;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
	
	
	
	

}
