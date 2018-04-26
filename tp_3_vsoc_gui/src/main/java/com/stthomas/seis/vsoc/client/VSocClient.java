package com.stthomas.seis.vsoc.client;

import java.net.InetAddress;

//import com.stthomas.seis.vsoc.gui.observer.VSocObserver;

public class VSocClient {

	private VSocClientConnection client;
		
    private VSocClient(VSocDummyObserver theObserver, InetAddress serverAddress, int serverPort, boolean loopBackMode){
                
        if(loopBackMode == false) {
        	this.client = new VSocClientSocket(theObserver, serverAddress, serverPort);
        }else{
        	this.client = new VSocClientLoopback(theObserver);
        }
    }
	
    public boolean SendVSocMsg(VSocClientMsg theMsg) throws Exception {	
    	return this.client.SendInputMsg(theMsg);
    }
    
    public void ProcessVsocMsg() throws Exception {
    	this.client.ProcessOutputMsg();
    }	
}
