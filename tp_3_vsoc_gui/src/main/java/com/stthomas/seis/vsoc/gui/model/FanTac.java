package com.stthomas.seis.vsoc.gui.model;

public class FanTac extends Fan{
	private boolean manual;
	private boolean lookup;
	

	public boolean isManual() {
		return manual;
	}

	public void setManual(boolean manual) {
		this.manual = manual;
	}

	public boolean isLookup() {
		return lookup;
	}

	public void setLookup(boolean lookup) {
		this.lookup = lookup;
	}

}
