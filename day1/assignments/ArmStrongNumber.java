package week1.day1.assignments;

//To find whether a number is an Armstrong number or not
//Armstrong number is a number that is equal to the sum of cubes of its digits

public class ArmStrongNumber {

	public static void main(String[] args) {
		
		//input=153; output=(1*1*1)+(5*5*5)+(3*3*3)=153
		int input =153;
		int calculated = 0;
		int remainder;
		int original;
		
		original=input;
		
		while (input>0) {
			
			remainder = input % 10;
			input = input / 10;
			calculated = calculated + (remainder*remainder*remainder);
		}	
				if (original==calculated) {
					System.out.println("Given number "+original+" is Armstrong number");
				} 
				else 
				{
					System.out.println("Given Number "+original+" is not armstrong number");	
				}
			
	}

}
