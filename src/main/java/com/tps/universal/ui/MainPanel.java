package com.tps.universal.ui;

import java.util.List;

import javax.swing.JTabbedPane;

import org.apache.log4j.Logger;


public class MainPanel extends JTabbedPane {
	private static final long serialVersionUID = 1514568308516655549L;
	private static Logger log = Logger.getLogger(MainPanel.class);
	private List<Tab> tabs;
	
	public void addTab(Tab tab) {
		addTab(tab.getTabName(), tab.getIcon(), tab.getComponent(), tab.getTip());
	}

	public void init() {
		for (Tab tab : tabs) {
			log.debug("Adding Tab: " + tab);
			addTab(tab);
		}
	}

	//Getters and Setters
	public List<Tab> getTabs() {
		return tabs;
	}

	public void setTabs(List<Tab> tabs) {
		this.tabs = tabs;
	}
}
