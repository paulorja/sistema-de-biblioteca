package Views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controllers.ExemplarController;
import Controllers.LivroController;
import Controllers.PessoaController;
import Models.Exemplar;
import Models.Livro;
import Models.Pessoa;

public class ConsultaView {
	
	protected JButton botaoCancelar;
	private JButton botaoPesquisar;
	protected JFrame janela;
	protected JPanel painel;
	private JTextField input_busca;
	private String texto_busca;
	private String entidade;
	
	private void acao_pesquisar() {
		switch (this.entidade) {
			case "pessoa":
				Pessoa pessoa = PessoaController.consultaPorCodMatricula(Integer.parseInt(input_busca.getText()));
				if(pessoa != null) {
					PessoaView pessoa_view = new PessoaView();
					pessoa_view.mostrar_cadastro(pessoa);
				} else {
					JOptionPane.showMessageDialog(null, "Pessoa n„o encontrada. Tente novamente.");
				}
				break;
			case "livro":
				Livro livro = LivroController.consultaPorCod(Integer.parseInt(input_busca.getText()));
				if(livro != null) {
					LivroView livro_view = new LivroView();
					livro_view.mostrar_cadastro(livro);
				} else {
					JOptionPane.showMessageDialog(null, "Livro n„o encontrado. Tente novamente.");
				}
				break;
			case "exemplar":
				Exemplar exemplar = ExemplarController.consultaPorCod(Integer.parseInt(input_busca.getText()));
				if(exemplar != null) {
					ExemplarView exemplar_view = new ExemplarView();
					exemplar_view.mostrar_cadastro(exemplar);
				} else {
					JOptionPane.showMessageDialog(null, "Exemplar n„o encontrado. Tente novamente.");
				}
				break;
			default:
				break;
		}
	}
	
	public void mostrar_consulta_pessoa() {
		prepara_janela();
		janela.setTitle("Consultar Pessoa");
		texto_busca = "Cod Matr√≠cula da Pessoa:";
		this.entidade = "pessoa";
		prepara_painel();
	
	}

	public void mostrar_consulta_livro() {
		prepara_janela();
		janela.setTitle("Consultar Livro");
		texto_busca = "Cod do Livro:";
		this.entidade = "livro";
		prepara_painel();
	}

	public void mostrar_consulta_exemplar() {
		prepara_janela();
		janela.setTitle("Consultar Exemplar");
		texto_busca = "Cod do Exemplar:";
		this.entidade = "exemplar";
		prepara_painel();
	}
	
	protected void prepara_botao_salvar() {
		botaoPesquisar = new JButton("Pesquisar");
	    
		botaoPesquisar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	    		acao_pesquisar();
	        }
	    });
	    
	    painel.add(botaoPesquisar);
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
		painel.add(new JLabel(texto_busca));
		input_busca = new JTextField();		
		painel.add(input_busca);
	}

	
	private void prepara_janela() {
		janela = new JFrame("Consultar");
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						
		janela.pack();
		janela.setResizable(false);
	    janela.setSize(440, 120); 	    
	    janela.setLocationRelativeTo(null);
		janela.setVisible(true);  		
	}
	
}
