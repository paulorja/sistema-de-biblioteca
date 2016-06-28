package Dao;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import Models.Exemplar;

public class PgExemplarDao extends PgDaoFactory implements ExemplarDao {

	@Override
	public Exemplar inserir(Exemplar exemplar) {
		try {
			String sql=("INSERT INTO Exemplar VALUES("
			+ exemplar.getCodigo() + ",'" + exemplar.codLivro()
			+ "','" + exemplar.codMatricula()+"')");
			executeUpdate(sql);
		} catch (Exception e) {
            System.out.println(e);
        }
		return exemplar;
	}

	@Override
	public Exemplar consultaPorCod(int cod) {
	    try {
	        String sql=("SELECT * FROM Exemplar WHERE codigo='" + cod+"'");
	        ResultSet rs = executeQuery(sql);
	        ResultSetMetaData rsmd = rs.getMetaData();
	        int columNumber = rsmd.getColumnCount();
	        String[] exemplarPropriedades= new String[columNumber];
	        while (rs.next()) {
	            for (int i=0 ; i<columNumber ; i++ ){
	                exemplarPropriedades[i]=rs.getString(i+1);
	            }
	        }
	        Exemplar p = new Exemplar(Integer.parseInt(exemplarPropriedades[0]),Integer.parseInt(exemplarPropriedades[1]),Integer.parseInt(exemplarPropriedades[2]));
	        return p;
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    return null;
	}

	@Override
	public void alterarPorCod(Exemplar exemplar) {
		try {
			String sql=("Update Exemplar set codMatricula='"
			+ exemplar.getNome() + "',tipo='"+exemplar.getTipo()+"' where codigo="+exemplar.getCodigo());
			executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e);
		}
	}


	@Override
	public void removerPorCod(int cod) {
		try {
			String sql=("delete from Exemplar where codigo="+cod);
			executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
