package com.marlabs.solution.clientserver;

public class ClientServerPOJO {
	
	private int sum;
	private int[] digits;
	boolean success;
	
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int[] getDigits() {
		return digits;
	}
	public void setDigits(int[] digits) {
		this.digits = digits;
	}

}
