package com.stthomas.seis.vsoc.gui;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;

import com.stthomas.seis.vsoc.gui.model.VSocUI;
import com.stthomas.seis.vsoc.gui.observer.VSocObserver;
import com.stthomas.seis.vsoc.gui.service.VSocService;

public class VSocServiceTest {
	
	private VSocService service;
	
//	@Mock
//	private VSocUI ui;
//	
	@Mock
	private VSocObserver observer;
	
	@Before
	public void setup() {
		service = new VSocService();
	}

	@Test
	public void testRegisterNewState() {
		VSocUI ui = new VSocUI();
    		service.registerObserver(ui);
        // A change in component state notifies the registered observers
		ui.setTempSensorInput("68");
		List<VSocObserver> observers = service.registerNewState(ui);
		assertTrue(((VSocUI)observers.get(0)).getTempSensorInput() != null 
				&& "68".equalsIgnoreCase(((VSocUI)observers.get(0)).getTempSensorInput())); 
	}
	
	@Test
	public void testRegisterObserver() {
		service.registerObserver(observer);
		System.out.println(">>>>> Test size: " +service.getObeservers().size());
		assertTrue(service.getObeservers() != null && service.getObeservers().size() > 0);
	}
	
	@Test
	public void testRemoveObserver() {
		service.removeObserver(observer);
		System.out.println(">>>>> Test size: " +service.getObeservers().size());
		assertTrue(service.getObeservers() != null && service.getObeservers().size() <= 0);
	}
	
}
