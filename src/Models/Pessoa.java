package Models;

import javax.swing.JOptionPane;

import Dao.ArquivoPessoaDao;

public class Pessoa {
	private int matricula;
	private char tipo;
	private String nome;
	
	public Pessoa(int matricula, char tipo, String nome) {
		setMatricula(matricula);
		setTipo(tipo);
		setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getFileData() {
		return this.matricula+";"+this.tipo+";"+this.nome;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public String getNomeTipo() {
		if(this.tipo == 'a') {
			return "Aluno";
		}
		if(this.tipo == 'p') {
			return "Professor";
		}
		return "tipo incorreto";
	}
	
}
