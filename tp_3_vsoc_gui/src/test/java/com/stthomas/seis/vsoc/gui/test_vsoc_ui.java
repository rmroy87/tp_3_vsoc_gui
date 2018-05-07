package com.stthomas.seis.vsoc.gui;

import static org.junit.Assert.*;

import org.junit.Test;

import com.stthomas.seis.vsoc.gui.model.VSocUI;

public class test_vsoc_ui 
{
	private VSocUI vsocui;

	@Test
	public void test_fanpwm() 
	{
		vsocui = new VSocUI();
		vsocui.setFanPwmInput("10");
		assertEquals("10",vsocui.getFanPwmInput());
		
	}
	
	@Test
	public void test_fantac()
	{
		vsocui = new VSocUI();
		vsocui.setFanTacInput("1000");
		assertEquals("1000",vsocui.getFanTacInput());
	}
	
	@Test
	public void test_tempSensor()
	{
		vsocui = new VSocUI();
		vsocui.setTempSensorInput("25");
		assertEquals("25",vsocui.getTempSensorInput());
	}
	
	@Test
	public void test_mcuHeartBeatLED()
	{
		vsocui = new VSocUI();
		vsocui.setMcuHeartBeatLedInput("on");
		assertEquals("on",vsocui.getMcuHeartBeatLedInput());
	}
	
}
