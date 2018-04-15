package com.stthomas.seis.vsoc.gui.model;
/**
 * Digital Power of Load System
 */
public abstract class DPol {

	private String input;
	private String manualInput;
	private String configuredInput;
	
	
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getManualInput() {
		return manualInput;
	}
	public void setManualInput(String manualInput) {
		this.manualInput = manualInput;
	}
	public String getConfiguredInput() {
		return configuredInput;
	}
	public void setConfiguredInput(String configuredInput) {
		this.configuredInput = configuredInput;
	}

	
}
