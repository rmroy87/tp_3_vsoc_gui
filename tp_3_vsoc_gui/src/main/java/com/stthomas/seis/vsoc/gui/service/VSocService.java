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

	public void sendInputs(VSocClient vSocClient, VSocUI ui) throws Exception {
		System.out.print(">>>>> Sending message to client...........");
		VSocClientMsg msg = new VSocClientMsg("TEMP_SENSOR_1","INTEGER",ui.getTempSensorInput());
		System.out.print("MSG = " +msg.toMsgString());
		vSocClient.sendVSocMsg(msg);
		System.out.print(">>>>> message sent ...........");
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