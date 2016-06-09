package Views;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MenuView {
	
	private JFrame janela;

	
	 private JMenuBar barraMenu() {
	      final JMenuBar menuBar = new JMenuBar();
	      MenuItemListener menuItemListener = new MenuItemListener();
	      
	      JMenu arquivo = new JMenu("Arquivo");
	      
	      JMenuItem sair = new JMenuItem("Sair");
		  sair.setActionCommand("sair");

	      JMenu cadastros = new JMenu("Cadastros"); 
		      
  		  JMenuItem cadastros_pessoa = new JMenuItem("Pessoa");
		  cadastros_pessoa.setActionCommand("cadastro_pessoa");

		  JMenuItem cadastros_livro = new JMenuItem("Livro");
		  cadastros_livro.setActionCommand("cadastro_livro");
		  
		  JMenuItem cadastros_exemplar = new JMenuItem("Exemplar");
		  cadastros_exemplar.setActionCommand("cadastro_exemplar");
	      
	      JMenu consultas = new JMenu("Consultas"); 
		      
	      JMenuItem consultas_pessoa = new JMenuItem("Pessoa");
	      consultas_pessoa.setActionCommand("consulta_pessoa");
		  
	      JMenuItem consultas_livro = new JMenuItem("Livro");
	      consultas_livro.setActionCommand("consulta_livro");
		  
	      JMenuItem consultas_exemplar = new JMenuItem("Exemplar");
	      consultas_exemplar.setActionCommand("consulta_exemplar");
		  
	      arquivo.add(sair);
	      
	      cadastros.add(cadastros_pessoa);
	      cadastros.add(cadastros_livro);
	      cadastros.add(cadastros_exemplar);
	      
	      consultas.add(consultas_pessoa);
	      consultas.add(consultas_livro);
	      consultas.add(consultas_exemplar);
	      
	      menuBar.add(arquivo);
	      menuBar.add(cadastros);
	      menuBar.add(consultas);
	      
	      sair.addActionListener(menuItemListener);
		  cadastros_pessoa.addActionListener(menuItemListener);
		  cadastros_livro.addActionListener(menuItemListener);
		  cadastros_exemplar.addActionListener(menuItemListener);
	      consultas_pessoa.addActionListener(menuItemListener);
	      consultas_livro.addActionListener(menuItemListener);
	      consultas_exemplar.addActionListener(menuItemListener);

	      
	      return menuBar;
	 }
	
	 class MenuItemListener implements ActionListener {
	      public void actionPerformed(ActionEvent e) {
	    	 action_item_menu(e.getActionCommand());
	      }    
	   }
	 
	private void mostraJanela() {
		janela = new JFrame("Sistema de Biblioteca");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		janela.setJMenuBar(barraMenu());
		
		janela.pack();
	    janela.setSize(540, 540);
		
		janela.setVisible(true);  		
	}
	
	public void action_item_menu(String actionCommand) {
		switch (actionCommand) {
		case "sair":
			janela.dispose();
			break;
		case "cadastro_pessoa":
			PessoaView.inserir();
			break;
		case "cadastro_livro":
			break;
		case "cadastro_exemplar":
			break;
		case "consulta_pessoa":
			break;
		case "consulta_livro":
			break;
		case "consulta_exemplar":
			break;
		default:
			JOptionPane.showMessageDialog(null, "Error");
			break;
		}
	}

	public void show_menu() {
		mostraJanela();		
	}	
	
	
	public void show() {
		boolean	fecharSistema = false;
		boolean	fecharPessoa;
		boolean	fecharLivros;
		boolean	fecharExemplares;
		
		while(fecharSistema == false) {
			fecharPessoa = false;
			fecharLivros = false;
			fecharExemplares = false;
			
			switch (Integer.parseInt(JOptionPane.showInputDialog("[[BIBLIOTECA]] - Menu\n"
					+ "1 - Pessoas\n"
					+ "2 - Livros\n"
					+ "3 - Exemplares\n"
					+ "4 - Sair"))) {
			
				case 1:
					while(fecharPessoa == false) {
						switch (Integer.parseInt(JOptionPane.showInputDialog("[[PESSOAS]] - Menu\n"
								+ "1 - Consultar\n"
								+ "2 - Novo\n"
								+ "3 - Voltar"))) {
							case 1:
								PessoaView.consultaPorCodMatricula();
								break;
							case 2:
								PessoaView.inserir();
								break;
							case 3:
								fecharPessoa = true;
								break;
							}
					}
					break;	
				case 2:
					while(fecharLivros == false) {
						switch (Integer.parseInt(JOptionPane.showInputDialog("[[LIVROS]] - Menu\n"
								+ "1 - Consultar\n"
								+ "2 - Novo\n"
								+ "3 - Voltar"))) {
							case 1:
								LivroView.consultarPorCod();
								break;
							case 2:
								LivroView.inserir();
								break;
							case 3:
								fecharLivros = true;
								break;
						}
					}
					break;
				case 3:
					while(fecharExemplares == false) {
						switch (Integer.parseInt(JOptionPane.showInputDialog("[[EXEMPLARES]] - Menu\n"
								+ "1 - Consultar\n"
								+ "2 - Novo\n"
								+ "3 - Voltar"))) {
							case 1:
								ExemplarView.consultarPorCod();
								break;
							case 2:
								ExemplarView.inserir();
								break;
							case 3:
								fecharExemplares = true;
								break;
						}
					}
					break;
				case 4:
					fecharSistema = true;
					break;
			}			
		}
	}

}
