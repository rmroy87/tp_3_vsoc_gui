package com.stthomas.seis.vsoc.gui.model;

/**
 * 
 * General Purpose Outputs
 */
public class GPO {
	
	private int[] up_LED_array;
	private int[] exp_LED_array;
	
	private int up_LED_max = 4;
	private int exp_LED_max = 4;
	
	public GPO()
	{
		up_LED_array = new int[up_LED_max];
		exp_LED_array = new int[exp_LED_max];
		
	}
	
	public void setUpOutputPin(int pin_num, int status )
	{
		if(pin_num < up_LED_max)
		{
			up_LED_array[pin_num] = status;
		}
	}
	
	public int getUpOutputPin(int pin_num)
	{
		return up_LED_array[pin_num];
	}
	
	public void setExpOutputPin(int pin_num, int status )
	{
		if(pin_num < exp_LED_max)
		{
			exp_LED_array[pin_num] = status;
		}
	}
	
	public int getExpOutputPin(int pin_num)
	{
		return exp_LED_array[pin_num];
	}
	
//	private String up_LED_0;
//	private String up_LED_1;
//	private String up_LED_2;
//	private String up_LED_3;
//	
//	private String exp_LED_0;
//	private String exp_LED_1;
//	private String exp_LED_2;
//	private String exp_LED_3;
	
	
//	public String getUp_LED_0() {
//		return up_LED_0;
//	}
//	public void setUp_LED_0(String up_LED_0) {
//		this.up_LED_0 = up_LED_0;
//	}
//	public String getUp_LED_1() {
//		return up_LED_1;
//	}
//	public void setUp_LED_1(String up_LED_1) {
//		this.up_LED_1 = up_LED_1;
//	}
//	public String getUp_LED_2() {
//		return up_LED_2;
//	}
//	public void setUp_LED_2(String up_LED_2) {
//		this.up_LED_2 = up_LED_2;
//	}
//	public String getUp_LED_3() {
//		return up_LED_3;
//	}
//	public void setUp_LED_3(String up_LED_3) {
//		this.up_LED_3 = up_LED_3;
//	}
//	public String getExp_LED_0() {
//		return exp_LED_0;
//	}
//	public void setExp_LED_0(String exp_LED_0) {
//		this.exp_LED_0 = exp_LED_0;
//	}
//	public String getExp_LED_1() {
//		return exp_LED_1;
//	}
//	public void setExp_LED_1(String exp_LED_1) {
//		this.exp_LED_1 = exp_LED_1;
//	}
//	public String getExp_LED_2() {
//		return exp_LED_2;
//	}
//	public void setExp_LED_2(String exp_LED_2) {
//		this.exp_LED_2 = exp_LED_2;
//	}
//	public String getExp_LED_3() {
//		return exp_LED_3;
//	}
//	public void setExp_LED_3(String exp_LED_3) {
//		this.exp_LED_3 = exp_LED_3;
//	}
	
	
	
	
}
