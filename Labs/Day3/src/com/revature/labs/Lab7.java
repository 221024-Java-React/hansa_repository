package com.revature.labs;

class OverBalanceException extends RuntimeException { 
    public OverBalanceException() {
        
    }
    public OverBalanceException(String errorMessage) {
        super(errorMessage);
    }
}

public class Lab7 {

	public static void main(String[] args) {
		PremiumCustomer customer1 = new PremiumCustomer("Joe", 50.43, "celery brocolli fries", 156.89, 12345, 3);
		PremiumCustomer customer2 = new PremiumCustomer("Hassan", 250.43, "potatoes rice", 56.89, 12345, 3);
		System.out.println(customer1.toString());
		customer1.buy();
		System.out.println(customer1.toString());
		
		System.out.println(customer2.toString());
		customer2.buy();
		System.out.println(customer2.toString());
	}

}
