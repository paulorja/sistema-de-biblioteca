package Dao;

public class DaoFactory {
	private static int selectedDao = 1;

	public DaoFactory getDaoFactory() {
		return null;
	}

	public static ExemplarDao getExemplarDao() {
		if(selectedDao == 1) {
			return new ArquivoExemplarDao();
		}
		return new PgExemplarDao();

	}

	public static PessoaDao getPessoaDao() {
		if(selectedDao == 1) {
			return new ArquivoPessoaDao();
		}
		return new PgPessoaDao();
	}

	public static LivroDao getLivroDao() {
		if(selectedDao == 1) {
			return new ArquivoLivroDao();
		}
		return new PgLivroDao();
	}
}
