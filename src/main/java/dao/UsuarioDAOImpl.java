package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidade.Pessoa;
import entidade.Usuario;
import util.JdbcConexao;


/**
 * 
 * @author Cleiton
 *
 *         Essa classe implementa a interface, todos os metodos mostrados na
 *         interface. Lembrando de uma coisa, a implementa��o ela recebe no
 *         construtor o entityManager, a conex�o com o banco de dados, deixando
 *         assim essa classe totalemnte independente
 *
 */

public class UsuarioDAOImpl implements UsuarioDAO {

	/**
	 * Metodo inserir, recebe o usuario todo preenchido, cria uma transi��o, inicia
	 * e executar a a��o de persistir, tudo dando certo realiza o commit no final
	 */
	public void inserir(Usuario usuario) {

		String sql = "insert into USUARIO (cpf, email, senha) values (?, ?, ?)";

		Connection conexao;
		try {
			conexao = JdbcConexao.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, usuario.getPessoa().getCpf());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getSenha());

			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Metodo alterar, recebe o usuario, criar uma transi��o, inicia e executa a
	 * a��o de merger
	 */
	public void alterar(Usuario usuario) {

		String sql = "UPDATE USUARIO SET email = ?, senha = ? where cpf = ?";

		Connection conexao;
		try {
			conexao = JdbcConexao.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getSenha());
			ps.setString(3, usuario.getPessoa().getCpf());

			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void remover(Usuario usuario) {

		String sql = "DELETE FROM USUARIO WHERE cpf = ?";

		Connection conexao;
		try {
			conexao = JdbcConexao.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, usuario.getPessoa().getCpf());

			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Pesquisar, pesquisar pela chave primaria que seria o cpf
	 */
	public Usuario pesquisar(String cpf) {

		String sql = "select U.CPF, U.EMAIL, U.SENHA from USUARIO U where cpf = ?";
		
		Usuario usuario = null;
		
		Connection conexao;
		try {
			conexao = JdbcConexao.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, cpf);

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				
				Pessoa pessoa = new Pessoa();
				pessoa.setCpf(res.getString("CPF"));
				
				usuario = new Usuario();
				usuario.setPessoa(pessoa);
				usuario.setEmail(res.getString("EMAIL"));
				usuario.setSenha(res.getString("SENHA"));
			 }
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuario;
	}

	/**
	 * O metodo listar todos, faz um select * from, por�m com o JPA, vc faz a
	 * consulta pelo objeto direto assim from Usuario, que isso � o objeto usuario e
	 * n�o a tabela
	 */
	public List<Usuario> listarTodos() {

		String sql = "select U.CPF, U.EMAIL, U.SENHA from USUARIO U";
		
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		Connection conexao;
		try {
			conexao = JdbcConexao.getConexao();
			
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet res = ps.executeQuery();

			while (res.next()) {
				
				
				Pessoa pessoa = new Pessoa();
				pessoa.setCpf(res.getString("CPF"));
				
				Usuario usuario = new Usuario();
				usuario.setPessoa(pessoa);
				usuario.setEmail(res.getString("EMAIL"));
				usuario.setSenha(res.getString("SENHA"));
				
				listaUsuarios.add(usuario);
			 }
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaUsuarios;

	}

}
