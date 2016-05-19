package Dao;

import Models.Exemplar;

public interface ExemplarDao {

	Exemplar consultaPorCod(int cod);
	Exemplar inserir(Exemplar novoExemplar);
	void removerPorCod(int cod);
	void alterarPorCod(Exemplar exemplar);
	
}
