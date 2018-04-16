package com.stthomas.seis.vsoc.gui.model;

public class TemperatureSensor {

	private String temperature;
	private String manualInput;
	private String configuredInput;
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
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
