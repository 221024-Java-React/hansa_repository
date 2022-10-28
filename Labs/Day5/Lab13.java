package com.revature.day5;

public class Lab13 {
	static String fizzBuzz(int n){
		String out = "";
		if(n%3==0) {
			out = out + "Fizz";
		}
		if(n%5==0) {
			out = out + "Buzz";
		}
		return out;
	}
	
	public static void main(String[] args) {
		System.out.println(fizzBuzz(1));
		System.out.println(fizzBuzz(3));
		System.out.println(fizzBuzz(4));
		System.out.println(fizzBuzz(5));
		System.out.println(fizzBuzz(15));
		System.out.println(fizzBuzz(6));
	}

}
