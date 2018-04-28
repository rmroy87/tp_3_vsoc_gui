package com.stthomas.seis.vsoc.gui;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.stthomas.seis.vsoc.gui.model.GPO;

public class test_gpo {
	
	private GPO gpo;
	
	@Before
	public void test_setup() {
		 gpo = new GPO();
	}
	
	@Test
	public void test_setUp_output()
	{
		for(int i=0; i<4;i++)
		{
			gpo.setUpOutputPin(i,0);
			assertEquals(0, gpo.getUpOutputPin(i));
			gpo.setUpOutputPin(i,1);
			assertEquals(1, gpo.getUpOutputPin(i));
		}
		
	}
	
	@Test
	public void test_setExp_output()
	{
		for(int i=0; i<4;i++)
		{
			gpo.setExpOutputPin(i,0);
			assertEquals(0, gpo.getExpOutputPin(i));
			gpo.setExpOutputPin(i,1);
			assertEquals(1, gpo.getExpOutputPin(i));
		}
		
	}
}
