package com.stthomas.seis.vsoc.gui;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.stthomas.seis.vsoc.gui.model.TemperatureSensor;

public class test_temperatureSensor {
	
	private TemperatureSensor temp;

	@Before
	public void test_setup() 
	{
		temp = new TemperatureSensor();
	}
	
	@Test
	public void test_setTemperature()
	{
		temp.setTemperature("123");
		assertEquals("123", temp.getTemperature());
	}
	
	@Test
	public void test_setManualInput()
	{
		temp.setManualInput("123");
		assertEquals("123", temp.getManualInput());
	}
	
	@Test
	public void test_ConfigureInput()
	{
		temp.setConfiguredInput("GPIOA");
		assertEquals("GPIOA", temp.getConfiguredInput());
	}
	
	@Test
	public void test_getName()
	{
		assertEquals("TEMP_SENSOR_1",temp.getName());
	}
	
	@Test
	public void test_getType()
	{
		assertEquals("Integer", temp.getType());
	}
	
	@Test
	public void test_getValue()
	{
		temp.setTemperature("123");
		assertEquals("123",temp.getTemperature());
	}

}
