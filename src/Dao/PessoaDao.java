package Dao;

import java.util.ArrayList;

import Models.Pessoa;

public interface PessoaDao {
	public Pessoa inserir(Pessoa novaPessoa);
	public Pessoa consultaPorCodMatricula(int codMatricula);
	public void alterarPorCodMatricula(Pessoa pessoa);
	public void removerPorCodMatricula(int codMatricula);
	public ArrayList<Pessoa> listaPessoas();
}
