package com.stthomas.seis.vsoc.client;

import com.stthomas.seis.vsoc.gui.observer.VSocObserver;

public class VSocDummyObserver implements VSocObserver {

	private VSocClientMsg clientMsg;
	
	public VSocDummyObserver() {
		
	}
	public void dummyupdate(VSocClientMsg msg) {
		this.clientMsg = msg;
		
		System.out.print("VSocDummyObserver::update - ");
		System.out.println(this.msgToString());
	}
	
	public String getName() {
		return this.clientMsg.getName();
	}
	
	public String getType() {
		return this.clientMsg.getType();
	}
	public String getValue() {
		return this.clientMsg.getValue();
	}
	public String msgToString() {
		return this.clientMsg.toMsgString();
	}
	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
		dummyupdate((VSocClientMsg)o);
		
	}

}
