package com.visa.training.stack;

public class FixedArrayStack implements Stack {
	int top=0;
	
	Object[] stackArray; 
	public FixedArrayStack (int capacity) {
		stackArray = new Object[capacity];
		//System.out.println(1/0);
	}
	public void push(Object element) {
		stackArray[top]=element;
		System.out.println("Pushed -> " +stackArray[top]);
		top++;
	}
	public Object pop() {
		Object var1=0;
		var1= stackArray[top-1];
		stackArray[top-1]=0;
		top--;
		
		return var1;
			}

}
