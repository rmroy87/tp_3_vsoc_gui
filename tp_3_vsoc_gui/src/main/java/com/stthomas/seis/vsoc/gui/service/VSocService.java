package com.stthomas.seis.vsoc.gui.service;


import org.springframework.stereotype.Service;

import com.stthomas.seis.vsoc.gui.model.VSocUI;
@Service
public class VSocService {

	public void sendInputs(VSocUI ui) {
		//TODO
		System.out.print(">>>>> Sending message to client...........");
		System.out.print("MSG = " +ui.toString());
	}	
} 