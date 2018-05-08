package com.stthomas.seis.vsoc.client;


public class VSocDummyObserver {

	private VSocClientMsg clientMsg;
	
	public VSocDummyObserver() {
		
	}
	public void update(VSocClientMsg msg) {
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

}
