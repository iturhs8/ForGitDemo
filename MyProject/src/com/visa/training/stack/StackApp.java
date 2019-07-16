package com.visa.training.stack;

public class StackApp {

	public static void main(String[] args) {
		StackUser user = new StackUser();
		FixedArrayStack s= new FixedArrayStack(10);
		
		user.fill(s);
		user.empty(s);
	}
}
