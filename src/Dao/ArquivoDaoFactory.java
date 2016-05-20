package Dao;

import java.io.*;
import java.util.ArrayList;

import Models.Pessoa;

public class ArquivoDaoFactory {
	protected ArrayList<String> conteudoArquivo;
	protected String nomeArquivo;

	protected ArrayList<String> lerLinhasArquivo() {
		InputStream leitorByte = null;
		InputStreamReader leitorCaracter = null;
		BufferedReader leitorPalavras = null;
		
		conteudoArquivo = new ArrayList<String>();
		
		try {
			leitorByte = new FileInputStream("arquivos/"+nomeArquivo);
			leitorCaracter = new InputStreamReader(leitorByte);
			leitorPalavras = new BufferedReader(leitorCaracter);
						
			String linha = leitorPalavras.readLine();
			while(linha != null) {
				conteudoArquivo.add(linha);
				linha = leitorPalavras.readLine();
			}
			
		} catch (FileNotFoundException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			try {
				if (leitorByte != null) {
					leitorByte.close();
				}
				if (leitorCaracter != null) {
					leitorCaracter.close();
				}
				if (leitorPalavras != null) {
					leitorPalavras.close();
				}
			} catch (Exception e) {}
		}
		
		return conteudoArquivo;		
	}
	
	protected void salvarConteudoArquivo() {
		OutputStream escritorByte = null;
		OutputStreamWriter escritorCaracter = null;
		BufferedWriter escritorPalavras = null;
				
		try {
			
			escritorByte = new FileOutputStream("arquivos/"+nomeArquivo);
			escritorCaracter = new OutputStreamWriter(escritorByte);
			escritorPalavras = new BufferedWriter(escritorCaracter);
						
			for(String linha: conteudoArquivo) {
				escritorPalavras.write(linha);
				escritorPalavras.newLine();
			}
			
			escritorPalavras.flush();
			
		} catch (FileNotFoundException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			try {
				if (escritorByte != null) {
					escritorByte.close();
				}
				if (escritorCaracter != null) {
					escritorCaracter.close();
				}
				if (escritorPalavras != null) {
					escritorPalavras.close();
				}
			} catch (Exception e) {}
		}
	}
}
