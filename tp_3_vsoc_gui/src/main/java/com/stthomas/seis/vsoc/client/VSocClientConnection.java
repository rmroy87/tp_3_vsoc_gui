package com.stthomas.seis.vsoc.client;

import java.net.InetAddress;

//import com.stthomas.seis.vsoc.gui.observer.VSocObserver;
/*
 * Abstract class for the Client Connection Type
 */
public abstract class VSocClientConnection {

	private VSocDummyObserver observer;
	private boolean      connected;
	private int          serverPortNumber;
	private InetAddress  serverIpAddress;
	private VSocClientMsg lastSentMsg;
	private boolean       lastMsgGood;
	
	public abstract boolean SendInputMsg(VSocClientMsg theMsg) throws Exception ;
	public abstract void ProcessOutputMsg() throws Exception;
		
	public void SetObserver(VSocDummyObserver theObserver) {
		this.observer = theObserver;
	}
	
	public VSocDummyObserver GetObserver() {
		return this.observer;
	}
	
	public boolean GetConnected() {
		return this.connected;
	}
	
	public int GetServerPortNumber() {
		return this.serverPortNumber;
	}
	
	public InetAddress GetServerAddress() {
		return this.serverIpAddress;
	}
	
	public void SetConnected(boolean connected) {
		this.connected = connected;
	}
	
	public void SetServerPortNumber(int serverPortNumber) {
		this.serverPortNumber = serverPortNumber;
	}
	
	public void SetServerAddress(InetAddress serverIPAdress) {
		this.serverIpAddress = serverIPAdress;
	}
	
	public void SetLastSentMsg(VSocClientMsg lastMsg) {
		this.lastSentMsg = lastMsg;
	}
	
	public VSocClientMsg GetLastSentMsg() {
		return this.lastSentMsg;
	}
	
	public void SetLastMsgGood(boolean lastMsg) {
		this.lastMsgGood = lastMsg;
	}
	
	public boolean GetLastMsgGood() {
		return this.lastMsgGood;
	}
	
}
