package Main;

import javax.swing.JOptionPane;

import Dao.ArquivoPessoaDao;
import Models.Pessoa;
import Views.ExemplarView;
import Views.LivroView;
import Views.PessoaView;

public class Main {

	public static void main(String[] args) {
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
