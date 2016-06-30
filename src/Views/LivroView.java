package Views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controllers.PessoaController;
import Controllers.LivroController;
import Dao.PessoaDao;
import Dao.DaoFactory;
import Dao.LivroDao;
import Models.Pessoa;
import Models.Livro;

public class LivroView extends CrudView {

	private JTextField input_codigo;
	private JTextField input_titulo;
	private JTextField input_autor;

	protected void mostrar_cadastro() {
		super.mostrar_cadastro();

		janela.setTitle("Cadastro de Livro");
	}

	protected void prepara_painel() {
		super.prepara_painel();
		painel.setLayout(new GridLayout(4, 2));
	}

	protected void prepara_form() {

		painel.add(new JLabel("Código"));
		input_codigo = new JTextField();
		painel.add(input_codigo);

		painel.add(new JLabel("Titulo"));
		input_titulo = new JTextField();
		painel.add(input_titulo);

		painel.add(new JLabel("Autor"));
		input_autor = new JTextField();
		painel.add(input_autor);

	}

	protected void acao_salvar() {
		Livro novoLivro = new Livro(Integer.parseInt(input_codigo.getText()), input_titulo.getText(), input_autor.getText());

		if(LivroController.inserir(novoLivro) != null) {
			JOptionPane.showMessageDialog(null, "Livro Inserido");
			janela.dispose();
		} else {
			JOptionPane.showMessageDialog(null, "Erro!");
		}

    	System.out.println("salvar!");
	}




	// == OLD ==

	public static void inserir() {
		int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do livro: "));
		String titulo = JOptionPane.showInputDialog("Digite o título do livro: ");
		String autor = JOptionPane.showInputDialog("Digite o autor do livro: ");

		Livro novoLivro = new Livro(codigo, titulo, autor);
		if(LivroController.inserir(novoLivro) != null) {
			JOptionPane.showMessageDialog(null, "Livro inserido!");
		} else {
			JOptionPane.showMessageDialog(null, "Código já utilizado!!");
		}
	}

	public static void consultarPorCod() {
		int cod = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do livro: "));

		Livro livroPesquisado = LivroController.consultaPorCod(cod);

		if(livroPesquisado != null) {
			menuLivro(livroPesquisado);
		} else {
			JOptionPane.showMessageDialog(null, "Não encotrado");
		}

	}


	private static void menuLivro(Livro livroPesquisado) {
		int opcao = Integer.parseInt(JOptionPane.showInputDialog("Livro encontrado: \n\n"
				+ "Código: "+livroPesquisado.getCodigo()+"\n"
				+ "Autor: "+livroPesquisado.getAutor()+"\n"
				+ "Título: "+livroPesquisado.getTitulo()+"\n"
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
		if (JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir o livro com o codigo "+cod+"?") == 0) {
			LivroController.removerPorCod(cod);
		}
	}

	private static void alterar(int cod) {
		String titulo = JOptionPane.showInputDialog("Digite o título do livro: ");
		String autor = JOptionPane.showInputDialog("Digite o autor do livro: ");

		Livro livro = new Livro(cod, titulo, autor);

		LivroController.alterarPorCod(livro);
	}

	@Override
	protected void prepara_botao_excluir() {
		// TODO Auto-generated method stub
		
	}
}
