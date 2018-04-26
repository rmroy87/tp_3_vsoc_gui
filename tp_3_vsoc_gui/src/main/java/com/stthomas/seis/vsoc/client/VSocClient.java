package com.stthomas.seis.vsoc.client;

import java.net.InetAddress;

//import com.stthomas.seis.vsoc.gui.observer.VSocObserver;

public class VSocClient {

	private VSocClientConnection client;
		
    public VSocClient(VSocDummyObserver theObserver, InetAddress serverAddress, int serverPort, boolean loopBackMode){
                
        if(loopBackMode == false) {
        	System.out.println("Client Socket: " + serverAddress + " Port: " + serverPort);
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
    
    public boolean ClientConnected() {
    	return this.client.GetConnected();
    }
}
