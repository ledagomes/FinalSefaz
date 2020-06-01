package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Cleiton
 *
 *	A classe JPAUtil tem a funcionalidade de disponibilizar as EntityManager(conex�es com o banco de dados)
 *Tamb�m � uma classe sington, s� vai existir uma instancia dessa classe no projeto todo 
 *
 */

public class JdbcConexao {
	//cria um metodo getConexao que icicia com a conexao zero
	//sem parametro que joga para o erro.

	public static Connection getConexao() throws SQLException {

		Connection conexao = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			conexao = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "FUNC", "FUNC");
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conexao;
	}
	
	//Para abrir uma conexão com um banco de dados, 
	//precisamos utilizar sempre um driver. 
	//A classe DriverManager é a responsável por se comunicar 
	//com todos os drivers que você deixou disponível. 
	//Para isso, invocamos o método estático getConnection 
	//com uma String que indica a qual banco desejamos nos conectar.
	
	
//	private static EntityManagerFactory factory;
//
//    static {
//        factory = Persistence.createEntityManagerFactory("Sefaz");
//    }
//
//    public static EntityManager getEntityManager() {
//        return factory.createEntityManager();
//    }
//
//    public static void close() {
//        factory.close();
//    }
}
