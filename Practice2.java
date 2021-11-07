//Write a program that reads in 7 numbers and prints out both the smallest
//and the greatest value of the 7 given values. All the numbers should be input by the user only once, of course.

import java.util.Scanner;

public class Practice2 {
	public static void main (String [] args) {
		//class variables
		Scanner scanner = new Scanner(System.in);
		int [] array = new int[7];
		int smallest, largest = 0;
		
		//asks the user for 7 number input
		try {
			System.out.print("Please input 7 numbers: ");
			for (int i = 0; i < 7; i++) {
				array[i] = scanner.nextInt();
			}
			scanner.close();
		} catch (Exception e) {
			System.out.print("Please only input 7 numbers.");
		}
		
		
		//returns the smallest value
		smallest = array[0];
		for(int i = 0; i < 7; i++) {
			if(array[i] < smallest) {
				smallest = array[i];
			}
		}
		
		//returns the largest value
		for (int i = 0; i < 7; i++) {
			if(array[i] > largest) {
				largest = array[i];
			}
		}
		
		//prints the results
		System.out.println("The smallest number is: " + smallest);
		System.out.println("The largest number is : " + largest);
	}
}
