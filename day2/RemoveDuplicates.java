package week3.day2;


import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		
		String s1 = "paypal India";
		
		//Convert it into a character array
		char[] charArray = s1.toCharArray();
		
		
		//Declare a Set as charSet for Character
		Set<Character> charSet = new LinkedHashSet<Character>();
		
		//	Declare a Set as dupCharSet for duplicate Character
		Set<Character> dupCharSet = new LinkedHashSet<Character>();
		
		//Iterate character array and add it into charSet
		for (char c : charArray) {
			
			//if the character is already in the charSet then, add it to the dupCharSet
			if (!charSet.add(c)) {				
				dupCharSet.add(c);
			}
			
		}
		
		System.out.println("Character set before removing duplicates: "+charSet);
		
		System.out.println("Duplicates available in the character set is: "+dupCharSet);
		
		
		//Check the dupCharSet elements and remove those in the charSet
		charSet.removeAll(dupCharSet);
		
		System.out.print("After duplicate removal: "+charSet);
		System.out.println("");
		
		//Iterate using charSet
		for (Character eachChar : charSet) {
	
			//Check the iterator variable isn't equals to an empty space

			if (eachChar!=' ') {
				//print each character for charSet
				System.out.print(eachChar);
			}
		}
		
	}

}
