import java.util.Scanner;

abstract class Shape{
   public abstract void RectangleArea(int length, int breadth);
   public abstract void SquareArea(int side);
   public abstract void CircleArea(int radius);
}

//calculation of area + output of product
class Area extends Shape{
   public void RectangleArea(int length, int breadth){
      int rectangle = length * breadth;
      System.out.println("\nThe area of the rectangle is " + rectangle);
   }
   public void SquareArea(int side){
      int square = side * side;
      System.out.println("The area of the square is " + square);
   }
   public void CircleArea(int radius){
      final double pi = 3.14;
      double circle = pi * (radius * radius);
      System.out.println("The area of the circle is " + circle);
   }
}

//main method
public class Exer1{
   public static void main (String [] args){    
      int length, breadth, side, radius;
      Scanner input = new Scanner(System.in);
      Area what = new Area();
      
      System.out.print("Enter the length of the rectangle: ");
      length = input.nextInt();
      System.out.print("Enter the breadth of the rectangle: ");
      breadth = input.nextInt();
      System.out.print("Enter the side of the square: ");
      side = input.nextInt();
      System.out.print("Enter the radius of the circle: ");
      radius = input.nextInt();
      
      what.RectangleArea(length, breadth);
      what.SquareArea(side);
      what.CircleArea(radius);
   }
}