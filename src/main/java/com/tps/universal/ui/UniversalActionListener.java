package com.tps.universal.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class UniversalActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()instanceof UniversalButton) {
			UniversalButton btn = (UniversalButton) e.getSource();
			String text = btn.getText();
			JOptionPane.showMessageDialog(null, text);
		}
		
	}

}
