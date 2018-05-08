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

	public void sendInputs(VSocClient vSocClient, VSocUI ui) throws Exception {
		//TODO
		System.out.print(">>>>> Sending message to client...........");
		VSocClientMsg msg = new VSocClientMsg("TEMP_SENSOR_1","INTEGER",ui.getTempSensorInput());
		System.out.print("MSG = " +msg.toMsgString());
		vSocClient.sendVSocMsg(msg);
		System.out.print(">>>>> message sent ...........");
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
} 