
public class Lab2 {
	
	static int add(int a, int b){
		int sum = 0;
		sum = a+b;
		return sum;
	}
	
	static int sub(int a, int b){
		int difference = 0;
		difference = a-b;
		return difference;
	}
	
	static double multiply(double a, double b){
		double product = 0;
		product = a*b;
		return product;
	}
	
	static double divide(double a, double b){
		double quotient = 0;
		quotient = a/b;
		return quotient;
	}
	
	public static void main(String[] args) {
		int number1 = 10;
		int number2 = 5;
		double number3 = 10.5;
		double number4 = 5.8;
		int result1=add(number1,number2);
		int result2=sub(number1,number2);
		double result3=multiply(number3,number4);
		double result4=divide(number3,number4);
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
	}
	
}
