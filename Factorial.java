package week1.day1.classroom;

//Find the factorial of a given number
public class Factorial {

	public static void main(String[] args) {
		
		//input=5; output=5*4*3*2*1=120
		int input = 5;
		int fact = 1;
		
		for (int i = 1; i <=input; i++) {
			
			fact = fact*i;
		}
		
		System.out.println("Factorial of a given number "+input+" is:"+fact);
	}

}
