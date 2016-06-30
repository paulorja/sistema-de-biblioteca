package Dao;

import java.util.ArrayList;

import Models.Livro;
import Models.Pessoa;

public class ArquivoLivroDao extends ArquivoDaoFactory implements LivroDao {

	public ArquivoLivroDao() {
		nomeArquivo = "data_livros.txt";
	}
	
	public Livro inserir(Livro novoLivro) {
		lerLinhasArquivo();	
		
		if(verificaExiste(novoLivro.getCodigo()) == false) {
			String novaLinha = novoLivro.getFileData();
			conteudoArquivo.add(novaLinha);
			salvarConteudoArquivo();
			return novoLivro;
		}
		
		return null;
	}

	public Livro consultaPorCod(int cod) {
		lerLinhasArquivo();
		
		int posicaoLivro = getPosicaoPorCod(cod);
			
		if(posicaoLivro != -1) {
			String[] splitLivro = conteudoArquivo.get(posicaoLivro).split(";");
			if(Integer.parseInt(splitLivro[0]) == cod) {
				return new Livro(Integer.parseInt(splitLivro[0]), splitLivro[1], splitLivro[2]);
			}
		}
		return null;
	}

	public void alterarPorCod(Livro livro) {
		lerLinhasArquivo();
		
		int posicaoLivro = getPosicaoPorCod(livro.getCodigo());
		
		if(posicaoLivro != -1) {
			conteudoArquivo.set(posicaoLivro, livro.getFileData());
			salvarConteudoArquivo();
		}
	}

	public void removerPorCod(int cod) {
		lerLinhasArquivo();
		
		int posicaoLivro = getPosicaoPorCod(cod);
		
		if(posicaoLivro != -1) {
			conteudoArquivo.remove(posicaoLivro);
			salvarConteudoArquivo();
		}
	}
	
	public Boolean verificaExiste(int cod) {
		lerLinhasArquivo();
		
		int posicaoPessoa = getPosicaoPorCod(cod);
		
		if(posicaoPessoa != -1) {
			return true;
		}
		return false;
	}
	
	private int getPosicaoPorCod(int cod) {
		lerLinhasArquivo();
		
		int posicaoLivro= 0;
		
		if(conteudoArquivo.size() > 0) {
			for(String linha: conteudoArquivo) {
				String[] splitLinha = linha.split(";");
				if(Integer.parseInt(splitLinha[0]) == cod) {
					return posicaoLivro;
				}
				posicaoLivro++;
			}
		}
		return -1;
	}

	public ArrayList<Livro> listaLivros() {
		lerLinhasArquivo();

		ArrayList<Livro> livros = new ArrayList<Livro>();
		
		for(String linha: conteudoArquivo) {
			String[] splitLivro = linha.split(";");
			livros.add(new Livro(Integer.parseInt(splitLivro[0]), splitLivro[1], splitLivro[2]));
		}
		
		return livros;
	}

}
