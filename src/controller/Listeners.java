package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Listeners {

	public static void addComponentListeners(JButton btn, JTextField tfield) {
		// Verificacao de clique
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Chamada ao controller
				if (e.getSource() == btn) RunController.callProcess(tfield.getText());
			}
		});
		// Campo de texto torna o botao "ok" habilitado ou nao
		tfield.getDocument().addDocumentListener(new DocumentListener()
		{
			@Override
		    public void insertUpdate(DocumentEvent e)
		    {
		        if(e.getDocument().getLength() > 0) btn.setEnabled(true);
		    }
			
			@Override
		    public void removeUpdate(DocumentEvent e)
		    {
		        if(e.getDocument().getLength() == 0) btn.setEnabled(false);
		    }

		    @Override
		    public void changedUpdate(DocumentEvent e) { }
		});
	}
}
