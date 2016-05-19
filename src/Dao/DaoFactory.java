package Dao;

public class DaoFactory {
	private static int selectedDao = 1;
	
	public DaoFactory getDaoFactory() {
		return null;
	}

	public static ExemplarDao getExemplarDao() {
		if(selectedDao == 1) {
			return new ArquivoExemplarDao();
		} else {
			//return new PgExemplarDao();
		}
		return null;
	}
	
	public static PessoaDao getPessoaDao() {
		if(selectedDao == 1) {
			return new ArquivoPessoaDao();
		} else {
			return new PgPessoaDao();
		}
	}
	
	public static LivroDao getLivroDao() {
		if(selectedDao == 1) {
			return new ArquivoLivroDao();
		} else {
			//return new PgLivroDao();
		}
		return null;
	}	
}
