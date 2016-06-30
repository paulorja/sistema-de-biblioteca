package Controllers;

import java.util.ArrayList;

import Dao.PessoaDao;
import Dao.DaoFactory;
import Models.Pessoa;

public class PessoaController {

	public static Pessoa inserir(Pessoa novoAluno) {
		PessoaDao dao = DaoFactory.getPessoaDao();
		return dao.inserir(novoAluno);
	}	

	public static Pessoa consultaPorCodMatricula(int codMatricula) {
		PessoaDao dao = DaoFactory.getPessoaDao();
		Pessoa pessoaPesquisada = dao.consultaPorCodMatricula(codMatricula);
		return pessoaPesquisada;
	}

	public static void removerPorCodMatricula(int codMatricula) {	
		PessoaDao dao = DaoFactory.getPessoaDao();
		dao.removerPorCodMatricula(codMatricula);	
	}

	public static void alterarPorCodMatricula(Pessoa aluno) {
		PessoaDao dao = DaoFactory.getPessoaDao();
		dao.alterarPorCodMatricula(aluno);	
	}
	
	public static ArrayList<Pessoa> listaPessoas() {
		PessoaDao dao = DaoFactory.getPessoaDao();
		return dao.listaPessoas();	
	}
}
