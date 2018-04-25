package com.stthomas.seis.vsoc.gui.model;
/**
 * Generation Purpose Inputs
 */
public class GPI {

//	private String up_Input_0;
//	private String up_Input_1;
//	private String up_Input_2;
//	private String up_Input_3;
//	
//	private String exp_Input_0;
//	private String exp_Input_1;
//	private String exp_Input_2;
//	private String exp_Input_3;
	
	private int[] pin_up_array;
	private int[] pin_exp_array;
	
	private int pin_up_max = 4;
	private int pin_exp_max = 4;
	
	public GPI()
	{
		pin_up_array = new int[pin_up_max];
		pin_exp_array = new int[pin_exp_max];
	}
	
//	public String getUp_Input_0() {
//		return up_Input_0;
//	}
//	public void setUp_Input_0(String up_Input_0) {
//		this.up_Input_0 = up_Input_0;
//	}
//	public String getUp_Input_1() {
//		return up_Input_1;
//	}
//	public void setUp_Input_1(String up_Input_1) {
//		this.up_Input_1 = up_Input_1;
//	}
//	public String getUp_Input_2() {
//		return up_Input_2;
//	}
//	public void setUp_Input_2(String up_Input_2) {
//		this.up_Input_2 = up_Input_2;
//	}
//	public String getUp_Input_3() {
//		return up_Input_3;
//	}
//	public void setUp_Input_3(String up_Input_3) {
//		this.up_Input_3 = up_Input_3;
//	}
//	public String getExp_Input_0() {
//		return exp_Input_0;
//	}
//	public void setExp_Input_0(String exp_Input_0) {
//		this.exp_Input_0 = exp_Input_0;
//	}
//	public String getExp_Input_1() {
//		return exp_Input_1;
//	}
//	public void setExp_Input_1(String exp_Input_1) {
//		this.exp_Input_1 = exp_Input_1;
//	}
//	public String getExp_Input_2() {
//		return exp_Input_2;
//	}
//	public void setExp_Input_2(String exp_Input_2) {
//		this.exp_Input_2 = exp_Input_2;
//	}
//	public String getExp_Input_3() {
//		return exp_Input_3;
//	}
//	public void setExp_Input_3(String exp_Input_3) {
//		this.exp_Input_3 = exp_Input_3;
//	}
	
	public void setUpInputPin(int pin_num, int status )
	{
		if(pin_num < pin_up_max)
		{
			pin_up_array[pin_num] = status;
		}
	}
	
	public int getUpInputPin(int pin_num)
	{
		return pin_up_array[pin_num];
	}
	
	public void setExpInputPin(int pin_num, int status )
	{
		if(pin_num < pin_exp_max)
		{
			pin_exp_array[pin_num] = status;
		}
	}
	
	public int getExpInputPin(int pin_num)
	{
		return pin_exp_array[pin_num];
	}
	
	
}
