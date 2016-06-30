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

public class ConsultaView {
	
	protected JButton botaoCancelar;
	private JButton botaoPesquisar;
	protected JFrame janela;
	protected JPanel painel;
	private JTextField input_busca;
	private String texto_busca;
	
	
	private void acao_pesquisar() {
	
	}
	
	
	protected void prepara_botao_salvar() {
		botaoPesquisar = new JButton("Salvar");
	    
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
	
	public void mostrar_consulta_aluno() {
		prepara_janela();
		janela.setTitle("Consultar Aluno");
		texto_busca = "Cod Matrícula do Aluno:";
		prepara_painel();
	
	}

	public void mostrar_consulta_professor() {
		prepara_janela();
		janela.setTitle("Consultar Professor");
		texto_busca = "Cod Matrícula do Professor:";
		prepara_painel();
	}
	
	public void mostrar_consulta_livro() {
		prepara_janela();
		janela.setTitle("Consultar Livro");
		texto_busca = "Cod do Livro:";
		prepara_painel();
	}

	public void mostrar_consulta_exemplar() {
		prepara_janela();
		janela.setTitle("Consultar Exemplar");
		texto_busca = "Cod do Exemplar:";
		prepara_painel();
	}
}
