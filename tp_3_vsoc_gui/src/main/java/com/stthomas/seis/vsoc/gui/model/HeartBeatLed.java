package com.stthomas.seis.vsoc.gui.model;

public class HeartBeatLed {

	private String heartBeatLedOnAndoff;
	private boolean isLedOn;	// 1-On 0-off
	private String name;
	private String type;
	private String value;

	public HeartBeatLed()
	{
		isLedOn = false;
		name = "MCU_HEARTBEAT_LED";
		type = "Integer";
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
	
	public String getName()
	{
		return name;
	}
	
	public String getType()
	{
		return type;
	}
	
	public String getValue()
	{
		if(isLedOn == true)
		{
			value = "1";
		}
		else
		{
			value = "0";
		}
		return value;
	}
}
