package com.tps.universal.ui;

import java.awt.Component;

import javax.swing.Icon;

public class Tab extends Component {
	private static final long serialVersionUID = -8360283538358180316L;
	private String tabName;
	private Icon icon;
	private Component component;
	private String tip;

	public String toString() {
		return "[TabName=" + tabName + ", Icon=" + icon + ", Component=" + component + ", Tip=" + tip + "]"; 
	}
	
	//Getters and Setters
	public String getTabName() {
		return tabName;
	}

	public void setTabName(String tabName) {
		this.tabName = tabName;
	}

	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
}
