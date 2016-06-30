package Views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


	private void acao_remover() {

	}


	protected void prepara_botao_salvar() {
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
		painel = new JPanel(new GridLayout(2, 2));

		painel.setBorder(new EmptyBorder(10, 10, 10, 10));

		prepara_form();
		prepara_botao_cancelar();
		prepara_botao_salvar();

		janela.add(painel);
	};

	protected void prepara_form() {
		painel.add(new JLabel(texto_remove));
		input_remove = new JTextField();
		painel.add(input_remove);
	}


	private void prepara_janela() {
		janela = new JFrame("Remover");
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		janela.pack();
		janela.setResizable(false);
	    janela.setSize(440, 120);
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
