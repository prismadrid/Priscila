/* Pseudocode:

1. Begin

2.- Get input of the temperature as a double

3.- Get input of the raining situation as true or false using boolean 

5.- If (raining = true)

6-   If(raining == true)

7.-       Print "John will wear pants"

8.-            if(temperature>90)

9.-              Print("Alejandra will wear shorts");
                 Print ("Alex will wear pants");

10.-      Else

11.-          Print ("Alejandra will wear pants");
              Print ("Alex will wear shorts");
 
12.- Else if (temperature>80)

13.- Else

14.-     Print "John will wear shorts"

15.- If (temperature>90)
                   Print ("Alejandra will wear shorts");
                    Print ("Alex will wear pants");
            Else
                Print("Alejandra will wear shorts");
                Print("Alex will wear pants");
        Else
            Print("John will wear pants");
            Print("Alejandra will wear shorts");
            Print("Alex will wear pants");
5. End*/


import java.util.Scanner; //(to get the users input, I need to use funtions provided by the scanner). 

class Lab3{
    public static void main(String args[]) {
        int temperature = 0; //Initialize integer temperature = 0.
        boolean raining = false;  //Initialize boolean raining = false.


        Scanner scnr = new Scanner(System.in);
        System.out.println("What is temperature today?");
        temperature = scnr.nextInt(); //Prompt temperature←Get input

        System.out.println("Is true or false that is raining today?");
        raining = scnr.nextBoolean(); //Prompt raining←Get boolean input


        if (raining = true) { //if the user decides that it is not raining than...
            
        }

        if(raining == true){//the comparison is made if raining is equal to false, then it continues to execute the following...
            System.out.println("John will wear pants"); //The temperature doesn't matter if it's raining
            
            if(temperature>90){ //If the temperature is greater than 90, then...
                System.out.println ("Alejandra will wear shorts"); //....Will print the following
                System.out.println ("Alex will wear pants");
            }
            else{ // any other possible scenario that does not meet one of the above conditions will be printinh...
                System.out.println("Alejandra will wear pants");
                System.out.println ("Alex will wear shorts");
            }
        }
        else if (temperature>80){  //If the temperature is greater than 80, then...
            System.out.println("John will wear shorts"); //....Will print the following
            if (temperature>90){ //If the temperature is greater than 90, then...
                    System.out.println("Alejandra will wear shorts"); //....Will print the following
                    System.out.println ("Alex will wear pants");
            }
            else{ // any other possible scenario that does not meet one of the above conditions will be printinh...
                System.out.println("Alejandra will wear shorts"); //
                System.out.println("Alex will wear pants");
            }
        }
        else{ // any other possible scenario that does not meet one of the above conditions will be printinh...
            System.out.println("John will wear pants");
            System.out.println("Alejandra will wear shorts");
            System.out.println("Alex will wear pants");
        
        }
    }
}