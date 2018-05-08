package com.stthomas.seis.vsoc.gui;


import static org.junit.Assert.*;

import org.junit.Test;

import com.stthomas.seis.vsoc.client.VSocClientMsg;
import org.junit.Before;


public class VSocClientMsgTest {

	private VSocClientMsg clientMsg;
	
	@Before
	public void test_setup() {
		this.clientMsg = new VSocClientMsg("TestName", "TestType", "TestValue");
	}
	
	@Test
	public void testGetters() {
		String name = this.clientMsg.getName();
		assertTrue("Message Name is not TestName",
				   (name.equals("TestName")));	
		
		String type = this.clientMsg.getType();
		assertTrue("Message Type is not TestType",
				   (type.equals("TestType")));
		
		String value = this.clientMsg.getValue();
		assertTrue("Message Value is not TestValue",
				   (value.equals("TestValue")));	
		
	}
	
	@Test
	public void testSetters() {
		this.clientMsg.setName("TestName2");
		this.clientMsg.setType("TestType2");
		this.clientMsg.setValue("TestValue2");
		
		String name = this.clientMsg.getName();
		assertTrue("Message Name is not TestName2",
				   (name.equals("TestName2")));	
		
		String type = this.clientMsg.getType();
		assertTrue("Message Type is not TestType2",
				   (type.equals("TestType2")));
		
		String value = this.clientMsg.getValue();
		assertTrue("Message Value is not TestValue2",
				   (value.equals("TestValue2")));		
	}
	
	@Test
	public void testToString() {
		this.clientMsg.setName("IO Name");
		this.clientMsg.setType("IO Type");
		this.clientMsg.setValue("IO Value");
		
		String msg = this.clientMsg.toMsgString();
		assertTrue("Message ToString is not <IO Name>:<IO Type>:<IO Value>",
				   (msg.equals("<IO Name>:<IO Type>:<IO Value>")));
	
	}

}
