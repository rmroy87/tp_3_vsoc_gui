package com.stthomas.seis.vsoc.gui.model;

import javax.validation.constraints.NotNull;

import com.stthomas.seis.vsoc.gui.observer.VSocObserver;

public class VSocUI implements VSocObserver{
	

	@NotNull
//	@Size(min = 3, max = 10, message="Input field must be valid digit numbers min = 3, max = 10")
	private String fanPwmInput;

	@NotNull
//	@Size(min = 3, max = 10, message="Input field must be valid digit numbers min = 3, max = 10")
	private String fanTacInput;
	private String tempSensorInput;
	private String dpol1_0VInput;
	private String dpol1_8VInput;
	private String mcuHeartBeatLedInput;
	private String UP_GPI[];
	private String EXP_GPI[];
	private String UP_GPO[];
	private String EXP_GPO[];
	private int max_pin = 4;
	
	public VSocUI()
	{
		UP_GPI = new String [4];
		EXP_GPI = new String [4];
		UP_GPO = new String [4];
		EXP_GPO = new String [4];
	}
	

	public String getFanPwmInput() {
		return fanPwmInput;
	}
	public void setFanPwmInput(String fanPwmInput) {
		this.fanPwmInput = fanPwmInput;
	}

	public String getFanTacInput() {
		return fanTacInput;
	}
	public void setFanTacInput(String fanTacInput) {
		this.fanTacInput = fanTacInput;
	}

	public String getTempSensorInput() {
		return tempSensorInput;
	}
	public void setTempSensorInput(String tempSensorInput) {
		this.tempSensorInput = tempSensorInput;
	}

	public String getDpol1_0VInput() {
		return dpol1_0VInput;
	}
	public void setDpol1_0VInput(String dpol1_0vInput) {
		dpol1_0VInput = dpol1_0vInput;
	}

	public String getDpol1_8VInput() {
		return dpol1_8VInput;
	}
	public void setDpol1_8VInput(String dpol1_8vInput) {
		dpol1_8VInput = dpol1_8vInput;
	}

	public String getMcuHeartBeatLedInput() {
		return mcuHeartBeatLedInput;
	}
	public void setMcuHeartBeatLedInput(String mcuHeartBeatLedInput) {
		this.mcuHeartBeatLedInput = mcuHeartBeatLedInput;
	}

	public String getGPI(int pinNum, String pinName) 
	{
		if(pinNum < max_pin)
		{
			if(pinName == "UP")
			{
				return this.UP_GPI[pinNum];
			}else if(pinName == "EXP")
			{
				return this.EXP_GPI[pinNum];
			}
		}
		return "";
	}
	public void setGPI(int pinNum, String pinName, String pinStatus) 
	{
		if(pinNum < max_pin)
		{
			if(pinName  == "UP")
			{
				this.UP_GPI[pinNum] = pinStatus;
			}
			else if(pinName == "EXP")
			{
				this.EXP_GPI[pinNum] = pinStatus;	
			}
		}
	}
	
	public String getGPO(int pinNum, String pinName) 
	{
		if(pinNum < max_pin)
		{
			if(pinName == "UP")
			{
				return this.UP_GPO[pinNum];
			}
			else if(pinName == "EXP")
			{
				return this.EXP_GPO[pinNum];
			}
		}
		return "";
	}
	public void setGPO(int pinNum, String pinName, String pinStatus) 
	{
		if(pinNum < max_pin)
		{
			if(pinName  == "UP")
			{
				this.UP_GPO[pinNum] = pinStatus;
			}
			else if(pinName == "EXP")
			{
				this.EXP_GPO[pinNum] = pinStatus;	
			}
		}
	}
	
	@Override
    public String toString() {
        return "UIComponent{" + "MCU_HEART_BEAT_LED = " + mcuHeartBeatLedInput + ", Fan PWM = " + fanPwmInput + ", Fan TAC=" + fanTacInput + ", Temp Sensor=" + tempSensorInput + ", DPOL - 1.0V=" + dpol1_0VInput + ", DPOL - 1.8V=" + dpol1_8VInput +'}';
    }

	
	@Override
	public void update(Object o) {
		// Print the update changes
        System.out.println("State change '" + o.toString() + "'");
	}
}
