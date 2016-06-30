package Views;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controllers.PessoaController;
import Dao.PessoaDao;
import Dao.DaoFactory;
import Models.Pessoa;

public class PessoaView extends CrudView {

	private JTextField input_nome;
	private JTextField input_matricula;
	private JRadioButton professor_radio;
	private JRadioButton aluno_radio;
	private Pessoa pessoa;

	public void mostrar_cadastro(Pessoa pessoa) {
		super.mostrar_cadastro();

		if(pessoa != null) {
			this.pessoa = pessoa;
			prepara_botao_excluir();

			janela.setTitle("Editar Pessoa");

			input_matricula.disable();

			input_nome.setText(pessoa.getNome());
			input_matricula.setText(""+pessoa.getMatricula());
		} else {
			janela.setTitle("Cadastro de Pessoa");
		}

	}

	protected void prepara_painel() {
		super.prepara_painel();
		painel.setLayout(new GridLayout(5, 2));
	}

	protected void prepara_form() {

		painel.add(new JLabel("Nome"));
		input_nome = new JTextField();
		painel.add(input_nome);

		painel.add(new JLabel("Matricula"));
		input_matricula = new JTextField();
		painel.add(input_matricula);


		painel.add(new JLabel("Tipo"));
		aluno_radio = new JRadioButton("Aluno",true);
		professor_radio = new JRadioButton("Professor",false);
		ButtonGroup grupoPessoa = new ButtonGroup();
		grupoPessoa.add(aluno_radio);
		grupoPessoa.add(professor_radio);
		JPanel radio_painel = new JPanel(new GridLayout(1, 2));
		radio_painel.add(aluno_radio);
		radio_painel.add(professor_radio);
		painel.add(radio_painel);

	}

	protected void acao_salvar() {
		if(pessoa != null) {
			pessoa.setNome(input_nome.getText());
			PessoaController.alterarPorCodMatricula(pessoa);
			JOptionPane.showMessageDialog(null, "Pessoa editada!");
		} else {
			char radio='x';
			if (professor_radio.isSelected()){
				radio='p';
			}else{
				radio='a';
			}
			Pessoa novaPessoa = new Pessoa(Integer.parseInt(input_matricula.getText()), radio, input_nome.getText());
			if(PessoaController.inserir(novaPessoa) != null) {
				JOptionPane.showMessageDialog(null, "Pessoa inserida!");
			} else {
				JOptionPane.showMessageDialog(null, "Erro!");
			}
		}

		janela.dispose();
	}

	protected void prepara_botao_excluir() {
	    botaoExcluir= new JButton("Excluir");

	    botaoExcluir.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	PessoaController.removerPorCodMatricula(Integer.parseInt(input_matricula.getText()));
				JOptionPane.showMessageDialog(null, "Pessoa Excluída!");
				janela.dispose();
	        }
	    });

	    painel.add(botaoExcluir);
	}
}
