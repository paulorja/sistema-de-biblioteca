package Controllers;

import java.util.ArrayList;

import Dao.PessoaDao;
import Dao.DaoFactory;
import Dao.LivroDao;
import Models.Pessoa;
import Models.Livro;

public class LivroController {

	public static Livro inserir(Livro novoLivro) {
		LivroDao dao = DaoFactory.getLivroDao();
		return dao.inserir(novoLivro);
	}

	public static Livro consultaPorCod(int cod) {
		LivroDao dao = DaoFactory.getLivroDao();
		Livro livroPesquisado = dao.consultaPorCod(cod);
		return livroPesquisado;
	}


	public static void removerPorCod(int cod) {
		LivroDao dao = DaoFactory.getLivroDao();
		dao.removerPorCod(cod);
	}
	
	public static void alterarPorCod(Livro livro) {
		LivroDao dao = DaoFactory.getLivroDao();
		dao.alterarPorCod(livro);
	}
	
	public static ArrayList<Livro> listarLivros() {
		LivroDao dao = DaoFactory.getLivroDao();
		return dao.listaLivros();	
	}
}
