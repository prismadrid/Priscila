/* Pseudocode:

1. Begin

2.- Get input of the points A, B, C and D. 

3.- Initialize double ab,bd,dc and ca. (Distance between each created vertex) 

4.- Compute (d=√((x2 – x1)² + (y2 – y1)²)) for each distance.

5.- If (ab==bd && ca==dc)

6-   Print "The four points create a square" 

7.-       Else if (( dc==ca && bd==ab))

8.-            Print "The four points create a square"

9.- else if (ab==dc||ca==bd)

10.-      Print ""The four points create a rectangle"

11.-          Else if ( bd==ca || dc==ab)
 
12.-                Print ""The four points create a rectangle"

13.- Else

14.-     Print "The four points create a paralelogram"

5. End*/


import java.util.Scanner;//(to get the users input, I need to use funtions provided by the scanner). 
import java.lang.Math; //(The java.lang.Math class contains methods for performing basic numeric operations such as the elementary exponential, logarithm, square root, and trigonometric functions.) 

class Lab4{
    public static void main(String args[]) {
        double x1; //Being type double since it will be allowed to enter decimal numbers.
        double y1; //Prompt y1←Get input
        double x2; //Prompt x2←Get input
        double y2; //Prompt y2←Get input
        double x3; //Prompt x3←Get input
        double y3; //Prompt y3←Get input
        double x4; //Prompt x4←Get input
        double y4; //Prompt y4←Get input
        double ab; //Initialize double ab
        double bd; //Initialize double bd
        double dc; //Initialize double dc
        double ca; //Initialize double ca

        Scanner userinput = new Scanner(System.in);
         System.out.println("Input four coordinates, please");

        Scanner scnr = new Scanner(System.in);
        System.out.println("Where is locate the point x1 of your edge ab?");
        x1 = scnr.nextDouble(); 
        System.out.println("Where is locate the point y1 of your edge ab?");
        y1 = scnr.nextDouble();
        System.out.println("Where is locate the point x2 of your edge bd?");
        x2 = scnr.nextDouble();
        System.out.println("Where is locate the point y2 of your edge bd?");
        y2 = scnr.nextDouble();
        System.out.println("Where is locate the point x3 of your edge dc");
        x3 = scnr.nextDouble();
        System.out.println("Where is locate the point y3 of your edge dc");
        y3 = scnr.nextDouble();        
        System.out.println("Where is locate the point x4 of your edge ca");
        x4 = scnr.nextDouble();
        System.out.println("Where is locate the point y4 of your edge ca");
        y4 = scnr.nextDouble();
        
        ab = Math.sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1))); //Compute the distance between each created vertex.

        bd = Math.sqrt(((x4-x2)*(x4-x2))+((y4-y2)*(y4-y2))); //Compute each edge

        dc = Math.sqrt(((x4-x3)*(x4-x3))+((y4-y3)*(y4-y3))); //Compute each edge

        ca = Math.sqrt(((x3-x1)*(x3-x1))+((y3-y1)*(y3-y1))); //Compute each edge

        if (ab==bd && ca==dc) { //If: the edge ab is equal to the edge bd AND the edge ca is equal to the edge dc, THEN...
            System.out.println("The four points create a square"); //...Will print it is a square
        }
            else if ( dc==ca && bd==ab) { //so that the user can introduce the vertices randomly, this second condition is created.
            System.out.println("The four points create a square");
        }
        else if (ab==dc||ca==bd){ //If: the edge ab(bases) is equal to the edge dc OR the edge ca(height) is equal to the edge bd, THEN...
            System.out.println("The four points create a rectangle"); //...Will print it is a ractangle
        }
            else if ( bd==ca || dc==ab) { //This second condition allows the user to enter the base and height in a different order than the previous one.
            System.out.println("The four points create a rectangle");
        }
        else { // any other possible scenario that does not meet one of the above conditions will be a parallelogram
            System.out.println("The four points create a paralelogram");
        }
    }
}