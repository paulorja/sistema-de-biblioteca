package Views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controllers.PessoaController;

public class RemoveView {

	protected JButton botaoCancelar;
	private JButton botaoRemover;
	protected JFrame janela;
	protected JPanel painel;
	private JTextField input_remove;
	private String texto_remove;
	private JRadioButton professor_radio;
	private JRadioButton aluno_radio;


	private void acao_remover() {
		
	}


	protected void prepara_botao_remover() {
		botaoRemover = new JButton("Remover");

		botaoRemover.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	    		acao_remover();
	        }
	    });

	    painel.add(botaoRemover);
	}

	protected void prepara_botao_cancelar() {
	    botaoCancelar = new JButton("Cancelar");

	    botaoCancelar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	janela.dispose();
	        }
	    });

	    painel.add(botaoCancelar);
	}

	protected void prepara_painel() {
		painel = new JPanel(new GridLayout(3, 2));

		painel.setBorder(new EmptyBorder(10, 10, 10, 10));

		prepara_form();
		prepara_botao_cancelar();
		prepara_botao_remover();

		janela.add(painel);
	};

	protected void prepara_form() {
		painel.add(new JLabel(texto_remove));
		input_remove = new JTextField();
		painel.add(input_remove);

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


	private void prepara_janela() {
		janela = new JFrame("Remover");
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		janela.pack();
		janela.setResizable(false);
	    janela.setSize(440, 200);
	    janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}

	public void remover_pessoa() {
		prepara_janela();
		janela.setTitle("Remover Pessoa");
		texto_remove = "Cod da Pessoa:";
		prepara_painel();

	}

	public void remover_livro() {
		prepara_janela();
		janela.setTitle("Remover Livro");
		texto_remove = "Cod do Livro:";
		prepara_painel();
	}

	public void remover_exemplar() {
		prepara_janela();
		janela.setTitle("Remover Exemplar");
		texto_remove = "Cod do Exemplar:";
		prepara_painel();
	}
}
