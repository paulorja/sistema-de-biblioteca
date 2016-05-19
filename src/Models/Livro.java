package Models;

public class Livro {
	
	private int codigo;
	private String titulo;
	private String autor;
	
	public Livro(int codigo, String titulo, String autor) {
		setCodigo(codigo);
		setTitulo(titulo);
		setAutor(autor);
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getFileData() {
		return this.codigo+";"+this.titulo+";"+this.autor;
	}
}
