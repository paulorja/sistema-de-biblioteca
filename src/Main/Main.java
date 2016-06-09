package Main;

import java.awt.Menu;

import javax.swing.JOptionPane;

import Dao.ArquivoPessoaDao;
import Models.Pessoa;
import Views.ExemplarView;
import Views.LivroView;
import Views.PessoaView;
import Views.MenuView;


public class Main {

	public static void main(String[] args) {
		MenuView menu = new MenuView();
		menu.show_menu();
	}
}
