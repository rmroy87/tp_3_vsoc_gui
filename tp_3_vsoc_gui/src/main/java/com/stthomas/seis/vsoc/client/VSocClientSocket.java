package com.stthomas.seis.vsoc.client;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

//import com.stthomas.seis.vsoc.gui.observer.VSocObserver;

public class VSocClientSocket extends VSocClientConnection {
	
	private InputStream sockInput;
	private Socket 		socket;
	
	
	public VSocClientSocket(VSocDummyObserver theObserver, InetAddress serverAddress, int serverPort) {
				
		this.SetServerAddress(serverAddress);
		this.SetServerPortNumber(serverPort);
		this.SetObserver(theObserver);   
		
		try {
			this.CreateSocket();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
    }
	
	private void CreateSocket() throws Exception {
		InetAddress test;
		
		this.socket = new Socket(this.GetServerAddress(), this.GetServerPortNumber());
     	
        test = this.socket.getInetAddress();
        
        if(test != null) {
        	this.sockInput = this.socket.getInputStream();    
        	this.SetConnected(true);
        }else {
        	this.SetConnected(false);
        }
		
	}
	
	//
	// This is used to send an INPUT from the GUI, that is headed to the server, so while
	// it looks like an output from this interface, it is really from inputed data from
	// the GUI
	//
	public boolean SendInputMsg(VSocClientMsg theMsg) throws Exception {
		
		if(this.GetConnected() == true) {
			OutputStream os = this.socket.getOutputStream();
	        OutputStreamWriter osw = new OutputStreamWriter(os);
	        BufferedWriter bw = new BufferedWriter(osw);
	        
	        bw.write(theMsg.ToMsgString());
	        bw.flush();
		}
		
		return this.GetConnected();
	}
	//
	// This is used to send a OUTPUT from the SERVER, that is headed to the GUI, so while
	// it looks like an input from this interface, it is really from outputed data from
	// the server going to the GUI
	//
	public void ProcessOutputMsg()  throws Exception {		
		int bytesRead = 0;
    	byte[] buf = new byte[1024];
    	
      	
    	this.sockInput = this.socket.getInputStream();
    	
    	bytesRead = this.sockInput.read(buf, 0, buf.length);
    	
    	//String output = new String(buf, 0, bytesRead);
    	
    	ProcessMessageBuffer(buf, bytesRead);
    	//consoleIn.DisplayMsg("InputMsg: Received "+ bytesRead
        //        + " bytes: " + output, true);   
	}
	
	private VSocClientMsg ProcessVSocMsg(byte[] rawMsg, int msgLen) {
		int i;
		int j=0;
		int element = 0;
		boolean started = false;
		byte[] temp = new byte[80];		
		String[] elementStrs = new String[3];
		VSocClientMsg parseMsg = null;
		//
		// First parse the array and extract the three elements
		// of the message.
		//
		// Format: <IO Name>:<IO Type>:<IO Value>"
		for(i=0;i<msgLen;i++) {
			if(rawMsg[i] == '<') {
				// Start of element
				j=0;
				started = true;
			}else if(rawMsg[i] == '>') {
				// End of element
				if(element < 3) {
					elementStrs[element] = new String(temp, 0, j);
					element++;
				}
				started = false;
			}else {
				if((j < 80) && (started == true)) {
					// element data
					temp[j] = rawMsg[i];
					j++;
				}
			}
		}
		
		//
		// If we have all three elements, create the object
		if(element == 3) {
			parseMsg = new VSocClientMsg(elementStrs[0], elementStrs[1], elementStrs[2]);
		}
		
		return parseMsg;
		
	}
	
	private int ProcessMessageBuffer(byte[] buff, int bufLen) {
    	int count = 0;
    	boolean done = false;
    	int buffIndex = 0;
    	int outIndex;
    	byte[] oneMsg = new byte[256];
       	int left;
    	int right;
    	VSocClientMsg parseMsg;
    	
    	while(done == false) {
    		//
    		// Search for the first '<'
    		//
    		while((buff[buffIndex] != '<') && (bufLen > 0 )) {
    			buffIndex++;
    			bufLen--;
    		}
    		
    		if(bufLen != 0) {
    			outIndex = 0;
    			left = 3;
    			right = 3;
    			
    			while(bufLen > 0) {
    				if(buff[buffIndex] == '<') {
    					left--;
    					if(left < 0) {
    						count = -1; 
    						done = true;
    						break;
    					}
    				}else if(buff[buffIndex] == '>') {
    					right--;
    					
    				}
    				oneMsg[outIndex] = buff[buffIndex];
    				outIndex++;
    				buffIndex++;
    				bufLen--;
    				
    				if((right == 0) && (left == 0)) {
    					count++;
    					//
    					// Got a good message, if so, send to observer
    					parseMsg = ProcessVSocMsg(oneMsg, outIndex);   			    	
    			    	if(parseMsg != null) {
    			    		this.GetObserver().update(parseMsg);
    			    	}
    			    	
    			    	if(bufLen <= 0) {
    			    		done = true; 
    			    	}else {
    			    		break; /* Next Message */
    			    	}
    				}
    			}
    			
    		}else {
    			done = true;;
    		}
    	}
    	
    	return count;	
	}
}
