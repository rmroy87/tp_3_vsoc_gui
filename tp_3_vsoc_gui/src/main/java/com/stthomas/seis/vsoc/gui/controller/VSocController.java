package com.stthomas.seis.vsoc.gui.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stthomas.seis.vsoc.gui.model.HeartBeatLed;
import com.stthomas.seis.vsoc.gui.model.VSocUI;
import com.stthomas.seis.vsoc.gui.service.VSocService;

@Controller
@RequestMapping(value = "/vsoc")
public class VSocController {
	private static final Logger logger = LoggerFactory.getLogger(VSocController.class);
	@Autowired
	private VSocService vSocService;

	// inject via application.properties
	@Value("${project.name}")
	private String projectName;
	@Value("${welcome.message}")
	private String message = "This is a School Project";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("projectName", this.projectName);
		model.put("message", this.message);
		return "vsoc_ui";
	}

	@RequestMapping(value = "/processForm", params = "action1", method = RequestMethod.POST)
	public ModelAndView action1() {
		System.out.println(">>>> Action1 block called");
		ModelAndView modelAndView = new ModelAndView("vsoc_ui");
		VSocUI vsocUI = new VSocUI();
		HeartBeatLed hbl = new HeartBeatLed();
		hbl.setHeartBeatLedOnAndoff("ON");
		vsocUI.setHeartBeatLed(hbl);
		modelAndView.addObject("vsocUI", vsocUI);
		
		System.out.println(">>>> Action1 block execution done");
		return modelAndView;
	}

	@RequestMapping(value = "/processForm", params = "action2", method = RequestMethod.POST)
	public void action2() {
		System.out.println(">>>> Action2 block called");
	}

}