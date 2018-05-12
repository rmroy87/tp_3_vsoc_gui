package com.stthomas.seis.vsoc.gui;

import static org.junit.Assert.*;

//import com.stthomas.seis.vsoc.gui.observer.VSocObserver;
import com.stthomas.seis.vsoc.client.VSocClientLoopback;
import com.stthomas.seis.vsoc.client.VSocClientMsg;
import com.stthomas.seis.vsoc.client.VSocDummyObserver;
import com.stthomas.seis.vsoc.gui.model.VSocUI;

import org.junit.Test;

public class VSocClientLoopbackTest {
		
	@Test
	public void test_connected() throws Exception {
		VSocUI  clientObserver = new VSocUI();
		VSocClientLoopback clientLB = new VSocClientLoopback(clientObserver);
		
		assertTrue("Client Loopback Connected", clientLB.getConnected());
	}
	
	@Test
	public void test_disconnected() throws Exception {
		VSocUI  clientObserver = new VSocUI();
		VSocClientLoopback clientLB = new VSocClientLoopback(clientObserver);
		
		assertTrue("Client Loopback Connected", clientLB.getConnected());
		clientLB.closeConnection();
		assertFalse("Client Loopback Disconnected", clientLB.getConnected());
	}
	
	@Test
	public void test_process_output_message() throws Exception {
		VSocUI  clientObserver = new VSocUI();
		VSocClientLoopback clientLB = new VSocClientLoopback(clientObserver);
		VSocClientMsg clientMsg = new VSocClientMsg("LB_Name2", "STRING", "LBValue2" );
			
		assertTrue("Send Input Msg", clientLB.sendInputMsg(clientMsg));
		clientLB.processOutputMsg();
			
		System.out.println("MSG = " + clientObserver.getName());
		assertFalse("Observer Name is LB_Name ", clientObserver.getName().equals("LB_Name2"));
				
	}
	
	
	@Test
	public void test_not_connected() throws Exception {
		VSocUI  clientObserver = new VSocUI();
		VSocClientLoopback clientLB = new VSocClientLoopback(clientObserver);
		VSocClientMsg clientMsg = new VSocClientMsg("LB_Name", "STRING", "LBValue" );
		VSocClientMsg lastMsg = null;
		
		clientLB.closeConnection();
		
		assertFalse("Loopback Msg Pending", clientLB.loopbackMsgPending());
		assertFalse("Send Input Msg", clientLB.sendInputMsg(clientMsg));
		lastMsg = clientLB.getLastMsgSent();
		assertTrue("Last Msg Sent", lastMsg == null);
		
		clientLB.processOutputMsg();		
	}
	

	@Test
	public void test_send_msg() throws Exception {
		VSocUI  clientObserver = new VSocUI();
		VSocClientLoopback clientLB = new VSocClientLoopback(clientObserver);
		
		VSocClientMsg clientMsg = new VSocClientMsg("LB_Name", "STRING", "LBValue" );
		
		assertTrue("Client Loopback Connected", clientLB.getConnected());	
		
		clientLB.sendInputMsg(clientMsg);		
		assertTrue("Msg Sent", clientLB.getLastMsgGood());
		assertTrue("Loopback Msg Pending", clientLB.loopbackMsgPending());		
	}
	
	@Test
	public void test_last_msg_sent() throws Exception {
		VSocUI  clientObserver = new VSocUI();
		VSocClientLoopback clientLB = new VSocClientLoopback(clientObserver);
		
		VSocClientMsg clientMsg = new VSocClientMsg("LB_Name", "STRING", "LBValue" );
		VSocClientMsg sentMsg;
		
		assertTrue("Client Loopback Connected", clientLB.getConnected());	
		
		clientLB.sendInputMsg(clientMsg);		
		
		assertTrue("Msg Sent", clientLB.getLastMsgGood());
		assertTrue("Loopback Msg Pending", clientLB.loopbackMsgPending());
		sentMsg = clientLB.getLastMsgSent();
		assertTrue("Last Msg Sent not Match", clientMsg == sentMsg);		
	}
	
	//@Test
	//public void test_ProcessPut_msg() throws Exception {
	//	VSocUI  clientObserver = new VSocUI();
	//	VSocClientLoopback clientLB = new VSocClientLoopback(clientObserver);
	//	VSocClientMsg clientMsg = new VSocClientMsg("LB_Name", "STRING", "LBValue" );
		
	//	assertTrue("Client Loopback Connected", clientLB.getConnected());	
		
	//	clientLB.sendInputMsg(clientMsg);
	//	assertTrue("Msg Sent", clientLB.getLastMsgGood());
	//	assertTrue("Loopback Msg Pending", clientLB.loopbackMsgPending());
		
	//	clientLB.processOutputMsg();
	//	assertFalse("Loopback Msg Not Pending", clientLB.loopbackMsgPending());		
				
	//	assertTrue("Observer Name is LB_Name ", clientObserver.getName().equals("LB_Name"));
	//	assertTrue("Observer Type is STRING ", clientObserver.getType().equals("STRING"));
	//	assertTrue("Observer Value is LBValue ", clientObserver.getValue().equals("LBValue"));
	//}
}
