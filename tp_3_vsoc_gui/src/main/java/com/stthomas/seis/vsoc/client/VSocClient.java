package com.stthomas.seis.vsoc.client;

import java.net.InetAddress;
import java.util.Timer;
import java.util.TimerTask;

import javax.validation.Valid;

import com.stthomas.seis.vsoc.gui.model.VSocUI;

//import com.stthomas.seis.vsoc.gui.observer.VSocObserver;

public class VSocClient {

	private static final long PERIOD = 1000; //60000;
	private static final long DELAY = 1000;
	
	private VSocClientConnection client;
	private static VSocClient instance;
	private static Object lockObj = new Object();
	private VSocClientTask task;
	private Timer timer;
	
	
	/**
	 * This method create a Singleton instance of VSocClient
	 * <code>getInstance</code>
	 * @return instance VSocClient
	 */
	public static VSocClient getInstance() {
		if(instance == null) {
			synchronized (lockObj) {
				if(instance == null) {
					instance = new VSocClient();
				}
			}
		}
		return instance;
	}
	
    public void initVSocClient(@Valid VSocUI vsocUI, InetAddress serverAddress, int port, boolean loopBackMode) {
	    if(loopBackMode == false) {
		    	//System.out.println(">>>>> initVScocClient Client Socket: " + serverAddress + " Port: " + port);
	    		this.client = new VSocClientSocket(vsocUI, serverAddress, port);
		}else{
	    		this.client = new VSocClientLoopback(vsocUI);
	    }
    }
    
    public String toString() {
    	String connection = new String();
    	connection = "Client Socket: " + this.client.getServerAddress() 
    						+ " Port: " + this.client.getServerPortNumber();
    	
    	return connection;
    }

	public boolean sendVSocMsg(VSocClientMsg theMsg) throws Exception {	
		return this.client.sendInputMsg(theMsg);
    }
    
    public void processVsocMsg() throws Exception {
    		this.client.processOutputMsg();
    }
    
    public boolean clientConnected() {
    		return this.client.getConnected();
    }

    private class VSocClientTask extends TimerTask{
		@Override
		public void run() {
			try {
				processVsocMsg();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
    	
    }
    public void start() throws Exception {
    		getInstance().processVsocMsg();
    		
    		task = new VSocClientTask();
    		
    		timer = new Timer();
    		timer.scheduleAtFixedRate(task, DELAY, PERIOD);
    }
	
}
