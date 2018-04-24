package com.stthomas.seis.vsoc.gui;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.stthomas.seis.vsoc.gui.model.VSocUI;
import com.stthomas.seis.vsoc.gui.observer.VSocObserver;
import com.stthomas.seis.vsoc.gui.service.VSocService;

public class VSocObserverTest {

	@Test
	public void testObserver () {
        // Create the zoo to store animals
		VSocService service = new VSocService();
        // Register an observer to be notified when a state change occurs
		VSocUI ui = new VSocUI();
		service.registerObserver(ui);
        // A change in component state notifies the registered observers
		ui.setMcuHeartBeatLedInput("OFF");
		List<VSocObserver> observers = service.registerNewState(ui);
		assertTrue(observers != null && observers.size() > 0);
		assertTrue(((VSocUI)observers.get(0)).getMcuHeartBeatLedInput() != null 
				&& "OFF".equalsIgnoreCase(((VSocUI)observers.get(0)).getMcuHeartBeatLedInput()));
    }

}
