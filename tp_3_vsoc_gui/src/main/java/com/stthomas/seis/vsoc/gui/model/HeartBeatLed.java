package com.stthomas.seis.vsoc.gui.model;

public class HeartBeatLed {

	private String heartBeatLedOnAndoff;
	private boolean isLedOn;	// 1-On 0-off

	public HeartBeatLed()
	{
		isLedOn = false;
	}
	
	public String getHeartBeatLedOnAndoff() {
		return heartBeatLedOnAndoff;
	}

	public void setHeartBeatLedOnAndoff(String heartBeatLedOnAndoff) {
		this.heartBeatLedOnAndoff = heartBeatLedOnAndoff;
	}
	
	public void setLedOn()
	{
		isLedOn = true;
	}
	
	public void setLedOff()
	{
		isLedOn = false;
	}
	
	public boolean isLedStatusOn()
	{
		return isLedOn;
	}
}
