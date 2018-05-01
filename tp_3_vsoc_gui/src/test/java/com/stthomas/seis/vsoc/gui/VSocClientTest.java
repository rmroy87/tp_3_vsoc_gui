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
	
	@Test
	public void test_client_loopback() throws Exception{
		boolean ec = false;
		
		this.clientObserver = new VSocDummyObserver();		
		this.client = new VSocClient(this.clientObserver,
				 					 InetAddress.getByName("127.0.0.1"), 
				 					 Integer.parseInt("7010"),
				 					 true);
		
		TimeUnit.SECONDS.sleep(5);
		
		assertTrue("Client Connected", this.client.ClientConnected());	
				
		VSocClientMsg clientMsg = new VSocClientMsg("LB_Name", "STRING", "LBValue" );
		
		assertTrue("Client Connected", this.client.ClientConnected());			
		
		ec = this.client.SendVSocMsg(clientMsg);
		TimeUnit.SECONDS.sleep(1);	
		assertTrue("Msg Sent - Success", ec);	
		
		this.client.ProcessVsocMsg();
		
		assertTrue("Observer Name is LB_Name ", this.clientObserver.GetName().equals("LB_Name"));
		assertTrue("Observer Type is STRING ", this.clientObserver.GetType().equals("STRING"));
		assertTrue("Observer Value is LBValue ", this.clientObserver.GetValue().equals("LBValue"));		
		
	}

	

	@Test
	public void test_client_socket() throws Exception{
		VSocClientMsg loopBackMsg = new VSocClientMsg("LOOPBACK_IO_INTFC", "INTEGER", "1" );
		boolean ec = false;
		
		this.clientObserver = new VSocDummyObserver();		
		this.client = new VSocClient(this.clientObserver,
				 					 InetAddress.getByName("127.0.0.1"), 
				 					 Integer.parseInt("7010"),
				 					 false);
		
		TimeUnit.SECONDS.sleep(5);
		
		assertTrue("Client Connected", this.client.ClientConnected());	
		//
		// This initial send puts the HOST into a loopback mode
		ec = this.client.SendVSocMsg(loopBackMsg);
		assertTrue("Msg Sent - Success", ec);	
		
		VSocClientMsg clientMsg = new VSocClientMsg("LB_Name", "STRING", "LBValue" );
		
		assertTrue("Client Connected", this.client.ClientConnected());	
		
		
		ec = this.client.SendVSocMsg(clientMsg);
		assertTrue("Msg Sent - Success", ec);
		TimeUnit.SECONDS.sleep(2);			
		
		this.client.ProcessVsocMsg();
		
		assertTrue("Observer Name is LB_Name ", this.clientObserver.GetName().equals("LB_Name"));
		assertTrue("Observer Type is STRING ", this.clientObserver.GetType().equals("STRING"));
		assertTrue("Observer Value is LBValue ", this.clientObserver.GetValue().equals("LBValue"));
		
		
	}

}
