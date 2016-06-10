package Views;

import java.awt.FlowLayout;
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
import Dao.PessoaDao;
import Dao.DaoFactory;
import Models.Pessoa;

public class PessoaView {
	
	private JFrame janela;
	private JPanel painel;
	private JButton botaoSalvar;
	private JButton botaoCancelar;
	private JTextField input_nome;
	private JTextField input_matricula;
	private JRadioButton professor_radio;
	private JRadioButton aluno_radio;
	
	public void mostrar_cadastro() {
		janela = new JFrame("Cadastro de Pessoa");
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						
		janela.pack();
		janela.setResizable(false);
	    janela.setSize(360, 200); 	    
	    janela.setLocationRelativeTo(null);
	    
	    prepara_painel();
	    
		janela.setVisible(true);  		
	}
	
	private void prepara_form() {
		
		painel.add(new JLabel("Nome"));
		input_nome = new JTextField();		
		painel.add(input_nome);
		
		painel.add(new JLabel("Matricula"));
		input_matricula = new JTextField();
		painel.add(input_matricula);
		
		
		painel.add(new JLabel("Tipo"));
		aluno_radio = new JRadioButton("Aluno");
		professor_radio = new JRadioButton("Professor");	
		JPanel radio_painel = new JPanel(new GridLayout(1, 2));
		radio_painel.add(aluno_radio);
		radio_painel.add(professor_radio);
		painel.add(radio_painel);
		
	}
	
	private void prepara_painel() {		
		painel = new JPanel(new GridLayout(4, 2));
		
		painel.setBorder(new EmptyBorder(10, 10, 10, 10));

		prepara_form();
		prepara_botao_cancelar();
		prepara_botao_salvar();
		
		janela.add(painel);
	}
	
	private void prepara_botao_salvar() {
	    botaoSalvar = new JButton("Salvar");
	    
	    botaoSalvar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	    		Pessoa novaPessoa = new Pessoa(Integer.parseInt(input_matricula.getText()), 'p', input_nome.getText());

	    		if(PessoaController.inserir(novaPessoa) != null) {
	    			JOptionPane.showMessageDialog(null, "Pessoa inserida!");
	    			janela.dispose();
	    		} else {
	    			JOptionPane.showMessageDialog(null, "Erro!");
	    		}
	    		
	        	System.out.println("salvar!");
	        }
	    });
	    
	    painel.add(botaoSalvar);
	}
	
	private void prepara_botao_cancelar() {
	    botaoCancelar = new JButton("Cancelar");
	    
	    botaoCancelar.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	janela.dispose();
	        }
	    });
	    
	    painel.add(botaoCancelar);
	}

	
	
	public static void inserir() {
		char tipo = JOptionPane.showInputDialog("Digite um tipo(a ou p): ").charAt(0);
		if(tipo != 'a' && tipo != 'p') {
			JOptionPane.showMessageDialog(null, "Tipo incorreto!");
			return;
		}
		int codMatricula = Integer.parseInt(JOptionPane.showInputDialog("Digite um codigo de matrícula: "));
		String nome = JOptionPane.showInputDialog("Digite um nome: ");
		
		Pessoa novaPessoa = new Pessoa(codMatricula, tipo, nome);
		if(PessoaController.inserir(novaPessoa) != null) {
			JOptionPane.showMessageDialog(null, "Pessoa inserida!");
		} else {
			JOptionPane.showMessageDialog(null, "Código de matrícula já utilizado!");
		}
		
	}
	
	public static void consultaPorCodMatricula() {
		int codMatricula = Integer.parseInt(JOptionPane.showInputDialog("Digite o código de matrícula"));
		
		Pessoa alunoPesquisado = PessoaController.consultaPorCodMatricula(codMatricula);
		
		if(alunoPesquisado != null) {
			menuPessoa(alunoPesquisado);
		} else {
			JOptionPane.showMessageDialog(null, "Não encotrado");
		}
		
	}
	
	private static void remover(int codMatricula) {
		if (JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir a pessoa com o codigo "+codMatricula+"?") == 0) {
			PessoaController.removerPorCodMatricula(codMatricula);
		}
	}

	private static void alterar(int codMatricula) {
		char tipo = JOptionPane.showInputDialog("Digite um tipo(a ou p): ").charAt(0);
		String nome = JOptionPane.showInputDialog("Digite um nome: ");
		Pessoa aluno = new Pessoa(codMatricula, tipo, nome);
		
		PessoaController.alterarPorCodMatricula(aluno);
	};
	
	private static void menuPessoa(Pessoa alunoPesquisado) {
			
		int opcao = Integer.parseInt(JOptionPane.showInputDialog("Pessoa encontrada: \n\n"
				+ "Tipo: "+alunoPesquisado.getNomeTipo()+"\n"
				+ "Matrícula: "+alunoPesquisado.getMatricula()+"\n"
				+ "Nome: "+alunoPesquisado.getNome()+"\n"
				+ "-----------------------------------\n"
				+ "1 - Alterar \n"
				+ "2 - Excluir \n"
				+ "3 - Voltar \n"));
		
		switch (opcao) {
		case 1:
			PessoaView.alterar(alunoPesquisado.getMatricula());
			break;
		case 2:
			PessoaView.remover(alunoPesquisado.getMatricula());
			break;
		case 3:
			break;
		default:
			break;
		}
			

	}
}
