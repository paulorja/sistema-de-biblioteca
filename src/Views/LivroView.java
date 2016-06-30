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
	private Livro livro;

	protected void mostrar_cadastro(Livro livro) {
		super.mostrar_cadastro();
		
		if(livro != null) {
			this.livro = livro;
			prepara_botao_excluir();
			
			janela.setTitle("Editar Livro");

			input_codigo.disable();
			
			input_titulo.setText(livro.getTitulo());
			input_autor.setText(livro.getAutor());
			input_codigo.setText(""+livro.getCodigo());
		} else {
			janela.setTitle("Cadastro de Livro");
		}
	}

	protected void prepara_painel() {
		super.prepara_painel();
		painel.setLayout(new GridLayout(5, 2));
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
		if(livro != null) {
			LivroController.alterarPorCod(livro);
			JOptionPane.showMessageDialog(null, "Livro editado!");
		} else {
			Livro novoLivro = new Livro(Integer.parseInt(input_codigo.getText()), input_titulo.getText(), input_autor.getText());

			if(LivroController.inserir(novoLivro) != null) {
				JOptionPane.showMessageDialog(null, "Livro Inserido");
			} else {
				JOptionPane.showMessageDialog(null, "Erro!");
			}
		}
		
		janela.dispose();
	}

	private static void remover(int cod) {
		if (JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir o livro com o codigo "+cod+"?") == 0) {
			LivroController.removerPorCod(cod);
		}
	}


	protected void prepara_botao_excluir() {
		botaoExcluir= new JButton("Excluir");
	    
	    botaoExcluir.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	LivroController.removerPorCod(Integer.parseInt(input_codigo.getText()));
				JOptionPane.showMessageDialog(null, "Livro Excluído!");
				janela.dispose();
	        }
	    });
	    
	    painel.add(botaoExcluir);
	}
}
