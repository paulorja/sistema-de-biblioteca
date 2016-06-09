package Views;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Controllers.PessoaController;
import Dao.PessoaDao;
import Dao.DaoFactory;
import Models.Pessoa;

public class PessoaView {
	
	private JFrame janela;
	
	public void mostrar_cadastro() {
		janela = new JFrame("Cadastro de Pessoa");
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						
		janela.pack();
	    janela.setSize(480, 480);
		
		janela.setVisible(true);  		
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
