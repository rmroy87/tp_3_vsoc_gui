package com.stthomas.seis.vsoc.client;

import java.net.InetAddress;

import javax.validation.Valid;

import com.stthomas.seis.vsoc.gui.model.VSocUI;

//import com.stthomas.seis.vsoc.gui.observer.VSocObserver;
/*
 * Abstract class for the Client Connection Type
 */
public abstract class VSocClientConnection {

	private @Valid VSocUI observer;
	private boolean      connected;
	private int          serverPortNumber;
	private InetAddress  serverIpAddress;
	private VSocClientMsg lastSentMsg;
	private boolean       lastMsgGood;
	
	public abstract boolean sendInputMsg(VSocClientMsg theMsg) throws Exception ;
	public abstract void processOutputMsg() throws Exception;
		
	public void setObserver(@Valid VSocUI vsocUI) {
		this.observer = vsocUI;
	}
	
	public @Valid VSocUI getObserver() {
		return this.observer;
	}
	
	public boolean getConnected() {
		return this.connected;
	}
	
	public int getServerPortNumber() {
		return this.serverPortNumber;
	}
	
	public InetAddress getServerAddress() {
		return this.serverIpAddress;
	}
	
	public void setConnected(boolean connected) {
		this.connected = connected;
	}
	
	public void setServerPortNumber(int serverPortNumber) {
		this.serverPortNumber = serverPortNumber;
	}
	
	public void setServerAddress(InetAddress serverIPAdress) {
		this.serverIpAddress = serverIPAdress;
	}
	
	public void setLastSentMsg(VSocClientMsg lastMsg) {
		this.lastSentMsg = lastMsg;
	}
	
	public VSocClientMsg getLastSentMsg() {
		return this.lastSentMsg;
	}
	
	public void setLastMsgGood(boolean lastMsg) {
		this.lastMsgGood = lastMsg;
	}
	
	public boolean getLastMsgGood() {
		return this.lastMsgGood;
	}
	
}
