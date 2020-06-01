package dao;

import java.util.List;
import entidade.Usuario;

/**
 * 
 * @author Cleiton
 *
 *  UsuarioDAO � uma interface, onde compartilha a chamada dos metodos, mas n�o os implementam.
 */

public interface UsuarioDAO {
	
	public void inserir(Usuario usuario);
	
	public void alterar(Usuario usuario);

	public void remover(Usuario usuario);

	public Usuario pesquisar(String cpf);

	public List<Usuario> listarTodos();

}
