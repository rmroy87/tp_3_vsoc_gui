package com.stthomas.seis.vsoc.client;

import java.net.InetAddress;

import javax.validation.Valid;

import com.stthomas.seis.vsoc.gui.model.VSocUI;

//import com.stthomas.seis.vsoc.gui.observer.VSocObserver;

public class VSocClient {

	private VSocClientConnection client;
		
//    public VSocClient(VSocDummyObserver theObserver, InetAddress serverAddress, int serverPort, boolean loopBackMode){
//                
//        if(loopBackMode == false) {
//        	System.out.println("Client Socket: " + serverAddress + " Port: " + serverPort);
//        	this.client = new VSocClientSocket(theObserver, serverAddress, serverPort);
//        }else{
//        	this.client = new VSocClientLoopback(theObserver);
//        }
//    }
	
    public VSocClient(@Valid VSocUI vsocUI, InetAddress serverAddress, int port, boolean loopBackMode) {
    if(loopBackMode == false) {
	    	System.out.println("Client Socket: " + serverAddress + " Port: " + port);
	    		this.client = new VSocClientSocket(vsocUI, serverAddress, port);
	    }else{
	    	this.client = new VSocClientLoopback(vsocUI);
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
