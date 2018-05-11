package com.stthomas.seis.vsoc.gui.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.stthomas.seis.vsoc.client.VSocClient;
import com.stthomas.seis.vsoc.client.VSocClientMsg;
import com.stthomas.seis.vsoc.gui.model.VSocUI;
import com.stthomas.seis.vsoc.gui.service.VSocService;

@Controller
@RequestMapping(value = "/vsoc")
public class VSocController {
	private static final Logger logger = LoggerFactory.getLogger(VSocController.class);
	
	@Autowired
	private VSocService vSocService;
	private boolean connected = false;
	
	@GetMapping("/readoutputs")
	public ModelAndView readServerOutput()  throws Exception  {
		VSocUI vsocUI = new VSocUI();
		vsocUI.setvSocService(vSocService);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("outputs-info");
		
		//
		// The Socket processing thread will push updates into this list,
		// so synchronize here, process the list and then clear it
		synchronized(vSocService) {
			List<VSocClientMsg> listOutput = vSocService.readOutputs();
			//logger.info("**** readServerOutput invoked - Size: " + listOutput.size());
			for(VSocClientMsg msg:listOutput) {
				//logger.info("***** MSG = " + msg.getName());
				
				switch(msg.getName()) {
					case "MCU_HEART_BEAT_LED":
						vsocUI.setMcuHeartBeatLedInput(msg.getValue());	
						logger.info(">>>>> Heart Beat LED State Change = " + convertBinaryToOnOff(msg.getValue()));
						break;				
					case "EXP_LED_0":
						vsocUI.setExpLed_0(msg.getValue());	
						logger.info(">>>>> EXP LED 0 State Change = " + convertBinaryToOnOff(msg.getValue()));
						break;
					case "EXP_LED_1":
						vsocUI.setExpLed_1(msg.getValue());	
						logger.info(">>>>> EXP LED 1 State Change = " + convertBinaryToOnOff(msg.getValue()));
						break;
					case "EXP_LED_2":
						vsocUI.setExpLed_2(msg.getValue());	
						logger.info(">>>>> EXP LED 2 State Change = " + convertBinaryToOnOff(msg.getValue()));
						break;
					case "EXP_LED_3":
						vsocUI.setExpLed_3(msg.getValue());	
						logger.info(">>>>> EXP LED 3 State Change = " + convertBinaryToOnOff(msg.getValue()));
						break;
					case "UP_LED_0":
						vsocUI.setUpInput_0(msg.getValue());	
						logger.info(">>>>> UP LED 0 State Change = " + convertBinaryToOnOff(msg.getValue()));
						break;
					case "UP_LED_1":
						vsocUI.setUpInput_1(msg.getValue());	
						logger.info(">>>>> UP LED 1 State Change = " + convertBinaryToOnOff(msg.getValue()));
						break;
					case "UP_LED_2":
						vsocUI.setUpInput_2(msg.getValue());	
						logger.info(">>>>> UP LED 2 State Change = " + convertBinaryToOnOff(msg.getValue()));
						break;
					case "UP_LED_3":
						vsocUI.setUpInput_3(msg.getValue());	
						logger.info(">>>>> UP LED 3 State Change = " + convertBinaryToOnOff(msg.getValue()));
						break;
					case "Fan Pwm":
						vsocUI.setFanPwmInput(msg.getValue());	
						logger.info(">>>>> Fan PWM State Change = " + msg.getValue());
						break;
				
				}				
			}
			vSocService.clearOutputs();
		}

		mav.addObject("outputData", vsocUI);

		return mav;
	}
	
	private String convertBinaryToOnOff(String binaryIn) {
		String onOffOut = new String();
		
		if(("1").equals(binaryIn)) {
			onOffOut = "ON";
		}else {
			onOffOut = "OFF";
		}
		return onOffOut;
	}
	
