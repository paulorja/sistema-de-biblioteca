package Views;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controllers.PessoaController;
import Controllers.ExemplarController;
import Controllers.LivroController;
import Dao.PessoaDao;
import Dao.DaoFactory;
import Dao.LivroDao;
import Models.Pessoa;
import Models.Exemplar;
import Models.Livro;

public class ExemplarView extends CrudView {

	private Exemplar exemplar;
	private JTextField input_codigo;
	private JComboBox<String> combo_box_pessoa;
	private JComboBox<String> combo_box_livro;

	protected void mostrar_cadastro(Exemplar exemplar) {
		super.mostrar_cadastro();
		
		if(exemplar != null) {
			this.exemplar = exemplar;
			prepara_botao_excluir();
			
			janela.setTitle("Editar Exemplar");

			input_codigo.disable();
			
			input_codigo.setText(""+exemplar.getCodigo());
		} else {
			janela.setTitle("Cadastro de Exemplar");
		}
	}
	
	protected void acao_salvar() {
		if(exemplar != null) {
			//livro.setAutor(input_autor.getText());
			//livro.setTitulo(input_titulo.getText());
			
			//LivroController.alterarPorCod(livro);
			//JOptionPane.showMessageDialog(null, "Livro editado!");
		} else {
			Exemplar novoExemplar = new Exemplar(Integer.parseInt(input_codigo.getText()), get_cod_autor(), get_cod_matricula());

			if(ExemplarController.inserir(novoExemplar) != null) {
				JOptionPane.showMessageDialog(null, "Exemplar Inserido");
			} else {
				JOptionPane.showMessageDialog(null, "Erro!");
			}
		}
	}

	private int get_cod_matricula() {
		String[] array_pessoa = combo_box_pessoa.getSelectedItem().toString().split(" - ");
		return Integer.parseInt(array_pessoa[0]);
	}

	private int get_cod_autor() {
		String[] array_autor = combo_box_livro.getSelectedItem().toString().split(" - ");
		return Integer.parseInt(array_autor[0]);
	}

	protected void prepara_form() {

		painel.add(new JLabel("Código"));
		input_codigo = new JTextField();
		painel.add(input_codigo);

		painel.add(new JLabel("Pessoa"));
				
		combo_box_pessoa = new JComboBox<String>();
		for(Pessoa p: PessoaController.listaPessoas()) {
			combo_box_pessoa.addItem(p.getMatricula() + " - " + p.getNome());
		}
		
		painel.add(combo_box_pessoa);
		
		painel.add(new JLabel("Livro"));

		combo_box_livro = new JComboBox<String>();
		for(Livro l: LivroController.listarLivros()) {
			combo_box_livro.addItem(l.getCodigo() + " - " + l.getTitulo());
		}
	
		painel.add(combo_box_livro);
		
	}

	protected void prepara_painel() {
		super.prepara_painel();
		painel.setLayout(new GridLayout(5, 2));
	}
	
	@Override
	protected void prepara_botao_excluir() {
		// TODO Auto-generated method stub
		
	}
}
