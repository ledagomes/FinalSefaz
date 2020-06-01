package dao;

import java.util.List;

import entidade.Pessoa;

public interface PessoaDAO {
	
	public void inserir(Pessoa Pessoa);
	
	public List<Pessoa> pesquisarPorNome(String nome);
	public List<Pessoa> pesquisarPorDepto(String depto);
	public List<Pessoa> pesquisarPorCpf(String cpf);

}

