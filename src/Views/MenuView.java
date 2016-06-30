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

	public void mostrar() {
		janela = new JFrame("Sistema de Biblioteca");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		janela.setJMenuBar(barraMenu());

		janela.pack();
	    janela.setSize(540, 540);
	    janela.setExtendedState(JFrame.MAXIMIZED_BOTH);

		janela.setVisible(true);
	}


	public void acao_item_menu(String actionCommand) {
		PessoaView pessoa_view = new PessoaView();
		LivroView livro_view = new LivroView();
		ExemplarView exemplar_view = new ExemplarView();
		ConsultaView consulta_view = new ConsultaView();
		RemoveView remover_view = new RemoveView();

		switch (actionCommand) {
		case "sair":
			janela.dispose();
			break;
		case "mudar_dao":
			alterar_dao();
			break;
		case "cadastro_pessoa":
			pessoa_view.mostrar_cadastro();
			break;
		case "cadastro_livro":
			livro_view.mostrar_cadastro();
			break;
		case "cadastro_exemplar":
			exemplar_view.mostrar_cadastro();
			break;
		case "consulta_aluno":
			consulta_view.mostrar_consulta_aluno();
			break;
		case "consulta_prof":
			consulta_view.mostrar_consulta_professor();
			break;
		case "consulta_livro":
			consulta_view.mostrar_consulta_livro();
			break;
		case "consulta_exemplar":
			consulta_view.mostrar_consulta_exemplar();
			break;
		case "remover_pessoa":
			remover_view.remover_pessoa();
			break;
		case "remover_livro":
			remover_view.remover_livro();
			break;
		case "remover_exemplar":
			remover_view.remover_exemplar();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Error");
			break;
		}
	}
	private void alterar_dao(){
			Dao.DaoFactory.SELECT_DAO = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para arquivo e 2 para banco: "));
	}
	private JMenuBar barraMenu() {
	      final JMenuBar menuBar = new JMenuBar();
	      MenuItemListener menuItemListener = new MenuItemListener();

	      JMenu arquivo = new JMenu("Biblioteca");

	      JMenuItem sair = new JMenuItem("Sair");
		  sair.setActionCommand("sair");

		  JMenuItem mudar_dao = new JMenuItem("Mudar Dao");
		  mudar_dao.setActionCommand("mudar_dao");

	      JMenu cadastros = new JMenu("Cadastros");

  		  JMenuItem cadastros_pessoa = new JMenuItem("Pessoa");
		  cadastros_pessoa.setActionCommand("cadastro_pessoa");

		  JMenuItem cadastros_livro = new JMenuItem("Livro");
		  cadastros_livro.setActionCommand("cadastro_livro");

		  JMenuItem cadastros_exemplar = new JMenuItem("Exemplar");
		  cadastros_exemplar.setActionCommand("cadastro_exemplar");

	      JMenu consultas = new JMenu("Consultas");

	      JMenuItem consultas_aluno = new JMenuItem("Aluno");
	      consultas_aluno.setActionCommand("consulta_aluno");

	      JMenuItem consultas_prof = new JMenuItem("Professor");
	      consultas_prof.setActionCommand("consulta_prof");

	      JMenuItem consultas_livro = new JMenuItem("Livro");
	      consultas_livro.setActionCommand("consulta_livro");

	      JMenuItem consultas_exemplar = new JMenuItem("Exemplar");
	      consultas_exemplar.setActionCommand("consulta_exemplar");

		  JMenu remover = new JMenu("Remover");

	      JMenuItem remover_pessoa = new JMenuItem("Pessoa");
	      remover_pessoa.setActionCommand("remover_pessoa");


	      JMenuItem remover_livro = new JMenuItem("Livro");
	      remover_livro.setActionCommand("remover_livro");

	      JMenuItem remover_exemplar = new JMenuItem("Exemplar");
	      remover_exemplar.setActionCommand("remover_exemplar");

	      arquivo.add(sair);
		  arquivo.add(mudar_dao);

	      cadastros.add(cadastros_pessoa);
	      cadastros.add(cadastros_livro);
	      cadastros.add(cadastros_exemplar);

	      consultas.add(consultas_aluno);
	      consultas.add(consultas_prof);
	      consultas.add(consultas_livro);
	      consultas.add(consultas_exemplar);

		  remover.add(remover_pessoa);
	      remover.add(remover_livro);
	      remover.add(remover_exemplar);


	      menuBar.add(arquivo);
	      menuBar.add(cadastros);
	      menuBar.add(consultas);
		  menuBar.add(remover);

	      sair.addActionListener(menuItemListener);
		  mudar_dao.addActionListener(menuItemListener);
		  cadastros_pessoa.addActionListener(menuItemListener);
		  cadastros_livro.addActionListener(menuItemListener);
		  cadastros_exemplar.addActionListener(menuItemListener);
	      consultas_aluno.addActionListener(menuItemListener);
	      consultas_prof.addActionListener(menuItemListener);
	      consultas_livro.addActionListener(menuItemListener);
	      consultas_exemplar.addActionListener(menuItemListener);
		  remover_pessoa.addActionListener(menuItemListener);
	      remover_livro.addActionListener(menuItemListener);
	      remover_exemplar.addActionListener(menuItemListener);


	      return menuBar;
	 }

	 class MenuItemListener implements ActionListener {
	      public void actionPerformed(ActionEvent e) {
	    	  acao_item_menu(e.getActionCommand());
	      }
	 }

}
