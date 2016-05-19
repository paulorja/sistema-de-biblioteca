package Views;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controllers.PessoaController;
import Controllers.ExemplarController;
import Controllers.LivroController;
import Dao.PessoaDao;
import Dao.DaoFactory;
import Dao.LivroDao;
import Models.Pessoa;
import Models.Exemplar;
import Models.Livro;

public class ExemplarView {
	
	public static void inserir() {
		int codExemplar = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do exemplar: "));
		int codLivro = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do livro: "));
		
		Exemplar novoExemplar = new Exemplar(codExemplar, codLivro);
		if(ExemplarController.inserir(novoExemplar) != null) {
			JOptionPane.showMessageDialog(null, "Exemplar inserido!");
		} else {
			JOptionPane.showMessageDialog(null, "Código já utilizado!!");
		}
	}
	
	public static void alugar(Exemplar exemplar) {
		int codMatricula = Integer.parseInt(JOptionPane.showInputDialog("Digite o código de matrícula: "));
		exemplar.setCodMatricula(codMatricula);
		
		ExemplarController.alugar(exemplar);
	}
	
	public static void consultarPorCod() {
		int cod = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do exemplar"));
		
		Exemplar exemplarPesquisado = ExemplarController.consultaPorCod(cod);
		
		if(exemplarPesquisado != null) {
			menuExemplar(exemplarPesquisado);
		} else {
			JOptionPane.showMessageDialog(null, "Não encotrado");
		}
		
		
	}

	private static void menuExemplar(Exemplar exemplarPesquisado) {
		Livro livro = ExemplarController.getLivro(exemplarPesquisado.getCodLivro());
		
		Pessoa pessoa = null;
		if(exemplarPesquisado.getCodMatricula() != 0) {
			pessoa = ExemplarController.getPessoa(exemplarPesquisado.getCodMatricula());
		} 
		
		int opcao = Integer.parseInt(JOptionPane.showInputDialog("Exemplar encontrado: \n"
				+ "-----------------------------------\n"
				+ "Codigo do exemplar: "+exemplarPesquisado.getCodigo()+"\n"
				+ "Livro: "+livro.getTitulo()+"\n"
				+ "Alugado: "+(pessoa == null ? "Não" : pessoa.getNome())+"\n"
				+ "-----------------------------------\n"
				+ "1 - Excluir \n"
				+ "2 - Alugar \n"
				+ "3 - Devolver \n"
				+ "4 - Voltar \n"));
		
		switch (opcao) {
		case 1:
			ExemplarView.remover(exemplarPesquisado.getCodigo());
			break;
		case 2:
			ExemplarView.alugar(exemplarPesquisado);
			break;
		case 3:
			ExemplarView.devolver(exemplarPesquisado);
		case 4:
			break;
		default:
			break;
		}
	}

	private static void devolver(Exemplar exemplar) {
		exemplar.setCodMatricula(0);
		ExemplarController.devolver(exemplar);
		
		JOptionPane.showMessageDialog(null, "Devolvido!");
	}

	private static void remover(int cod) {
		if (JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja excluir o exemplar com o codigo "+cod+"?") == 0) {
			ExemplarController.removerPorCod(cod);
		}
	}
}
