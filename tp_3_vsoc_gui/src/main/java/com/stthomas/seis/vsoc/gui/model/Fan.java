package com.stthomas.seis.vsoc.gui.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public abstract class Fan {
	@NotNull
	@Size(min = 3, max = 10, message="Input field must be valid digit numbers min = 3, max = 10")
	private String input;
	
}
