package controller;

import javax.swing.JFileChooser;
import javax.swing.JTextField;

public class SearchController {

	// Passagem do caminho do filechooser para o campo de texto
	public static void definePath(JTextField tfield, JFileChooser filec) {
		try {
			filec.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		    filec.showOpenDialog(tfield);
		    tfield.setText(filec.getSelectedFile().getAbsolutePath());
		} catch (Exception e) { }
	}
}
