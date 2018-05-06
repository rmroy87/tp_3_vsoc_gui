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
	
	public String getName() {
		return this.msgName;
	}
	
	public String getType() {
		return this.msgType;
	}
	
	public String getValue() {
		return this.msgValue;
	}	

	public void setName(String name) {
		this.msgName = name;
	}
	
	public void setType(String type) {
		this.msgType = type;
	}
	
	public void setValue(String value) {
		this.msgValue = value;
	}

	public String toMsgString() {
		String sendMessage = "<" + this.msgName + ">:<" + this.msgType + ">:<" + this.msgValue + ">";
		return sendMessage;
	}
}
