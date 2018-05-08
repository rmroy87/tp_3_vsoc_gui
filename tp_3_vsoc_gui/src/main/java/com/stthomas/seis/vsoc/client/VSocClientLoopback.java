package com.stthomas.seis.vsoc.client;

import com.stthomas.seis.vsoc.gui.model.VSocUI;

//import com.stthomas.seis.vsoc.gui.observer.VSocObserver;

public class VSocClientLoopback extends VSocClientConnection {
	
	public VSocClientLoopback(VSocUI theObserver) {
		this.setObserver(theObserver);
		this.setLastMsgGood(false);
		
		this.setConnected(true);
	}
	
	public boolean sendInputMsg(VSocClientMsg theMsg) throws Exception {
		boolean rc = false;
		
		if(this.getConnected() == true) {
			this.setLastSentMsg(theMsg);
			this.setLastMsgGood(true);
			
			rc = true;
		}
		
		return rc;
	}
	
	public void processOutputMsg()  throws Exception{		
		if( (this.getConnected() == true) && 
			(this.getLastMsgGood() == true)) {
			
			this.getObserver().update(this.getLastMsgSent());
			this.setLastMsgGood(false);
		}
	}
	
	public boolean loopbackMsgPending() {
		boolean rc = false;
		
		if(this.getConnected() == true) {
			rc = this.getLastMsgGood();
		}
		return rc;
	}
	
	public VSocClientMsg getLastMsgSent() {
		VSocClientMsg rc = null;
		
		if(this.getConnected() == true) {
			rc = this.getLastSentMsg();
		}
		
		return rc;
	}
	
	public void closeConnection() {
		this.setConnected(false);
	}		
}
