package com.stthomas.seis.vsoc.gui;

import static org.junit.Assert.*;

import org.junit.Test;

import com.stthomas.seis.vsoc.gui.model.VSocUI;

public class VSocUITest 
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
	
	@Test 
	public void test_dpol3v3Input()
	{
		vsocui = new VSocUI();
		vsocui.setDpol3_3VInput("2.5");
		assertEquals("2.5", vsocui.getDpol3_3VInput());
	}
	
	@Test 
	public void test_dpol5v5Input()
	{
		vsocui = new VSocUI();
		vsocui.setDpol5_0VInput("5.0");
		assertEquals("5.0", vsocui.getDpol5_0VInput());
	}
	
	@Test
	public void test_dpol12_0Input()
	{
		vsocui = new VSocUI();
		vsocui.setDpol12_0VInput("12.0");
		assertEquals("12.0",  vsocui.getDpol12_0VInput());
	}
	
	@Test
	public void test_dpol1_0VInput()
	{
		vsocui = new VSocUI();
		vsocui.setDpol1_0VInput("1");
		assertEquals("1", vsocui.getDpol1_0VInput());
	}
	
	@Test
	public void test_dpol1_8Input()
	{
		vsocui = new VSocUI();
		vsocui.setDpol1_8VInput("1.8");
		assertEquals("1.8", vsocui.getDpol1_8VInput());
	}
	
	@Test
	public void test_Input0()
	{
		vsocui = new VSocUI();
		vsocui.setUpInput_0("on");
		assertEquals("on", vsocui.getUpInput_0());
	}
	
	@Test
	public void test_Input1()
	{
		vsocui = new VSocUI();
		vsocui.setUpInput_1("on");
		assertEquals("on", vsocui.getUpInput_1());
	}
	
	@Test
	public void test_Input2()
	{
		vsocui = new VSocUI();
		vsocui.setUpInput_2("on");
		assertEquals("on", vsocui.getUpInput_2());
	}
	
	@Test
	public void test_Input3()
	{
		vsocui = new VSocUI();
		vsocui.setUpInput_3("on");
		assertEquals("on", vsocui.getUpInput_3());
	}
	
	@Test
	public void test_ExpInput0()
	{
		vsocui = new VSocUI();
		vsocui.setExpInput_0("on");
		assertEquals("on", vsocui.getExpInput_0());
	}
	
	@Test
	public void test_ExpInput1()
	{
		vsocui = new VSocUI();
		vsocui.setExpInput_1("on");
		assertEquals("on", vsocui.getExpInput_1());
	}
	
	@Test
	public void test_ExpInput2()
	{
		vsocui = new VSocUI();
		vsocui.setExpInput_2("on");
		assertEquals("on", vsocui.getExpInput_2());
	}
	
	@Test
	public void test_ExpInput3()
	{
		vsocui = new VSocUI();
		vsocui.setExpInput_3("on");
		assertEquals("on", vsocui.getExpInput_3());
	}
	
	@Test
	public void test_UpLED0()
	{
		vsocui = new VSocUI();
		vsocui.setUpLed_0("on");
		assertEquals("on", vsocui.getUpLed_0());
	}
	
	@Test
	public void test_UpLED1()
	{
		vsocui = new VSocUI();
		vsocui.setUpLed_1("on");
		assertEquals("on", vsocui.getUpLed_1());
	}
	
	@Test
	public void test_UpLED2()
	{
		vsocui = new VSocUI();
		vsocui.setUpLed_2("on");
		assertEquals("on", vsocui.getUpLed_2());
	}
	
	@Test
	public void test_UpLED3()
	{
		vsocui = new VSocUI();
		vsocui.setUpLed_3("on");
		assertEquals("on", vsocui.getUpLed_3());
	}
	
	@Test
	public void test_ExpLED0()
	{
		vsocui = new VSocUI();
		vsocui.setExpLed_0("on");
		assertEquals("on", vsocui.getExpLed_0());
	}
	
	@Test
	public void test_ExpLED1()
	{
		vsocui = new VSocUI();
		vsocui.setExpLed_1("on");
		assertEquals("on", vsocui.getExpLed_1());
	}
	
	@Test
	public void test_ExpLED2()
	{
		vsocui = new VSocUI();
		vsocui.setExpLed_2("on");
		assertEquals("on", vsocui.getExpLed_2());
	}
	
	@Test
	public void test_ExpLEDt3()
	{
		vsocui = new VSocUI();
		vsocui.setExpLed_3("on");
		assertEquals("on", vsocui.getExpLed_3());
	}
	
	@Test
	public void test_toString()
	{
		vsocui = new VSocUI();
		vsocui.setMcuHeartBeatLedInput("on");
		vsocui.setExpLed_1("on");
		vsocui.toString();
	}
	
}
