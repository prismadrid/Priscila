/* Pseudocode:

1. Begin

2.- I allow the user to assign the value to the 6 coordinates that will form the point A, B, and C (to get the users input, I need to use funtions provided by the scanner). Being type double since it will be allowed to enter decimal numbers.

3.- Then, I use the formula to find the distance between each created vertex (d=√((x2 – x1)² + (y2 – y1)²)) (The java.lang.Math class contains methods for performing basic numeric operations such as the elementary exponential, logarithm, square root, and trigonometric functions.) and by adding the three results I get the perimeter (P = ab+ac+cb).

4.- In addition, I applied Heron's formula (Area = Square root of √s(s - a)(s - b)(s - c) where s is half the perimeter, or (a + b + c)/2.), to find the area effectively no matter what type of triangle the user has created.

5.- Finally, If it is true that the distance between each vertex is equal, it will print: "It is an equilateral triangle". If it is false it will print: "It is not an equilateral triangle". as well its respective area.

6. End*/

import java.util.Scanner;
import java.lang.Math;

public class Lab2{
    public static void main (String[] args){

      double x1;
      double y1;
      double x2;
      double y2;
      double x3;
      double y3;
      double ab;
      double ac;
      double cb;
      double area;
      double perimeter;

      Scanner userinput = new Scanner(System.in);
       System.out.println("Input three coordinates");

      System.out.println("For the A point enter x1");
      x1= userinput.nextDouble();

      System.out.println("For the A point enter y1");
      y1= userinput.nextDouble();

      System.out.println("For the B point enter x2");
      x2= userinput.nextDouble();

      System.out.println("For the B point enter y2");
      y2= userinput.nextDouble();

      System.out.println("For the C point enter x3");
      x3= userinput.nextDouble();

      System.out.println("For the C point enter y3");
      y3= userinput.nextDouble();

      ab = Math.sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1)));

      ac = Math.sqrt(((x3-x1)*(x3-x1))+((y3-y1)*(y3-y1)));

      cb = Math.sqrt(((x3-x2)*(x3-x2))+((y3-y2)*(y3-y2)));

      perimeter=(ab+ac+cb);

      area = Math.sqrt((perimeter/2)*(((perimeter/2)-ab)*((perimeter/2)-ac)*((perimeter/2)-cb)));

      if (ab==cb && cb==ac) {
        area = Math.sqrt((perimeter/2)*(((perimeter/2)-ab)*((perimeter/2)-ac)*((perimeter/2)-cb)));
        System.out.println("The area is: " +area);
        System.out.println("The trinagle is an equilateral triangle");
        
      }
       else if(ab!=ac) {
        area = Math.sqrt((perimeter/2)*(((perimeter/2)-ab)*((perimeter/2)-ac)*((perimeter/2)-cb)));
        System.out.println("The area is: " + area);
        System.out.println("The triangle is not an equilatero triangle");
      }
    }
  } 

 

