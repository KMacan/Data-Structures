import java.util.Scanner;

public class Anagrams {
	public String swapper(String oriNoSpace, int toBeReplaced, int originalLetter) {
		char temp;
		char [] array = oriNoSpace.toCharArray();
		temp = array[originalLetter];
		array[originalLetter] = array[toBeReplaced];
		array[toBeReplaced] = temp;
		return String.valueOf(array);
	}
	
	public void checker(String oriNoSpace, int left, int right, String anaNoSpace, String original, String anagram) {
		if(oriNoSpace.equals(anaNoSpace) && left == right) {
			System.out.println(anagram + " is an anagram of " + original);
		} else {
			for (int i = left; i <= right; i++) {
				String newOriginal = swapper(oriNoSpace, left, i);
				checker(newOriginal, left+1, right, anaNoSpace, original, anagram);
			}
		}
	}
	
	public static void main (String [] args) {
		//variables
		Scanner scanner = new Scanner (System.in);
		String original, anagram, oriNoSpace, anaNoSpace;
		int length;
		
		//takes user input
		System.out.print("Input the original word	: ");
		original = scanner.nextLine();
		original = original.toUpperCase();
		oriNoSpace = original.replace(" ", "");
		length = oriNoSpace.length();
		System.out.print("Input the anagram 	: ");
		anagram = scanner.nextLine();
		anagram = anagram.toUpperCase();
		anaNoSpace = anagram.replace(" ", "");
		
		//implements the anagram checker
		Anagrams recursion = new Anagrams();
		recursion.checker(oriNoSpace, 0, length-1, anaNoSpace, original, anagram);
	}
}
