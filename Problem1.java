//Write a program that reads in 7 different numbers, 
//then prints out the smallest value and also prints out the 
//position of the smallest value in the input sequence as a number from 1 to 7.

import java.util.Scanner;

public class Problem1 {
	public static void main(String [] args) {
		//declare the variables
		Scanner scanner = new Scanner (System.in);
		int[] array = new int[7];
		int min, index = 0;
		
		//accept input of 7 values
		System.out.print("Please input 7 values: ");
		try {
			for (int i = 0; i < 7; i++) {
				array[i] = scanner.nextInt();
			}
			scanner.close();
		} catch (ArithmeticException e) {
			System.out.println("Please only enter 7 values.");
		}
		
		//get the smallest number
		min = array[0];
		for (int i = 0; i < 7; i++) {
			if(array[i] < min) {
				min = array[i];
			}			
		}
		
		//get the position of the smallest number
		while (array[index] != min) {
			index++;
		}
		index++;
		
		//print the results
		System.out.println("The smallest number among the values is " + min);
		System.out.println("It is at position " + index);
	
	}
}
