package com.stthomas.seis.vsoc.gui;

import static org.junit.Assert.*;

import java.net.InetAddress;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

import com.stthomas.seis.vsoc.client.VSocClientSocket;
import com.stthomas.seis.vsoc.client.VSocClientMsg;
import com.stthomas.seis.vsoc.client.VSocDummyObserver;

public class VSocClientSocketTest {

	private VSocClientSocket client;
	private VSocDummyObserver clientObserver;
		
	@Before
	public void test_setup() throws Exception{
		
		VSocClientMsg clientMsg = new VSocClientMsg("LOOPBACK_IO_INTFC", "INTEGER", "1" );
		
		System.out.println("test_setup");
		this.clientObserver = new VSocDummyObserver();		
		this.client = new VSocClientSocket(	this.clientObserver,
											InetAddress.getByName("127.0.0.1"), 
											Integer.parseInt("7010"));
		
		//
		// Slight delay to allow the connection to be established
		TimeUnit.SECONDS.sleep(5);
		assertTrue("Must Have Server Connection", this.client.GetConnected());
		
		//
		// Put the Server into a Loopback mode on its end
		this.client.SendInputMsg(clientMsg);
		
		TimeUnit.SECONDS.sleep(2);	
	}
		
	
	@Test
	public void test_all() throws Exception{
		
		VSocClientMsg clientMsg = new VSocClientMsg("Send_Name", "STRING", "SendValue" );
		VSocClientMsg closedMsg = null;
		VSocClientMsg sentMsg;
		boolean ec;
		
		System.out.println("test_send_msg");
		assertTrue("Client Connected", this.client.GetConnected());	
		
		this.client.SendInputMsg(clientMsg);
		TimeUnit.SECONDS.sleep(2);		
		
		assertTrue("Msg Sent", client.GetLastMsgGood());	
		
		sentMsg = client.GetLastMsgSent();
		assertTrue("Last Msg Sent not Match", clientMsg == sentMsg);
		
		TimeUnit.SECONDS.sleep(2);	
		
		this.client.ProcessOutputMsg();
		
		VSocClientMsg clientMsg2 = new VSocClientMsg("Client_Name", "STRING", "ClientValue" );
		
		System.out.println("test_send_recv");
		assertTrue("Client Connected", this.client.GetConnected());	
		
		ec = this.client.SendInputMsg(clientMsg2);
		assertTrue("Last Msg Sent Fail", ec == true);
		TimeUnit.SECONDS.sleep(2);
		
		this.client.ProcessOutputMsg();
		
		assertTrue("Observer Name is Client_Name ", this.clientObserver.GetName().equals("Client_Name"));
		assertTrue("Observer Type is STRING ", this.clientObserver.GetType().equals("STRING"));
		assertTrue("Observer Value is ClientValue ", this.clientObserver.GetValue().equals("ClientValue"));	
		
		System.out.println("test_disconnected");
		assertTrue("Client Connected", client.GetConnected());
		client.CloseConnection();
		assertFalse("Client DisConnected", client.GetConnected());
		
		closedMsg = client.GetLastMsgSent();
		assertTrue("Get Last Msg Sent Fail", closedMsg == null);
		
		ec = this.client.SendInputMsg(clientMsg2);
		assertTrue("Last Msg Sent Fail", ec == false);
	}

}
