package Controllers;

import java.util.ArrayList;

import Dao.PessoaDao;
import Dao.DaoFactory;
import Dao.ExemplarDao;
import Dao.LivroDao;
import Models.Pessoa;
import Models.Exemplar;
import Models.Livro;

public class ExemplarController {

	public static Exemplar inserir(Exemplar novoExemplar) {
		ExemplarDao dao = DaoFactory.getExemplarDao();
		return dao.inserir(novoExemplar);
	}

	public static Exemplar consultaPorCod(int cod) {
		ExemplarDao dao = DaoFactory.getExemplarDao();
		Exemplar exemplarPesquisado = dao.consultaPorCod(cod);
		return exemplarPesquisado;
	}

	public static void removerPorCod(int cod) {
		ExemplarDao dao = DaoFactory.getExemplarDao();
		dao.removerPorCod(cod);
	}
	
	public static void alterarPorCod(Exemplar exemplar) {
		ExemplarDao dao = DaoFactory.getExemplarDao();
		dao.alterarPorCod(exemplar);
	}

	public static void alugar(Exemplar exemplar) {
		ExemplarDao dao = DaoFactory.getExemplarDao();
		dao.alterarPorCod(exemplar);
	}

	public static void devolver(Exemplar exemplar) {
		ExemplarDao dao = DaoFactory.getExemplarDao();
		dao.alterarPorCod(exemplar);
	}

	public static Livro getLivro(int codLivro) {
		LivroDao dao = DaoFactory.getLivroDao();
		return dao.consultaPorCod(codLivro);
	}

	public static Pessoa getPessoa(int codMatricula) {
		PessoaDao dao = DaoFactory.getPessoaDao();
		return dao.consultaPorCodMatricula(codMatricula);
	}
}
