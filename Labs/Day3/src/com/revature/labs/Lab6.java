package com.revature.labs;

abstract class Customer{
	public String name;
	public double balance;
	public String items;
	public double cartCost;
	
	Customer(){
		this.name="";
		this.balance=0;
		this.items="";
		this.cartCost=0;
	}
	
	Customer(String name, double balance, String items, double cartCost){
		this.name=name;
		this.balance=balance;
		this.items=items;
		this.cartCost=cartCost;
	}
	
	public void addToCart(String item, double cost) {
		this.cartCost = this.cartCost+cost;
		this.items = this.items+" "+item;
	}
	
	public String getName(){
		return this.name;
	}
	public double getBalance() {
		return this.balance;
	}
	public String getItems() {
		return this.items;
	}
	public double getCartCost() {
		return this.cartCost;
	}
	
	public void setName(String name){
		this.name=name;
	}
	public void setBalance(double balance) {
		this.balance=balance;
	}
	public void setItems(String items) {
		this.items=items;
	}
	public void setCartCost(double cartCost) {
		this.cartCost=cartCost;
	}
	
	public abstract void buy();
}

interface Premium{
	public final static String title="Favored Customer";
	public double discountPrice(double startingPrice);
}

class PremiumCustomer extends Customer implements Premium{
	private int vipCard;
	private int years;
	PremiumCustomer(String name, double balance, String items, double cartCost, int vipCard, int years){
		super(name, balance, items, cartCost);
		this.vipCard = vipCard;
		this.years = years;
	}
	public double discountPrice(double startingPrice) {
		double discount=startingPrice-startingPrice*.15;
		return discount;
	}
	public void buy() {
		try{
			if(super.balance<discountPrice(super.cartCost)) {
				throw new OverBalanceException("Insuficcient balance");
				//throw new OverBalanceException();
			}
			else {
				super.items="";
				super.balance=super.balance-discountPrice(super.cartCost);
				super.cartCost = 0.0;
			}
		} catch (OverBalanceException err) {
		    
		}
		/*super.items="";
		super.balance=super.balance-discountPrice(super.cartCost);
		super.cartCost = 0.0;*/
	}
	public int getVipCard() {
		return this.vipCard;
	}
	public int getYears() {
		return this.years;
	}
	
	public void setVipCard(int vipCard){
		this.vipCard=vipCard;
	}
	public void setYears(int years) {
		this.years=years;
	}
	
	public String toString() {
		String data = name+" "+balance+" "+items+" "+ cartCost+" "+title+" "+vipCard+" "+years;
		return data;
	}
}

public class Lab6 {

	public static void main(String[] args) {
		/*PremiumCustomer customer = new PremiumCustomer("Hassan", 250.43, "celery brocolli fries", 56.89, 12345, 3);
		System.out.println(customer.toString());
		customer.buy();
		System.out.println(customer.toString());*/
	}

}
