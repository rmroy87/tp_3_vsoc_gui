package com.stthomas.seis.vsoc.gui;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.stthomas.seis.vsoc.gui.model.HeartBeatLed;

public class test_heartBeatLed {
	
	private HeartBeatLed led ;
	
	@Before
	public void test_setup() {
		led = new HeartBeatLed();
	}
	
	@Test
	public void test_setLed()
	{
		led.setHeartBeatLedOnAndoff("On");
		assertEquals("On", led.getHeartBeatLedOnAndoff());
	}
	
	@Test
	public void test_setLedOn()
	{
		led.setLedOn();
		assertEquals(true, led.isLedStatusOn());
	}
	
	@Test
	public void test_setLedOff()
	{
		led.setLedOff();
		assertEquals(false, led.isLedStatusOn());
	}
}
