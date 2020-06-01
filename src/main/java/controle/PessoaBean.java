package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.PessoaDAO;
import dao.PessoaDAOImpl;
import entidade.Pessoa;

@ManagedBean(name = "PessoaBean")
@SessionScoped   
public class PessoaBean {

	private Pessoa pessoa;
	private String pesquisaNome;
	private String pesquisaDepto;
	private String pesquisaCpf;
	
	private PessoaDAO pessoaDAO;
	
	public PessoaBean() {
		this.pessoaDAO = new PessoaDAOImpl();
		this.pessoa = new Pessoa();
	}
	

	public List<Pessoa> pesquisaPorCpf(){
		return this.pessoaDAO.pesquisarPorCpf(this.pesquisaCpf);
	}
	
	public List<Pessoa> pesquisarPorNome(){
		return this.pessoaDAO.pesquisarPorNome(this.pesquisaNome);
		
	}
	public List<Pessoa> pesquisarPorDepto(){
		return this.pessoaDAO.pesquisarPorDepto(this.pesquisaDepto);
	}
	
	public void inserir() {
		this.pessoaDAO.inserir(this.pessoa);
	}
	public Pessoa getPessoa() {
		return this.pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public String getPesquisaNome() {
		return pesquisaNome;
	}


	public void setPesquisaNome(String pesquisaNome) {
		this.pesquisaNome = pesquisaNome;
	}


	public String getPesquisaDepto() {
		return pesquisaDepto;
	}


	public void setPesquisaDepto(String pesquisaDepto) {
		this.pesquisaDepto = pesquisaDepto;
	}


	public String getPesquisaCpf() {
		return pesquisaCpf;
	}


	public void setPesquisaCpf(String pesquisaCpf) {
		this.pesquisaCpf = pesquisaCpf;
	}
}
