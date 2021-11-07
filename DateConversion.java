//Write a program to input number of days from user and convert it to years, weeks and days.

import java.util.Scanner;

public class DateConversion {
	public static void main(String [] args) {
		Scanner scanner = new Scanner (System.in);
		int input, year, week, day;
		
		System.out.print("Input the number of days: ");
		input = scanner.nextInt();
		
		year = input / 365;
		week = (input % 365) / 7;
		day = input - (year*365) - (week*7);
		
		System.out.print(year + " year/s "+ week + " weeks/s " + day + " day/s");
		
	}

}
