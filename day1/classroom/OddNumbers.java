package week1.day1.classroom;


// Find the odd numbers in the specific range of numbers
public class OddNumbers {
	
	public static void main(String[] args) {
		
		int input = 100;
		System.out.println("Print only the odd numbers from 1 to "+input);
		
		for (int i = 1; i <=input; i++) {	
			if (i%2==1) 
			{
				System.out.println(i);	
			}
			
		}
	}

}
