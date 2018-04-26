package com.stthomas.seis.vsoc.client;


public class VSocDummyObserver {

	private VSocClientMsg clientMsg;
	
	public VSocDummyObserver() {
		
	}
	public void update(VSocClientMsg msg) {
		this.clientMsg = msg;
		
		System.out.print("VSocDummyObserver::update - ");
		System.out.println(this.MsgToString());
	}
	
	public String GetName() {
		return this.clientMsg.GetName();
	}
	
	public String GetType() {
		return this.clientMsg.GetType();
	}
	public String GetValue() {
		return this.clientMsg.GetValue();
	}
	public String MsgToString() {
		return this.clientMsg.ToMsgString();
	}

}
