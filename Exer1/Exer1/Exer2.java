import java.util.Scanner;

abstract class Calculator{
   public int [] classA = {73, 72, 44, 91, 90, 91, 33, 81, 70, 78};
   public int [] classB = {62, 67, 87, 74, 98, 91, 38, 83, 81, 87};
   public int [] classC = {75, 56, 87, 47, 48, 84, 67, 70, 75, 83};
   abstract int findSmallest(int [] grades);
   abstract void findLargest(int [] grades);
   abstract int getAverage(int [] grades);
   abstract int getNumStud(int [] grades, int average);
}

class GradeCalculator extends Calculator{
   public int findSmallest(int [] grades){
      int smallestNum;
      smallestNum = grades[0];
      //traversing for loop. if loop = taking the lowest number
      for (int i = 0; i < 10; i++){
         if (grades[i] < smallestNum){
            smallestNum = grades[i];
         }
      }
      return smallestNum;
   }
   
   public void findLargest(int [] grades){
      int largestNum;
      largestNum = grades[0];
      //traversing for loop. if loop = taking the highest number
      for (int i = 0; i < 10; i++){
         if (grades[i] > largestNum){
            largestNum = grades[i];
         }
      }
      System.out.println("The highest test score in the class is " + largestNum + ". ");
   }
   
   public int getAverage(int [] grades){
      int sum = 0, average;
      //traversing and adding each element during for loop
      for (int i = 0; i < 10; i++){
         sum = grades[i] + sum;
      }
      average = sum/10;
      return average;
   }
   
   public int getNumStud(int [] grades, int average){
      int numStud = 0;
      //traverses the array and counts the number of test scores higher than average
      for(int i = 0; i < 10; i++){
         if(grades[i] < average){
            numStud++;
         }
      }
      return numStud;
   }
}

public class Exer2{
   public static void main (String [] args){
      Scanner input = new Scanner(System.in);
      int [] grades = {0,0,0,0,0,0,0,0,0,0};
      int function, classSection, average = 0;
      GradeCalculator calc = new GradeCalculator();
      char again = 'Y';
            
      System.out.println("[1] Class A \n[2] Class B \n[3] Class C");
      System.out.print("Which class' test scores would you like to work on? ");
      classSection = input.nextInt();
      if(classSection == 1){
         grades = calc.classA;
      } else if (classSection == 2){
         grades = calc.classB;
      } else if (classSection == 3){
         grades = calc.classC;
      }
            
      //printing the test scores
      System.out.print("\nThis is the list of the class test scores: ");
      for (int i = 0; i < 10; i++){
         System.out.print(grades[i] + " ");
      }
      
      System.out.println("\n[1] Find the lowest test score \n[2] Find the highest test score");
      System.out.println("[3] Get the test score average \n[4] Get the number of students with scores higher than the average");
      System.out.print("Which action would you like to take? ");
      function = input.nextInt();
      
      if(function == 1){
         System.out.println("The lowest test score in the class is " + calc.findSmallest(grades));
      } else if (function == 2){
         calc.findLargest(grades);
      } else if (function == 3){
         System.out.println("The average score of the class is " + calc.getAverage(grades));
      } else if (function == 4){
         average = calc.getAverage(grades);
         System.out.println("The number of students with higher than average scores are " + calc.getNumStud(grades, average));
      }         
   }
}