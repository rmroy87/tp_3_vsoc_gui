package com.stthomas.seis.vsoc.client;

//import com.stthomas.seis.vsoc.gui.observer.VSocObserver;

public class VSocClientLoopback extends VSocClientConnection {

	private VSocClientMsg lastSentMsg;
	private boolean lastMsgGood;
	
	public VSocClientLoopback(VSocDummyObserver theObserver) {
		this.SetObserver(theObserver);
		this.lastMsgGood = false;
		
		this.SetConnected(true);
	}
	public boolean SendInputMsg(VSocClientMsg theMsg) throws Exception {
		this.lastSentMsg = theMsg;
		this.lastMsgGood = true;
		
		return true;
	}
	
	public void ProcessOutputMsg()  throws Exception{		
		if(this.lastMsgGood == true) {
			this.GetObserver().update(lastSentMsg);
			this.lastMsgGood = false;
		}
	}
	
	public boolean LoopbackMsgPending() {
		return this.lastMsgGood;
	}
	
	public VSocClientMsg GetLastMsgSent() {
		return this.lastSentMsg;
	}
		
}
