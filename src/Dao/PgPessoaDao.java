package Dao;

import java.util.ArrayList;

import Models.Pessoa;

public class PgPessoaDao extends PgDaoFactory implements PessoaDao {

	@Override
	public Pessoa inserir(Pessoa pessoa) {
		querry("insert into Pessoa values("+pessoa.getMatricula()+",'"+pessoa.getTipo()+"','"+pessoa.getNome()+"')");
		System.out.println("insert into Pessoa values("+pessoa.getMatricula()+",'"+pessoa.getTipo()+"','"+pessoa.getNome()+"')");
		return pessoa;
	}

	@Override
	public Pessoa consultaPorCodMatricula(int codMatricula) {
		return null;
	}

	@Override
	public void alterarPorCodMatricula(Pessoa aluno) {
		// TODO Auto-generated method stub

	}


	@Override
	public void removerPorCodMatricula(int codMatricula) {
		// TODO Auto-generated method stub

	}

}
