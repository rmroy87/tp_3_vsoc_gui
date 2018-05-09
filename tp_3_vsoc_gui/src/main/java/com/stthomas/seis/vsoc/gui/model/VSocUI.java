package com.stthomas.seis.vsoc.gui.model;

import javax.validation.constraints.NotNull;

import com.stthomas.seis.vsoc.client.VSocClientMsg;
import com.stthomas.seis.vsoc.gui.observer.VSocObserver;
import com.stthomas.seis.vsoc.gui.service.VSocService;

public class VSocUI implements VSocObserver {

	private String mcuHeartBeatLedInput;
	@NotNull
	private String fanPwmInput;

	@NotNull
	private String fanTacInput;
	private String tempSensorInput;
	private String dpol1_0VInput;
	private String dpol1_8VInput;
	private String dpol3_3VInput;
	private String dpol5_0VInput;
	private String dpol12_0VInput;
	private String upInput_0;
	private String upInput_1;
	private String upInput_2;
	private String upInput_3;
	private String expInput_0;
	private String expInput_1;
	private String expInput_2;
	private String expInput_3;
	private String upLed_0;
	private String upLed_1;
	private String upLed_2;
	private String upLed_3;
	private String expLed_0;
	private String expLed_1;
	private String expLed_2;
	private String expLed_3;

	private VSocService vSocService;
	
	private VSocClientMsg clientMsg;
	
	public VSocService getvSocService() {
		return vSocService;
	}

	public void setvSocService(VSocService vSocService) {
		this.vSocService = vSocService;
	}

	public String getDpol3_3VInput() {
		return dpol3_3VInput;
	}

	public void setDpol3_3VInput(String dpol3_3vInput) {
		dpol3_3VInput = dpol3_3vInput;
	}

	public String getDpol5_0VInput() {
		return dpol5_0VInput;
	}

	public void setDpol5_0VInput(String dpol5_0vInput) {
		dpol5_0VInput = dpol5_0vInput;
	}

	public String getDpol12_0VInput() {
		return dpol12_0VInput;
	}

	public void setDpol12_0VInput(String dpol12_0vInput) {
		dpol12_0VInput = dpol12_0vInput;
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

	public String getUpInput_0() {
		return upInput_0;
	}

	public void setUpInput_0(String upInput_0) {
		this.upInput_0 = upInput_0;
	}

	public String getUpInput_1() {
		return upInput_1;
	}

	public void setUpInput_1(String upInput_1) {
		this.upInput_1 = upInput_1;
	}

	public String getUpInput_2() {
		return upInput_2;
	}

	public void setUpInput_2(String upInput_2) {
		this.upInput_2 = upInput_2;
	}

	public String getUpInput_3() {
		return upInput_3;
	}

	public void setUpInput_3(String upInput_3) {
		this.upInput_3 = upInput_3;
	}

	public String getExpInput_0() {
		return expInput_0;
	}

	public void setExpInput_0(String expInput_0) {
		this.expInput_0 = expInput_0;
	}

	public String getExpInput_1() {
		return expInput_1;
	}

	public void setExpInput_1(String expInput_1) {
		this.expInput_1 = expInput_1;
	}

	public String getExpInput_2() {
		return expInput_2;
	}

	public void setExpInput_2(String expInput_2) {
		this.expInput_2 = expInput_2;
	}

	public String getExpInput_3() {
		return expInput_3;
	}

	public void setExpInput_3(String expInput_3) {
		this.expInput_3 = expInput_3;
	}

	public String getUpLed_0() {
		return upLed_0;
	}

	public void setUpLed_0(String upLed_0) {
		this.upLed_0 = upLed_0;
	}

	public String getUpLed_1() {
		return upLed_1;
	}

	public void setUpLed_1(String upLed_1) {
		this.upLed_1 = upLed_1;
	}

	public String getUpLed_2() {
		return upLed_2;
	}

	public void setUpLed_2(String upLed_2) {
		this.upLed_2 = upLed_2;
	}

	public String getUpLed_3() {
		return upLed_3;
	}

	public void setUpLed_3(String upLed_3) {
		this.upLed_3 = upLed_3;
	}

	public String getExpLed_0() {
		return expLed_0;
	}

	public void setExpLed_0(String expLed_0) {
		this.expLed_0 = expLed_0;
	}

	public String getExpLed_1() {
		return expLed_1;
	}

	public void setExpLed_1(String expLed_1) {
		this.expLed_1 = expLed_1;
	}

	public String getExpLed_2() {
		return expLed_2;
	}

	public void setExpLed_2(String expLed_2) {
		this.expLed_2 = expLed_2;
	}

	public String getExpLed_3() {
		return expLed_3;
	}

	public void setExpLed_3(String expLed_3) {
		this.expLed_3 = expLed_3;
	}

	@Override
	public String toString() {
		return "UIComponent{" + "MCU_HEART_BEAT_LED = " + mcuHeartBeatLedInput + ", Fan PWM = " + fanPwmInput
				+ ", Fan TAC=" + fanTacInput + ", Temp Sensor=" + tempSensorInput + ", DPOL - 1.0V=" + dpol1_0VInput
				+ ", DPOL - 1.8V=" + dpol1_8VInput + ", DPOL - 3.3V=" + dpol3_3VInput + ", DPOL - 5.0V=" + dpol5_0VInput 
				+ ", DPOL - 12.0V=" + dpol12_0VInput + ", UP_Input_0=" + upInput_0 + ", UP_Input_1=" + upInput_1
				+ ", UP_Input_2=" + upInput_2 + ", UP_Input_3=" + upInput_3 + '}';
	}

	@Override
	public void update(Object o) {
		this.clientMsg = (VSocClientMsg)o;
		// Print the update changes	
		System.out.println("*** update::State Change '" + this.clientMsg.toMsgString() + "'");
		// Push to the Service Class and let it process the state change
		this.vSocService.addOutputStateChanges(this.clientMsg);
	}
	
	public String getName() {
		return this.clientMsg.getName();
	}
	
	public String getType() {
		return this.clientMsg.getType();
	}
	public String getValue() {
		return this.clientMsg.getValue();
	}

}