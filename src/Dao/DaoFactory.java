package Dao;

public class DaoFactory {
	public static int SELECT_DAO = 1;
	public DaoFactory getDaoFactory() {
		return null;
	}

	public static ExemplarDao getExemplarDao() {
		if(SELECT_DAO == 1) {
			return new ArquivoExemplarDao();
		}
		return new PgExemplarDao();

	}

	public static PessoaDao getPessoaDao() {
		if(SELECT_DAO == 1) {
			return new ArquivoPessoaDao();
		}
		return new PgPessoaDao();
	}

	public static LivroDao getLivroDao() {
		if(SELECT_DAO == 1) {
			return new ArquivoLivroDao();
		}
		return new PgLivroDao();
	}
}
