package com.stthomas.seis.vsoc.gui.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.stthomas.seis.vsoc.client.VSocClient;
import com.stthomas.seis.vsoc.client.VSocClientMsg;
import com.stthomas.seis.vsoc.gui.model.VSocUI;
import com.stthomas.seis.vsoc.gui.observer.VSocObserver;
@Service
public class VSocService {

	private List<VSocObserver> observers = new ArrayList<VSocObserver>();
	private List<VSocClientMsg> outputStateChanges = new ArrayList<VSocClientMsg>();

	public List<VSocClientMsg> getOutputStateChanges() {
		System.out.println("*** getOutputStateChanges::List OUT Size =  " + outputStateChanges.size() );
		return outputStateChanges;
	}

	private void sendInputMsg(VSocClient vSocClient, String Name, String Type, String Value) throws Exception {
		System.out.println(">>>>> Sending message to client...........");
		
		if(("INTEGER").equalsIgnoreCase(Type)){
			if(("ON").equalsIgnoreCase(Value)) {
				Value = "1";
			}else if(("OFF").equalsIgnoreCase(Value)){
				Value = "0";
			}
		}
		VSocClientMsg msg = new VSocClientMsg(Name,Type, Value);
		System.out.println("MSG = " +msg.toMsgString());
		vSocClient.sendVSocMsg(msg);		
		System.out.println(">>>>> message sent ...........");
	}
	public void sendInputs(VSocClient vSocClient, VSocUI ui) throws Exception {
		System.out.println(">>>>> Sending Inputs to client...........");
		//VSocClientMsg msg = new VSocClientMsg("TEMP_SENSOR_1","INTEGER",ui.getTempSensorInput());
		//System.out.print("MSG = " +msg.toMsgString());
		//vSocClient.sendVSocMsg(msg);
		
		sendInputMsg(vSocClient, "TEMP_SENSOR_1", "INTEGER", ui.getTempSensorInput());
		sendInputMsg(vSocClient, "Fan TAC", "INTEGER", ui.getFanTacInput());
		
		sendInputMsg(vSocClient, "DPOL-  1.0V", "INTEGER", ui.getDpol1_0VInput());
		sendInputMsg(vSocClient, "DPOL-  1.8V", "INTEGER", ui.getDpol1_8VInput());
		sendInputMsg(vSocClient, "DPOL-  3.3V", "INTEGER", ui.getDpol3_3VInput());
		sendInputMsg(vSocClient, "DPOL-  5.0V", "INTEGER", ui.getDpol5_0VInput());
		sendInputMsg(vSocClient, "DPOL- 12.0V", "INTEGER", ui.getDpol12_0VInput());		
		
		sendInputMsg(vSocClient, "UP_INPUT_0", "INTEGER", ui.getUpInput_0());
		sendInputMsg(vSocClient, "UP_INPUT_1", "INTEGER", ui.getUpInput_1());
		sendInputMsg(vSocClient, "UP_INPUT_2", "INTEGER", ui.getUpInput_2());
		sendInputMsg(vSocClient, "UP_INPUT_3", "INTEGER", ui.getUpInput_3());
		
		sendInputMsg(vSocClient, "EXP_INPUT_0", "INTEGER", ui.getExpInput_0());
		sendInputMsg(vSocClient, "EXP_INPUT_1", "INTEGER", ui.getExpInput_1());
		sendInputMsg(vSocClient, "EXP_INPUT_2", "INTEGER", ui.getExpInput_2());
		sendInputMsg(vSocClient, "EXP_INPUT_3", "INTEGER", ui.getExpInput_3());
		
		
		System.out.println(">>>>> Inputs sent ...........");
	}
	
	public List<VSocClientMsg> readOutputs() throws Exception {
		// Get the Array list of client messages
		List<VSocClientMsg> listOutput = getOutputStateChanges();
	
		return listOutput;
	}

    public List<VSocObserver> registerNewState (VSocUI ui) {
        // Add the UI 
        this.observers.add(ui);
        // Notify the observers
        this.notifyObservers(ui);
        return observers;
    }
    
	public void registerObserver (VSocObserver observer) {
        // Add the observer to the list of registered observers
        this.observers.add(observer);
    }
	
	public void removeObserver (VSocObserver observer) {
        // Remove the listener from the list of the registered listeners
        this.observers.remove(observer);
    }
	
	
	protected void notifyObservers (Object o) {
        // Notify each of the observers in the list of registered observers
        this.observers.forEach(observer -> observer.update(o));
    }

	public List<VSocObserver> getObeservers() {
		return this.observers;
	}

	public void setOutputStateChanges(List<VSocClientMsg> newOutputStateChanges) {
		// TODO Auto-generated method stub
		//System.out.println("*** setOutputStateChanges::List IN Size =  " + newOutputStateChanges.size() );
		
		outputStateChanges = newOutputStateChanges;
		//System.out.println("*** setOutputStateChanges::List OUT Size =  " + outputStateChanges.size() );
	}
	
	public void addOutputStateChanges(VSocClientMsg newOutputStateMsg) {
		outputStateChanges.add(newOutputStateMsg);
		//System.out.println("*** addOutputStateChanges::List Size =  " + outputStateChanges.size() );
		
	}

	public void clearOutputs() {
		//System.out.println("*** clearOutputs::List Size =  " + outputStateChanges.size() );
		outputStateChanges.clear();
		//System.out.println("*** clearOutputs::List Size =  " + outputStateChanges.size() );
	}
	
} 