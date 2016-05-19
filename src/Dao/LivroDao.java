package Dao;

import Models.Livro;

public interface LivroDao {
	
	Livro inserir(Livro novoAluno);
	Livro consultaPorCod(int cod);
	void alterarPorCod(Livro livro);
	void removerPorCod(int cod);

}
