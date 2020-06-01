package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import entidade.Pessoa;
import util.JdbcConexao;

public class PessoaDAOImpl implements PessoaDAO {

	public void inserir(Pessoa pessoa) {
		
		String sql = "INSERT INTO pessoa(nome, id_depto, cpf, mae, pis, admissao ) " + 
				"  values(?, ?, ?, ?, ?, ?)";

		Connection conexao;
		try {
			conexao = JdbcConexao.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, pessoa.getNome());
			ps.setInt(2, pessoa.getDepto().getId());
			ps.setString(3, pessoa.getCpf());
			ps.setString(4, pessoa.getMae());
			ps.setString(5, pessoa.getPis());
			ps.setDate(6, new java.sql.Date(pessoa.getAdmissao().getTime()));
			//conversao de java util date para java sql date
			ps.execute();
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public void alterar(Pessoa pessoa) {
		

			String sql = "UPDATE PESSOA SET nome = ?, id_depto = ?, mae = ?, pis = ?, admissao = ?where cpf = ?";
			

			Connection conexao;
			try {
				conexao = JdbcConexao.getConexao();
				
				PreparedStatement ps = conexao.prepareStatement(sql);
				
				ps.setString(1, pessoa.getNome());
				ps.setInt(2, pessoa.getDepto().getId());
				ps.setString(3, pessoa.getCpf());
				ps.setString(4, pessoa.getMae());
				ps.setString(5, pessoa.getPis());
				ps.setDate(6, new java.sql.Date(pessoa.getAdmissao().getTime()));
				//conversao de java util date para java sql date
				
				ps.execute();
				ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		

	public void remover(Pessoa pessoa) {
		

			String sql = "DELETE FROM PESSOA WHERE cpf = ?";

			Connection conexao;
			try {
				conexao = JdbcConexao.getConexao();
				
				PreparedStatement ps = conexao.prepareStatement(sql);
				
				ps.setString(1, pessoa.getCpf());

				ps.execute();
				ps.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	


	public List<Pessoa> pesquisarPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Pessoa> pesquisarPorDepto(String depto) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Pessoa> pesquisarPorCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}
}

	