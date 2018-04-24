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
