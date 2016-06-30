package Dao;

import java.util.ArrayList;

import Models.Pessoa;

public class ArquivoPessoaDao extends ArquivoDaoFactory implements PessoaDao {
	
	public ArquivoPessoaDao() {
		nomeArquivo = "data_pessoas.txt";
	}

	public Pessoa inserir(Pessoa pessoa) {	
		lerLinhasArquivo();	
		
		if(verificaExiste(pessoa.getMatricula()) == false) {
			String novaLinha = pessoa.getFileData();
			conteudoArquivo.add(novaLinha);
			salvarConteudoArquivo();
			return pessoa;
		}		
		return null;
	}
	
	public Pessoa consultaPorCodMatricula(int codMatricula) {
		lerLinhasArquivo();
		
		int posicaoPessoa = getPosicaoPorCodMatricula(codMatricula);
			
		if(posicaoPessoa != -1) {
			String[] splitPessoa = conteudoArquivo.get(posicaoPessoa).split(";");
			if(Integer.parseInt(splitPessoa[0]) == codMatricula) {
				return new Pessoa(Integer.parseInt(splitPessoa[0]), splitPessoa[1].charAt(0), splitPessoa[2]);
			}
		}
		return null;
	}

	public void alterarPorCodMatricula(Pessoa pessoa) {
		lerLinhasArquivo();
		
		int posicaoPessoa = getPosicaoPorCodMatricula(pessoa.getMatricula());
		
		if(posicaoPessoa != -1) {
			conteudoArquivo.set(posicaoPessoa, pessoa.getFileData());
			salvarConteudoArquivo();
		}
	}

	public void removerPorCodMatricula(int codMatricula) {
		lerLinhasArquivo();
		
		int posicaoPessoa = getPosicaoPorCodMatricula(codMatricula);
		
		if(posicaoPessoa != -1) {
			conteudoArquivo.remove(posicaoPessoa);
			salvarConteudoArquivo();
		}
	}
	
	public Boolean verificaExiste(int codMatricula) {
		lerLinhasArquivo();
		
		int posicaoPessoa = getPosicaoPorCodMatricula(codMatricula);
		
		if(posicaoPessoa != -1) {
			return true;
		}
		return false;
	}
	
	private int getPosicaoPorCodMatricula(int codMatricula) {
		lerLinhasArquivo();
		
		int posicaoPessoa= 0;
		
		if(conteudoArquivo.size() > 0) {
			for(String linha: conteudoArquivo) {
				String[] splitLinha = linha.split(";");
				if(Integer.parseInt(splitLinha[0]) == codMatricula) {
					return posicaoPessoa;
				}
				posicaoPessoa++;
			}
		}
		return -1;
	}

	@Override
	public ArrayList<Pessoa> listaPessoas() {
		lerLinhasArquivo();

		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		for(String linha: conteudoArquivo) {
			String[] splitPessoa = linha.split(";");
			pessoas.add(new Pessoa(Integer.parseInt(splitPessoa[0]), splitPessoa[1].charAt(0), splitPessoa[2]));
		}
		
		return pessoas;
	}
}
