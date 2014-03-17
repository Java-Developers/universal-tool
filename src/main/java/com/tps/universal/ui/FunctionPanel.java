package com.tps.universal.ui;

import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.JPanel;

import org.apache.log4j.Logger;

public class FunctionPanel extends JPanel {
	private static final long serialVersionUID = -3603668396129835236L;
	private static Logger log = Logger.getLogger(FunctionPanel.class);
	private String panelName;
	private List<GridBagLayoutComponent> componentList;
	private GridBagLayout layout = new GridBagLayout();

	public void init() {
		log.info("Initializing Function Panel: [" + panelName + "]");
		setLayout(layout);
		for (GridBagLayoutComponent component : componentList) {
			log.info("Adding component: [" + component.getComponentName() + "@" + component.getComponent().getClass().getName() + "]");
			layout.setConstraints(component.getComponent(), component);
			add(component.getComponent());
		}
	}
	
	//Getters and Setters
	public String getPanelName() {
		return panelName;
	}

	public void setPanelName(String panelName) {
		this.panelName = panelName;
	}

	public List<GridBagLayoutComponent> getComponentList() {
		return componentList;
	}

	public void setComponentList(List<GridBagLayoutComponent> componentList) {
		this.componentList = componentList;
	}

}
