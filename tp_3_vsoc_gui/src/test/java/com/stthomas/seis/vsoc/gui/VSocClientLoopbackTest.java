package com.stthomas.seis.vsoc.gui;

import static org.junit.Assert.*;

//import com.stthomas.seis.vsoc.gui.observer.VSocObserver;
import com.stthomas.seis.vsoc.client.VSocClientLoopback;
import com.stthomas.seis.vsoc.client.VSocClientMsg;
import com.stthomas.seis.vsoc.client.VSocDummyObserver;

import org.junit.Before;
import org.junit.Test;



public class VSocClientLoopbackTest {

	private VSocClientLoopback clientLB;
	private VSocDummyObserver clientObserver;
	
	@Before
	public void test_setup() {
		this.clientObserver = new VSocDummyObserver();
		this.clientLB = new VSocClientLoopback(this.clientObserver);
	}

	@Test
	public void test_send_msg() throws Exception {
		VSocClientMsg clientMsg = new VSocClientMsg("LB_Name", "LBType", "LBValue" );
		
		assertTrue("Client Loopback Connected", this.clientLB.GetConnected());	
		
		this.clientLB.SendInputMsg(clientMsg);
		
		assertTrue("Loopback Msg Pending", this.clientLB.LoopbackMsgPending());		
	
	}
	
	@Test
	public void test_last_msg_sent() throws Exception {
		VSocClientMsg clientMsg = new VSocClientMsg("LB_Name", "LBType", "LBValue" );
		VSocClientMsg sentMsg;
		
		assertTrue("Client Loopback Connected", this.clientLB.GetConnected());	
		
		this.clientLB.SendInputMsg(clientMsg);
		sentMsg = this.clientLB.GetLastMsgSent();
		
		assertTrue("Last Msg Sent not Match", clientMsg == sentMsg);		
	}
	
	@Test
	public void test_ProcessPut_msg() throws Exception {
		VSocClientMsg clientMsg = new VSocClientMsg("LB_Name", "LBType", "LBValue" );
		
		assertTrue("Client Loopback Connected", this.clientLB.GetConnected());	
		
		this.clientLB.SendInputMsg(clientMsg);
		
		this.clientLB.ProcessOutputMsg();
		assertFalse("Loopback Msg Not Pending", this.clientLB.LoopbackMsgPending());		
				
		assertTrue("Observer Name is LB_Name ", this.clientObserver.GetName().equals("LB_Name"));
		assertTrue("Observer Type is LBType ", this.clientObserver.GetType().equals("LBType"));
		assertTrue("Observer Value is LBValue ", this.clientObserver.GetValue().equals("LBValue"));
	}
	

}
