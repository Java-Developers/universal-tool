package com.tps.universal.ui;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import org.apache.log4j.Logger;

public class UniversalButton extends JButton {
	private static final long serialVersionUID = 4710116035180215984L;
	private static Logger log = Logger.getLogger(UniversalButton.class);
	private String text;
	private List<ActionListener> listenerList;

	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<ActionListener> getListenerList() {
		return listenerList;
	}

	public void setListenerList(List<ActionListener> listenerList) {
		this.listenerList = listenerList;
		for (ActionListener listener : listenerList) {
			log.info("Registering Listener: [" + listener + "] to [" + this.getText() + " Button]");
			addActionListener(listener);
		}
	}

}
