package week1.day1.assignments;

//To find whether a number is a Prime number or not
//A prime number is a number that is only divisible by 1 or itself.

public class PrimeNumbers {
	
	public static void main(String[] args) {
		
		int input =101; 
		boolean primeFlag = true;
		int remainder;
		
		for (int i = 2; i <=input/2 ; i++) {
			
			remainder = input % i;
			//System.out.println(input+" divided by "+i+"gives remainder "+remainder);
			
			if (remainder==0) 
			{
				primeFlag=false;
				break;
			}
			
		}
		if (primeFlag) 
			System.out.println(input+" is Prime number");
		else 
			System.out.println(input+ " is not a Prime number");
		
	}

}
