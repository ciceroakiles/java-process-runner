package view;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controller.Listeners;
import controller.SearchController;

public class Main {

	public static void main(String[] args) {
		// Setup do botao "ok" e campo texto
		JTextField txt = new JTextField();
		JButton ok = new JButton("OK");
		ok.setEnabled(false);
		Listeners.addComponentListeners(ok, txt);
		// Outros elementos
		JFileChooser fc = new JFileChooser();
		Icon icon = new ImageIcon();
		Object[] body = { "Caminho ou nome do processo:", txt };
		Object[] buttons = { ok, "Cancelar", "Procurar..." };
		int op = -1;
		do {
			// Janela de input
			op = JOptionPane.showOptionDialog(
				null, body, "Executar", JOptionPane.PLAIN_MESSAGE, 0, icon, buttons, buttons[0]
			);
			//System.out.println(op);
			if (op == 2) SearchController.definePath(txt, fc);
			if (op == 1) break;
		} while (op != -1);
		System.exit(0);
	}

}
