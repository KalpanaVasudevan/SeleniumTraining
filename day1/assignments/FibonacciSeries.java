package week1.day1.assignments;

//To find Fibonacci Series for a given range
//a series of numbers in which each number (Fibonacci number) is the sum of the two preceding numbers. 

public class FibonacciSeries {

	public static void main(String[] args) {
				
		int range = 8;
		int firstNum = 0;
		int secondNum = 1;
		int sum;
		
		System.out.println("Fibonacci Series for a given range "+range+" is:");
		
		for (int i = 1; i <=range; i++) {
			
			System.out.print(firstNum+" ");
			
			sum=firstNum+secondNum;
			
			firstNum=secondNum;
			
			secondNum=sum;
			
			
		}
	}

}
