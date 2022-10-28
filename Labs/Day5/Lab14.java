package com.revature.day5;
import java.lang.Math;

public class Lab14 {
	static String twoKidsAndATruck(int k1, int k2, int t){
		if(Math.abs(k1-t)<Math.abs(k2-t)) {
			return "Kid 1";
		}
		else if(Math.abs(k1-t)>Math.abs(k2-t)) {
			return "Kid 2";
		}
		else{
			return "Truck";
		}
	}
	
	public static void main(String[] args) {
		System.out.println(twoKidsAndATruck(1,2,4));
		System.out.println(twoKidsAndATruck(1,3,2));
		System.out.println(twoKidsAndATruck(5,2,4));
		System.out.println(twoKidsAndATruck(2,2,4));
		System.out.println(twoKidsAndATruck(5,2,1));
		System.out.println(twoKidsAndATruck(1,2,2));
		System.out.println(twoKidsAndATruck(1,1,4));
		
	}

}
