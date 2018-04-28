package com.stthomas.seis.vsoc.gui;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.stthomas.seis.vsoc.gui.model.GPI;

public class test_gpi {
	
	private GPI gpio = new GPI();
	
	@Before
	public void test_setup() {
		gpio = new GPI();
	}
	
	@Test
	public void test_setUpGPIO()
	{
		for(int i=0; i<4;i++)
		{
			gpio.setUpInputPin(i,0);
			assertEquals(0, gpio.getUpInputPin(i));
			gpio.setUpInputPin(i,1);
			assertEquals(1, gpio.getUpInputPin(i));
		}
		
	}
	
	@Test
	public void test_setExpGPIO()
	{
		for(int i=0; i<4;i++)
		{
			gpio.setExpInputPin(i,0);
			assertEquals(0, gpio.getExpInputPin(i));
			gpio.setExpInputPin(i,1);
			assertEquals(1, gpio.getExpInputPin(i));
		}
		
	}
	
}
