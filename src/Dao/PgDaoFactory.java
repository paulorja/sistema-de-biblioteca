package Dao;
import java.sql.ResultSet;
public abstract class PgDaoFactory {

	private ConexaoBanco conexao = new ConexaoBanco("localhost","5432","biblioteca","postgres","12345");

    public void startConexao(){
        conexao.conect();
    }

    public void closeConexao(){
        conexao.disconect();
    }

    protected ResultSet executeQuery(String sql){
        startConexao();
        ResultSet rs = conexao.query(sql);
        closeConexao();
        return rs;
    }

    protected int executeUpdate(String sql){
        startConexao();
        int rs = conexao.queryUpdate(sql);
        closeConexao();
        return rs;
    }

    public void setConexao(ConexaoBanco conexao) {
        this.conexao = conexao;
    }
}
