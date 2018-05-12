package com.stthomas.seis.vsoc.client;

import java.util.ArrayList;

import com.stthomas.seis.vsoc.gui.model.VSocUI;

//import com.stthomas.seis.vsoc.gui.observer.VSocObserver;

public class VSocClientLoopback extends VSocClientConnection {
	
	private ArrayList<VSocClientMsg> hostOutputs;
	private int lastIndex      = 0;
	private int heartBeatCount = 0;
	private VSocClientMsg heartBeat;
	private boolean heartBeatOff = true;
	private boolean firstProcess = true;
	
	
	public VSocClientLoopback(VSocUI theObserver) {
		this.heartBeat = new VSocClientMsg("MCU_HEART_BEAT_LED", "INTEGER", "0");
		this.setObserver(theObserver);
		this.setLastMsgGood(false);
		this.setupHostOutputs();
		this.setConnected(true);
	}
	
	private void setupHostOutputs() {
		hostOutputs = new ArrayList<VSocClientMsg> (20);
		
		hostOutputs.add(new VSocClientMsg("UP_LED_0", "INTEGER", "0"));
		hostOutputs.add(new VSocClientMsg("UP_LED_1", "INTEGER", "0"));
		hostOutputs.add(new VSocClientMsg("UP_LED_2", "INTEGER", "0"));
		hostOutputs.add(new VSocClientMsg("UP_LED_3", "INTEGER", "0"));
		hostOutputs.add(new VSocClientMsg("EXP_LED_0", "INTEGER", "0"));
		hostOutputs.add(new VSocClientMsg("EXP_LED_1", "INTEGER", "0"));
		hostOutputs.add(new VSocClientMsg("EXP_LED_2", "INTEGER", "0"));
		hostOutputs.add(new VSocClientMsg("EXP_LED_3", "INTEGER", "0"));
		
		hostOutputs.add(new VSocClientMsg("UP_LED_0", "INTEGER", "1"));	
		hostOutputs.add(new VSocClientMsg("UP_LED_1", "INTEGER", "1"));		
		hostOutputs.add(new VSocClientMsg("UP_LED_2", "INTEGER", "1"));		
		hostOutputs.add(new VSocClientMsg("UP_LED_3", "INTEGER", "1"));		
		hostOutputs.add(new VSocClientMsg("EXP_LED_0", "INTEGER", "1"));	
		hostOutputs.add(new VSocClientMsg("EXP_LED_1", "INTEGER", "1"));		
		hostOutputs.add(new VSocClientMsg("EXP_LED_2", "INTEGER", "1"));	
		hostOutputs.add(new VSocClientMsg("EXP_LED_3", "INTEGER", "1"));
		
		hostOutputs.add(new VSocClientMsg("Fan Pwm", "INTEGER", "20"));
		hostOutputs.add(new VSocClientMsg("Fan Pwm", "INTEGER", "50"));
		hostOutputs.add(new VSocClientMsg("Fan Pwm", "INTEGER", "75"));
		hostOutputs.add(new VSocClientMsg("Fan Pwm", "INTEGER", "100"));
	}
	
	public boolean sendInputMsg(VSocClientMsg theMsg) throws Exception {
		boolean rc = false;
		
		if(this.getConnected() == true) {
			this.setLastSentMsg(theMsg);
			this.setLastMsgGood(true);
			System.out.println(">>>>> Loopback Msg Sent: " + theMsg.toMsgString());
			rc = true;
		}
		
		return rc;
	}
	
	public void processOutputMsg()  throws Exception{
		int index;
		
		
		if(this.getConnected() == true){
			
			if(firstProcess == true) {
				this.getObserver().update(this.hostOutputs.get(12));
				this.getObserver().update(this.hostOutputs.get(13));
				this.getObserver().update(this.hostOutputs.get(14));
				this.getObserver().update(this.hostOutputs.get(15));
				this.getObserver().update(this.hostOutputs.get(16));
				firstProcess = false;
			}
			
			if(this.heartBeatCount == 5) {
				if(this.heartBeatOff) {
					this.heartBeat.setValue("1");
					this.heartBeatOff = false;
				}else {
					this.heartBeat.setValue("0");
					this.heartBeatOff = true;
				}
				
				this.getObserver().update(this.heartBeat);
				this.heartBeatCount = 0;
			}else {
				do {
					index = (int) (Math.random() * 19 + 1);
				}while(index == this.lastIndex);
				this.lastIndex = index;				
				this.getObserver().update(this.hostOutputs.get(index));
				this.heartBeatCount++;
			}			
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
