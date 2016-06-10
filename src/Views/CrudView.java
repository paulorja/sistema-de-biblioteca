package Views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public abstract class CrudView {
	
	protected JButton botaoCancelar;
	private JButton botaoSalvar;
	protected JFrame janela;
	protected JPanel painel;

	protected void mostrar_cadastro() {
		janela = new JFrame("Cadastro");
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						
		janela.pack();
		janela.setResizable(false);
	    janela.setSize(360, 200); 	    
	    janela.setLocationRelativeTo(null);
		janela.setVisible(true);  		
		
		prepara_painel();

	}

	protected void prepara_botao_salvar() {
	    botaoSalvar = new JButton("Salvar");
	    
	    botaoSalvar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	    		acao_salvar();
	        }
	    });
	    
	    painel.add(botaoSalvar);
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
		painel = new JPanel(new GridLayout(1, 2));
		
		painel.setBorder(new EmptyBorder(10, 10, 10, 10));

		prepara_form();
		prepara_botao_cancelar();
		prepara_botao_salvar();
		
		janela.add(painel);
	};
	
	protected abstract void acao_salvar();
	protected abstract void prepara_form();
	
}
