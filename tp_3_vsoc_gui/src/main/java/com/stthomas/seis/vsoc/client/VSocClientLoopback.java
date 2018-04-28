package com.stthomas.seis.vsoc.client;

//import com.stthomas.seis.vsoc.gui.observer.VSocObserver;

public class VSocClientLoopback extends VSocClientConnection {
	
	public VSocClientLoopback(VSocDummyObserver theObserver) {
		this.SetObserver(theObserver);
		this.SetLastMsgGood(false);
		
		this.SetConnected(true);
	}
	
	public boolean SendInputMsg(VSocClientMsg theMsg) throws Exception {
		boolean rc = false;
		
		if(this.GetConnected() == true) {
			this.SetLastSentMsg(theMsg);
			this.SetLastMsgGood(true);
			
			rc = true;
		}
		
		return rc;
	}
	
	public void ProcessOutputMsg()  throws Exception{		
		if( (this.GetConnected() == true) && 
			(this.GetLastMsgGood() == true)) {
			
			this.GetObserver().update(this.GetLastMsgSent());
			this.SetLastMsgGood(false);
		}
	}
	
	public boolean LoopbackMsgPending() {
		boolean rc = false;
		
		if(this.GetConnected() == true) {
			rc = this.GetLastMsgGood();
		}
		return rc;
	}
	
	public VSocClientMsg GetLastMsgSent() {
		VSocClientMsg rc = null;
		
		if(this.GetConnected() == true) {
			rc = this.GetLastSentMsg();
		}
		
		return rc;
	}
	
	public void CloseConnection() {
		this.SetConnected(false);
	}
		
}
