package com.stthomas.seis.vsoc.gui;

import static org.junit.Assert.*;

//import com.stthomas.seis.vsoc.gui.observer.VSocObserver;
import com.stthomas.seis.vsoc.client.VSocClientLoopback;
import com.stthomas.seis.vsoc.client.VSocClientMsg;
import com.stthomas.seis.vsoc.client.VSocDummyObserver;

import org.junit.Test;

public class VSocClientLoopbackTest {
		
	@Test
	public void test_connected() throws Exception {
		VSocDummyObserver  clientObserver = new VSocDummyObserver();
		VSocClientLoopback clientLB = new VSocClientLoopback(clientObserver);
		
		assertTrue("Client Loopback Connected", clientLB.GetConnected());
	}
	
	@Test
	public void test_disconnected() throws Exception {
		VSocDummyObserver  clientObserver = new VSocDummyObserver();
		VSocClientLoopback clientLB = new VSocClientLoopback(clientObserver);
		
		assertTrue("Client Loopback Connected", clientLB.GetConnected());
		clientLB.CloseConnection();
		assertFalse("Client Loopback Disconnected", clientLB.GetConnected());
	}
	
	@Test
	public void test_process_output_message() throws Exception {
		VSocDummyObserver  clientObserver = new VSocDummyObserver();
		VSocClientLoopback clientLB = new VSocClientLoopback(clientObserver);
		VSocClientMsg clientMsg = new VSocClientMsg("LB_Name", "STRING", "LBValue" );
			
		clientLB.ProcessOutputMsg();	
		assertTrue("Send Input Msg", clientLB.SendInputMsg(clientMsg));
		clientLB.ProcessOutputMsg();
		assertFalse("Loopback Msg Not Pending", clientLB.LoopbackMsgPending());		
		
		assertTrue("Observer Name is LB_Name ", clientObserver.GetName().equals("LB_Name"));
		assertTrue("Observer Type is STRING ", clientObserver.GetType().equals("STRING"));
		assertTrue("Observer Value is LBValue ", clientObserver.GetValue().equals("LBValue"));
		
		clientLB.ProcessOutputMsg();
		assertTrue("Observer Name is LB_Name ", clientObserver.GetName().equals("LB_Name"));
		assertTrue("Observer Type is STRING ", clientObserver.GetType().equals("STRING"));
		assertTrue("Observer Value is LBValue ", clientObserver.GetValue().equals("LBValue"));
		
		clientLB.CloseConnection();
		clientLB.ProcessOutputMsg();	
		assertTrue("Observer Name is LB_Name ", clientObserver.GetName().equals("LB_Name"));
		assertTrue("Observer Type is STRING ", clientObserver.GetType().equals("STRING"));
		assertTrue("Observer Value is LBValue ", clientObserver.GetValue().equals("LBValue"));
	}
	
	
	@Test
	public void test_not_connected() throws Exception {
		VSocDummyObserver  clientObserver = new VSocDummyObserver();
		VSocClientLoopback clientLB = new VSocClientLoopback(clientObserver);
		VSocClientMsg clientMsg = new VSocClientMsg("LB_Name", "STRING", "LBValue" );
		VSocClientMsg lastMsg = null;
		
		clientLB.CloseConnection();
		
		assertFalse("Loopback Msg Pending", clientLB.LoopbackMsgPending());
		assertFalse("Send Input Msg", clientLB.SendInputMsg(clientMsg));
		lastMsg = clientLB.GetLastMsgSent();
		assertTrue("Last Msg Sent", lastMsg == null);
		
		clientLB.ProcessOutputMsg();		
	}
	

	@Test
	public void test_send_msg() throws Exception {
		VSocDummyObserver  clientObserver = new VSocDummyObserver();
		VSocClientLoopback clientLB = new VSocClientLoopback(clientObserver);
		
		VSocClientMsg clientMsg = new VSocClientMsg("LB_Name", "STRING", "LBValue" );
		
		assertTrue("Client Loopback Connected", clientLB.GetConnected());	
		
		clientLB.SendInputMsg(clientMsg);		
		assertTrue("Msg Sent", clientLB.GetLastMsgGood());
		assertTrue("Loopback Msg Pending", clientLB.LoopbackMsgPending());		
	}
	
	@Test
	public void test_last_msg_sent() throws Exception {
		VSocDummyObserver  clientObserver = new VSocDummyObserver();
		VSocClientLoopback clientLB = new VSocClientLoopback(clientObserver);
		
		VSocClientMsg clientMsg = new VSocClientMsg("LB_Name", "STRING", "LBValue" );
		VSocClientMsg sentMsg;
		
		assertTrue("Client Loopback Connected", clientLB.GetConnected());	
		
		clientLB.SendInputMsg(clientMsg);		
		
		assertTrue("Msg Sent", clientLB.GetLastMsgGood());
		assertTrue("Loopback Msg Pending", clientLB.LoopbackMsgPending());
		sentMsg = clientLB.GetLastMsgSent();
		assertTrue("Last Msg Sent not Match", clientMsg == sentMsg);		
	}
	
	@Test
	public void test_ProcessPut_msg() throws Exception {
		VSocDummyObserver  clientObserver = new VSocDummyObserver();
		VSocClientLoopback clientLB = new VSocClientLoopback(clientObserver);
		VSocClientMsg clientMsg = new VSocClientMsg("LB_Name", "STRING", "LBValue" );
		
		assertTrue("Client Loopback Connected", clientLB.GetConnected());	
		
		clientLB.SendInputMsg(clientMsg);
		assertTrue("Msg Sent", clientLB.GetLastMsgGood());
		assertTrue("Loopback Msg Pending", clientLB.LoopbackMsgPending());
		
		clientLB.ProcessOutputMsg();
		assertFalse("Loopback Msg Not Pending", clientLB.LoopbackMsgPending());		
				
		assertTrue("Observer Name is LB_Name ", clientObserver.GetName().equals("LB_Name"));
		assertTrue("Observer Type is STRING ", clientObserver.GetType().equals("STRING"));
		assertTrue("Observer Value is LBValue ", clientObserver.GetValue().equals("LBValue"));
	}
}
