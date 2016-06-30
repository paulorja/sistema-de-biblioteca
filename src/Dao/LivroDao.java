package Dao;

import java.util.ArrayList;

import Models.Livro;
import Models.Pessoa;

public interface LivroDao {
	
	Livro inserir(Livro novoAluno);
	Livro consultaPorCod(int cod);
	void alterarPorCod(Livro livro);
	void removerPorCod(int cod);
	public ArrayList<Livro> listaLivros();

}
