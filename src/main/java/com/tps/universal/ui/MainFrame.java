package com.tps.universal.ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainFrame extends JFrame{
	private static final long serialVersionUID = -4523624454340580142L;
	private static Logger log = Logger.getLogger(MainFrame.class);
	private String title;
	private int preferredWidth;
	private int preferredHight;
	private Component mainPanel;
	private String lookAndFeel;
	
	public static void main(String[] args) {
		log.info("Initializing UI...");
		new ClassPathXmlApplicationContext("beans/universal-main.xml");
	}
	
	public void init() throws Exception {
		UIManager.setLookAndFeel(lookAndFeel);
		setTitle(title);
		setPreferredSize(new Dimension(preferredWidth, preferredHight));
		add(mainPanel);
		pack();
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((dimension.width - this.getWidth()) / 2, (dimension.height - this.getHeight()) / 2);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	//Getters and Setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPreferredWidth() {
		return preferredWidth;
	}

	public void setPreferredWidth(int preferredWidth) {
		this.preferredWidth = preferredWidth;
	}

	public Component getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(Component mainPanel) {
		this.mainPanel = mainPanel;
	}

	public String getLookAndFeel() {
		return lookAndFeel;
	}

	public void setLookAndFeel(String lookAndFeel) {
		this.lookAndFeel = lookAndFeel;
	}

    public int getPreferredHight() {
        return preferredHight;
    }

    public void setPreferredHight(int preferredHight) {
        this.preferredHight = preferredHight;
    }
}
