package Dao;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import Models.Pessoa;

public class PgPessoaDao extends PgDaoFactory implements PessoaDao {

	@Override
	public Pessoa inserir(Pessoa pessoa) {
		try {
			String sql=("INSERT INTO Pessoa VALUES("
			+ pessoa.getMatricula() + ",'" + pessoa.getTipo()
			+ "','" + pessoa.getNome()+"')");
			executeUpdate(sql);
		} catch (Exception e) {
            System.out.println(e);
        }
		return pessoa;
	}

	@Override
	public Pessoa consultaPorCodMatricula(int codMatricula) {
	    try {
	        String sql=("SELECT * FROM Pessoa WHERE matricula='" + codMatricula+"'");
	        ResultSet rs = executeQuery(sql);
	        ResultSetMetaData rsmd = rs.getMetaData();
	        int columNumber = rsmd.getColumnCount();
	        String[] pessoaPropriedades= new String[columNumber];
	        while (rs.next()) {
	            for (int i=0 ; i<columNumber ; i++ ){
	                pessoaPropriedades[i]=rs.getString(i+1);
	            }
	        }
	        Pessoa p = new Pessoa(Integer.parseInt(pessoaPropriedades[0]),pessoaPropriedades[1].charAt(0),pessoaPropriedades[2].trim());
	        return p;
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    return null;
	}

	@Override
	public void alterarPorCodMatricula(Pessoa pessoa) {
		try {
			String sql=("Update Pessoa set name='"
			+ pessoa.getNome() + "',tipo='"+pessoa.getTipo()+"' where matricula="+pessoa.getMatricula());
			executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e);
		}
	}


	@Override
	public void removerPorCodMatricula(int codMatricula) {
		try {
			String sql=("delete from Pessoa where matricula="+codMatricula);
			executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public ArrayList<Pessoa> listaPessoas() {
		// TODO Auto-generated method stub
		return null;
	}

}
