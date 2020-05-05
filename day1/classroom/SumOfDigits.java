package week1.day1.classroom;

//Find the sum of digits of a given number

public class SumOfDigits {

	public static void main(String[] args) {
		
		int input = 123;
		int sum = 0;
		int remainder;
		
		System.out.println("Given input number is:"+input);
		
		while (input>0) {
			
			remainder = input%10;
			//System.out.println("remainder:"+remainder);
			
			sum=sum+remainder;
			//System.out.println("sum:"+sum);
			
			input=input/10;
			//System.out.println("quotient:"+input);
			
		}
		
		System.out.println("Sum of all the digits is:"+sum);
			
	}

}
