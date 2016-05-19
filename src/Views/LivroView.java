package Views;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controllers.PessoaController;
import Controllers.LivroController;
import Dao.PessoaDao;
import Dao.DaoFactory;
import Dao.LivroDao;
import Models.Pessoa;
import Models.Livro;

public class LivroView {
	
	public static void inserir() {
		int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o c�digo do livro: "));
		String titulo = JOptionPane.showInputDialog("Digite o t�tulo do livro: ");
		String autor = JOptionPane.showInputDialog("Digite o autor do livro: ");
		
		Livro novoLivro = new Livro(codigo, titulo, autor);
		if(LivroController.inserir(novoLivro) != null) {
			JOptionPane.showMessageDialog(null, "Livro inserido!");
		} else {
			JOptionPane.showMessageDialog(null, "C�digo j� utilizado!!");
		}
	}
	
	public static void consultarPorCod() {
		int cod = Integer.parseInt(JOptionPane.showInputDialog("Digite o c�digo do livro: "));
		
		Livro livroPesquisado = LivroController.consultaPorCod(cod);
		
		if(livroPesquisado != null) {
			menuLivro(livroPesquisado);
		} else {
			JOptionPane.showMessageDialog(null, "N�o encotrado");
		}
		
	}


	private static void menuLivro(Livro livroPesquisado) {
		int opcao = Integer.parseInt(JOptionPane.showInputDialog("Livro encontrado: \n\n"
				+ "C�digo: "+livroPesquisado.getCodigo()+"\n"
				+ "Autor: "+livroPesquisado.getAutor()+"\n"
				+ "T�tulo: "+livroPesquisado.getTitulo()+"\n"
				+ "-----------------------------------\n"
				+ "1 - Alterar \n"
				+ "2 - Excluir \n"
				+ "3 - Voltar \n"));
		
		switch (opcao) {
		case 1:
			LivroView.alterar(livroPesquisado.getCodigo());
			break;
		case 2:
			LivroView.remover(livroPesquisado.getCodigo());
			break;
		case 3:
			break;
		default:
			break;
		}
	}

	private static void remover(int cod) {
		if (JOptionPane.showConfirmDialog(null, "Voc� tem certeza que deseja excluir o livro com o codigo "+cod+"?") == 0) {
			LivroController.removerPorCod(cod);
		}
	}

	private static void alterar(int cod) {
		String titulo = JOptionPane.showInputDialog("Digite o t�tulo do livro: ");
		String autor = JOptionPane.showInputDialog("Digite o autor do livro: ");
		
		Livro livro = new Livro(cod, titulo, autor);
		
		LivroController.alterarPorCod(livro);
	};
}
