package Dao;
import Dao.ConexaoBanco;
public class PgDaoFactory {
	private String url;
	private String user;
	private String password;
	ConexaoBanco c = new ConexaoBanco("PostgreSql","localhost","5432","biblioteca","postgres","12345");

	public void querry(String conteudo){
		try {
		c.conect();
		c.query(conteudo);
		c.disconect();
		} catch (Exception e) {
		}
	}
}