	@GetMapping("/")
	public ModelAndView sendUserInputView()  throws Exception  {
		VSocUI vsocUI = new VSocUI(); 
		vsocUI.setvSocService(vSocService);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("vsoc_ui");
		
		//mav.addObject("vsocUI", new VSocUI());
		mav.addObject("vsocUI", vsocUI);
		mav.addObject("mcuHeartBeatLed_Ind", getMcuHeartBeatLed());
		mav.addObject("fan_tac_EntryTypes", getFan_tac_EntryTypes());
		mav.addObject("temp_sensor_EntryTypes", getTemp_Sensor_EntryTypes());
		
		mav.addObject("dpol1_0_EntryTypes", getDpol1_0_EntryTypes());
		mav.addObject("dpol1_8_EntryTypes", getDpol1_8_EntryTypes());
		mav.addObject("dpol3_3_EntryTypes", getDpol3_3_EntryTypes());
		mav.addObject("dpol5_0_EntryTypes", getDpol5_0_EntryTypes());
		mav.addObject("dpol12_0_EntryTypes", getDpol12_0_EntryTypes());

		mav.addObject("up_input_0_EntryTypes", getUp_Input_0_EntryTypes());
		mav.addObject("up_input_1_EntryTypes", getUp_Input_1_EntryTypes());
		mav.addObject("up_input_2_EntryTypes", getUp_Input_2_EntryTypes());
		mav.addObject("up_input_3_EntryTypes", getUp_Input_3_EntryTypes());

		mav.addObject("exp_input_0_EntryTypes", getExp_Input_0_EntryTypes());
		mav.addObject("exp_input_1_EntryTypes", getExp_Input_1_EntryTypes());
		mav.addObject("exp_input_2_EntryTypes", getExp_Input_2_EntryTypes());
		mav.addObject("exp_input_3_EntryTypes", getExp_Input_3_EntryTypes());

		mav.addObject("up_led_0_EntryTypes", getUp_Led_0_EntryTypes());
		mav.addObject("up_led_1_EntryTypes", getUp_Led_1_EntryTypes());
		mav.addObject("up_led_2_EntryTypes", getUp_Led_2_EntryTypes());
		mav.addObject("up_led_3_EntryTypes", getUp_Led_3_EntryTypes());
		
		mav.addObject("exp_led_0_EntryTypes", getExp_Led_0_EntryTypes());
		mav.addObject("exp_led_1_EntryTypes", getExp_Led_1_EntryTypes());
		mav.addObject("exp_led_2_EntryTypes", getExp_Led_2_EntryTypes());
		mav.addObject("exp_led_3_EntryTypes", getExp_Led_3_EntryTypes());

		System.out.println("***** sendUserInputView - Called *****");
		
		
		// We only need to establis the connection and start the
		// incoming socket thread one time, so check to see if it was done
		// before initializing the connection
		if(this.connected == false) {
			//Get an Singleton instance of VSocClient
			VSocClient vSocClient = VSocClient.getInstance();
			
			//initialize client
			vSocClient.initVSocClient( 	vsocUI, 
										InetAddress.getByName("127.0.0.1"), 
										Integer.parseInt("7010"), 
										true);
			
			//receive data from the client
			vSocClient.start();
			this.connected = vSocClient.clientConnected();
			logger.info(">>>>> " + vSocClient.toString());
			logger.info(">>>>> Client Connection Established");
		}else {
			logger.info(">>>>> Client Connection Exists");
		}
				
		return mav;
	}

