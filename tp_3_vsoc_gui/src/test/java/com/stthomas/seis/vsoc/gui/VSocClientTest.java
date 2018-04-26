package com.stthomas.seis.vsoc.gui;

import static org.junit.Assert.*;

import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

import com.stthomas.seis.vsoc.client.VSocDummyObserver;
import com.stthomas.seis.vsoc.client.VSocClient;
import com.stthomas.seis.vsoc.client.VSocClientMsg;

public class VSocClientTest {
	private VSocClient client;
	private VSocDummyObserver clientObserver;
	
	@Before
	public void test_setup() throws Exception{
		VSocClientMsg clientMsg = new VSocClientMsg("LOOPBACK_IO_INTFC", "INTEGER", "1" );
		
		this.clientObserver = new VSocDummyObserver();		
		this.client = new VSocClient(this.clientObserver,
				 					 InetAddress.getByName("127.0.0.1"), 
				 					 Integer.parseInt("7010"),
				 					 false);
		
		TimeUnit.SECONDS.sleep(5);
		
		this.client.SendVSocMsg(clientMsg);
	}

	@Test
	public void test_send() throws Exception{
		
		VSocClientMsg clientMsg = new VSocClientMsg("LB_Name", "STRING", "LBValue" );
		
		assertTrue("Client Connected", this.client.ClientConnected());	
		
		this.client.SendVSocMsg(clientMsg);
		TimeUnit.SECONDS.sleep(2);
		
		this.client.ProcessVsocMsg();
		
		assertTrue("Observer Name is LB_Name ", this.clientObserver.GetName().equals("LB_Name"));
		assertTrue("Observer Type is STRING ", this.clientObserver.GetType().equals("STRING"));
		assertTrue("Observer Value is LBValue ", this.clientObserver.GetValue().equals("LBValue"));
		
		
	}

}
