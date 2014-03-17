package com.tps.universal.ui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GridBagLayoutComponent extends GridBagConstraints {
	private static final long serialVersionUID = -8337886689290079361L;
	private String componentName;
	private Component component;

	
	
	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

	public void setGridwidth(int width) {
		this.gridwidth = width;
	}
	
	public void setGridheight(int height) {
		this.gridheight = height;
	}
	
	public void setGridx (int x) {
		this.gridx = x;
	}

	public void setGridy (int y) {
		this.gridy = y;
	}
	
	public void setFill (int fill) {
		this.fill = fill;
	}
	
	public void setWeightx(double weightx) {
		this.weightx = weightx;
	}
	
	public void setWeighty(double weighty) {
		this.weighty = weighty;
	}
	
	public void setIpadx(int ipadx) {
		this.ipadx = ipadx;
	}
	
	public void setIpady(int ipady) {
		this.ipady = ipady;
	}
	
	public void setAnchor(int anchor) {
		this.anchor = anchor;
	}
	
	public void setInsets(Insets insets) {
		this.insets = insets;
	}
}
