package week1.day1.classroom;

// Perform calculation based on the user input operations
public class SwitchOperator {
	
	public static void main(String[] args) {
		
		  int num1 = 2; 
		  int num2 = 3; 
		  int result;
		  char operator = '+';
		  
		  System.out.println("Selected input operation is: "+operator);
		  
		  switch (operator) {
			case '+':
				result = num1+num2;				
				System.out.println("Addition of "+num1+" and "+num2+" is: "+result);
				break;
			
			case '-':
				result = num1-num2;
				System.out.println("Subtraction of "+num1+" and "+num2+" is: "+result);
				break;
				
			case '*':
				result = num1*num2;
				System.out.println("multiplication of "+num1+" and "+num2+" is: "+result);
				break;
				
			case '/':
				result = num1/num2;
				System.out.println("Division of "+num1+" and "+num2+" is: "+result);
				break;
			
			default:
				System.out.println("no operations performed");
			}
		  
	}

}
