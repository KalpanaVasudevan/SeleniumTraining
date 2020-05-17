package week3.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortingUsingCollection {

	public static void main(String[] args) {

		/*
		 * //Declare a String array and add the Strings values as (HCL,
		 * Wipro,AspireSystems,CTS)
		 * 
		 * String[] s1 = {"HCL","Wipro","Aspire Systems","CTS"};
		 * 
		 * //Length of array int length = s1.length;
		 * 
		 * //sort the array Arrays.sort(s1);
		 * 
		 * System.out.println("Values After Sorting");
		 * 
		 * for (int i = 0; i < s1.length; i++) { System.out.println(s1[i]); }
		 * 
		 * //Iterate it in the reverse order
		 * System.out.println("Reverse order of given input is: ");
		 * 
		 * for (int i =s1.length-1 ; i >=0; i--) { System.out.println(s1[i]); }
		 */

		  //Declare a String array 
		
		  List<String> input = new ArrayList<String>();
		  
		  //Add the Strings values as (HCL, Wipro, Aspire Systems, CTS)
		  input.add("HCL"); 
		  input.add("Wipro");
		  input.add("Aspire Systems");
		  input.add("CTS");
		  
		  System.out.println("Values added to List: "+input);
		  
		  //get the length of the array 
		  int size = input.size();
		  //System.out.println(size);
		  
		  //sort the array 
		  Collections.sort(input);
		  
		  System.out.println("Values in List after sorting: "+input);
		  
		  System.out.println("Sorted values in Reverse order: ");
		  
		  //Iterate it in the reverse order 
		  for (int i = size-1; i >=0; i--) {
		  
			  System.out.println(input.get(i));
		  }
		 

	}

}