	@PostMapping("sendInput")
	public ModelAndView sendUserInput(@Valid VSocUI vsocUI, BindingResult result) throws Exception {
		logger.info(">>>>> Validation Input form.");
		logger.info(">>>>> UI Form = " +vsocUI.toString());
		
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			logger.info(">>>>> Errors while submitting form.");
			mav.setViewName("vsoc_ui");
			mav.addObject("vsocUI", vsocUI);
			return mav;
		}
		
		
		if(this.connected == true) {
			logger.info(">>>>> Client Connected");
			//Get an Singleton instance of VSocClient
			VSocClient vSocClient = VSocClient.getInstance();
			
			//send inputs to the client
			vSocService.sendInputs(vSocClient, vsocUI);
		}else {
			logger.info(">>>>> Client Not Connected");
		}
				
	
		mav.addObject("inputData", vsocUI);
		mav.setViewName("ui-info");
		readServerOutput();
		logger.info(">>>>> Form submitted successfully.");
		return mav;
	}



	private Object getMcuHeartBeatLed() {
		List<String> entryTypes = new ArrayList<>();
		entryTypes.add("ON");
		
		return entryTypes;
	}
	
	private Object getFan_tac_EntryTypes() {
		List<String> entryTypes = new ArrayList<>();
		entryTypes.add("ON");
		
		return entryTypes;
	}

	private Object getTemp_Sensor_EntryTypes() {
		List<String> entryTypes = new ArrayList<>();
		entryTypes.add("ON");
		
		return entryTypes;
	}

	
	private Object getDpol1_0_EntryTypes() {
		List<String> entryTypes = new ArrayList<>();
		entryTypes.add("ON");
		
		return entryTypes;
	}
	
	private Object getDpol1_8_EntryTypes() {
		List<String> entryTypes = new ArrayList<>();
		entryTypes.add("ON");
		
		return entryTypes;
	}
	
	private Object getDpol3_3_EntryTypes() {
		List<String> entryTypes = new ArrayList<>();
		entryTypes.add("ON");
		
		return entryTypes;
	}
	
	private Object getDpol5_0_EntryTypes() {
		List<String> entryTypes = new ArrayList<>();
		entryTypes.add("ON");
		
		return entryTypes;
	}
	
	private Object getDpol12_0_EntryTypes() {
		List<String> entryTypes = new ArrayList<>();
		entryTypes.add("ON");
		
		return entryTypes;
	}


	private Object getUp_Input_0_EntryTypes() {
		List<String> entryTypes = new ArrayList<>();
		entryTypes.add("ON");
		
		return entryTypes;
	}

	private Object getUp_Input_1_EntryTypes() {
		List<String> entryTypes = new ArrayList<>();
		entryTypes.add("ON");
		
		return entryTypes;
	}
	
	private Object getUp_Input_2_EntryTypes() {
		List<String> entryTypes = new ArrayList<>();
		entryTypes.add("ON");
		
		return entryTypes;
	}

	private Object getUp_Input_3_EntryTypes() {
		List<String> entryTypes = new ArrayList<>();
		entryTypes.add("ON");
		
		return entryTypes;
	}

	private Object getExp_Input_0_EntryTypes() {
		List<String> entryTypes = new ArrayList<>();
		entryTypes.add("ON");
		
		return entryTypes;
	}
	private Object getExp_Input_1_EntryTypes() {
		List<String> entryTypes = new ArrayList<>();
		entryTypes.add("ON");
		
		return entryTypes;
	}
	private Object getExp_Input_2_EntryTypes() {
		List<String> entryTypes = new ArrayList<>();
		entryTypes.add("ON");
		
		return entryTypes;
	}
	private Object getExp_Input_3_EntryTypes() {
		List<String> entryTypes = new ArrayList<>();
		entryTypes.add("ON");
		
		return entryTypes;
	}
	
	
	private Object getUp_Led_0_EntryTypes() {
		List<String> entryTypes = new ArrayList<>();
		entryTypes.add("ON");
		
		return entryTypes;
	}
	
	private Object getUp_Led_1_EntryTypes() {
		List<String> entryTypes = new ArrayList<>();
		entryTypes.add("ON");
		
		return entryTypes;
	}
	
	private Object getUp_Led_2_EntryTypes() {
		List<String> entryTypes = new ArrayList<>();
		entryTypes.add("ON");
		
		return entryTypes;
	}
	
	private Object getUp_Led_3_EntryTypes() {
		List<String> entryTypes = new ArrayList<>();
		entryTypes.add("ON");
		
		return entryTypes;
	}
	
	
	private Object getExp_Led_0_EntryTypes() {
		List<String> entryTypes = new ArrayList<>();
		entryTypes.add("ON");
		
		return entryTypes;
	}
	
	private Object getExp_Led_1_EntryTypes() {
		List<String> entryTypes = new ArrayList<>();
		entryTypes.add("ON");
		
		return entryTypes;
	}
	
	private Object getExp_Led_2_EntryTypes() {
		List<String> entryTypes = new ArrayList<>();
		entryTypes.add("ON");
		
		return entryTypes;
	}
	
	private Object getExp_Led_3_EntryTypes() {
		List<String> entryTypes = new ArrayList<>();
		entryTypes.add("ON");
		
		return entryTypes;
	}



	
	
}