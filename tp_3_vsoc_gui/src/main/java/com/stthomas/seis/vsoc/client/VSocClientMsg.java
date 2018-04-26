package com.stthomas.seis.vsoc.client;

public class VSocClientMsg {
	private String msgName;
	private String msgType;
	private String msgValue;
	
	public VSocClientMsg(String name, String type, String value) {
		this.msgName  = name;
		this.msgType  = type;
		this.msgValue = value;
	}
	
	public String GetName() {
		return this.msgName;
	}
	
	public String GetType() {
		return this.msgType;
	}
	
	public String GetValue() {
		return this.msgValue;
	}	

	public void SetName(String name) {
		this.msgName = name;
	}
	
	public void SetType(String type) {
		this.msgType = type;
	}
	
	public void SetValue(String value) {
		this.msgValue = value;
	}

	public String ToMsgString() {
		String sendMessage = "<" + this.msgName + ">:<" + this.msgType + ">:<" + this.msgValue + ">";
		return sendMessage;
	}
}
