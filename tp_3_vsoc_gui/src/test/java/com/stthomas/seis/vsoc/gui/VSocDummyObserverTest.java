package com.stthomas.seis.vsoc.gui;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.stthomas.seis.vsoc.client.VSocClientMsg;
import com.stthomas.seis.vsoc.client.VSocDummyObserver;

public class VSocDummyObserverTest {

	private VSocDummyObserver clientObserver;
	private VSocClientMsg clientMsg;
	
	@Before
	public void test_setup(){
		this.clientObserver = new VSocDummyObserver();
		this.clientMsg = new VSocClientMsg("ObsName", "ObsType", "ObsValue" );
	}

	@Test
	public void test_update() {
		this.clientObserver.update(this.clientMsg);
		
		assertTrue("Observer Name is ObsName ", this.clientObserver.GetName().equals("ObsName"));
		assertTrue("Observer Type is ObsType ", this.clientObserver.GetType().equals("ObsType"));
		assertTrue("Observer Value is ObsValue ", this.clientObserver.GetValue().equals("ObsValue"));
		
	}

}
