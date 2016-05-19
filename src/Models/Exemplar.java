package Models;

import java.util.ArrayList;

public class Exemplar {
	private int codigo;
	private int codLivro;
	private int codMatricula;

	public Exemplar(int codExemplar, int codLivro) {
		setCodigo(codExemplar);
		setCodLivro(codLivro);
		setCodMatricula(0);
	}

	public Exemplar(int codExemplar, int codLivro, int codMatricula) {
		setCodigo(codExemplar);
		setCodLivro(codLivro);
		setCodMatricula(codMatricula);
	}

	public int getCodMatricula() {
		return codMatricula;
	}

	public void setCodMatricula(int codPesssoa) {
		this.codMatricula = codPesssoa;
	}

	public int getCodLivro() {
		return codLivro;
	}

	public void setCodLivro(int codLivro) {
		this.codLivro = codLivro;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getFileData() {
		return this.codigo+";"+this.codLivro+";"+this.codMatricula;
	}

}
