package Dao;

import Models.Exemplar;
import Models.Pessoa;

public class ArquivoExemplarDao extends ArquivoDaoFactory implements ExemplarDao {

	public ArquivoExemplarDao() {
		nomeArquivo = "data_exemplares.txt";
	}
	
	public Exemplar consultaPorCod(int cod) {
		lerLinhasArquivo();
		
		int posicaoExemplar = getPosicaoPorCod(cod);
			
		if(posicaoExemplar != -1) {
			String[] splitPessoa = conteudoArquivo.get(posicaoExemplar).split(";");
			if(Integer.parseInt(splitPessoa[0]) == cod) {
				return new Exemplar(Integer.parseInt(splitPessoa[0]), Integer.parseInt(splitPessoa[1]), Integer.parseInt(splitPessoa[2]));
			}
		}
		return null;
	}

	public Exemplar inserir(Exemplar novoExemplar) {
		lerLinhasArquivo();	
		
		if(verificaExiste(novoExemplar.getCodigo()) == false) {
			String novaLinha = novoExemplar.getFileData();
			conteudoArquivo.add(novaLinha);
			salvarConteudoArquivo();
			return novoExemplar;
		}
		
		return null;
	}

	public void removerPorCod(int cod) {
		lerLinhasArquivo();
		
		int posicaoExemplar = getPosicaoPorCod(cod);
		
		if(posicaoExemplar != -1) {
			conteudoArquivo.remove(posicaoExemplar);
			salvarConteudoArquivo();
		}
	}
	

	public void alterarPorCod(Exemplar exemplar) {
		lerLinhasArquivo();
		
		int posicaoExemplar = getPosicaoPorCod(exemplar.getCodigo());
		
		if(posicaoExemplar != -1) {
			conteudoArquivo.set(posicaoExemplar, exemplar.getFileData());
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
		
		int posicaoExemplar= 0;
		
		if(conteudoArquivo.size() > 0) {
			for(String linha: conteudoArquivo) {
				String[] splitLinha = linha.split(";");
				if(Integer.parseInt(splitLinha[0]) == cod) {
					return posicaoExemplar;
				}
				posicaoExemplar++;
			}
		}
		return -1;
	}
	
}
