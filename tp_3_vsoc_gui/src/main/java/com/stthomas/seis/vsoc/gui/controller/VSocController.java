package com.stthomas.seis.vsoc.gui.controller;

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

import com.stthomas.seis.vsoc.gui.model.VSocUI;
import com.stthomas.seis.vsoc.gui.service.VSocService;

@Controller
@RequestMapping(value = "/vsoc")
public class VSocController {
	private static final Logger logger = LoggerFactory.getLogger(VSocController.class);
	
	@Autowired
	private VSocService vSocService;
	
	
	@GetMapping("/")
	public ModelAndView sendUserInputView() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("vsoc_ui");
		mav.addObject("vsocUI", new VSocUI());
		mav.addObject("mcuHeartBeatLed_Ind", getMcuHeartBeatLed());
		mav.addObject("dpol1_0_EntryTypes", getDpol1_0_EntryTypes());
		mav.addObject("dpol1_8_EntryTypes", getDpol1_8_EntryTypes());
	
		return mav;
	}

	@PostMapping("sendInput")
	public ModelAndView sendUserInput(@Valid VSocUI vsocUI, BindingResult result) {
		logger.info(">>>>> Validation Input form.");
		logger.info(">>>>> UI Form = " +vsocUI.toString());
		
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			logger.info(">>>>> Errors while submitting form.");
			mav.setViewName("vsoc_ui");
			mav.addObject("vsocUI", vsocUI);
			return mav;
		}
		
		vSocService.sendInputs(vsocUI);
		mav.addObject("inputData", vsocUI);
		mav.setViewName("ui-info");
		logger.info(">>>>> Form submitted successfully.");
		return mav;
	}



	private Object getMcuHeartBeatLed() {
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
	

}