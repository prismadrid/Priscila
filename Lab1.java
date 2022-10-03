/*Pseudocode:
1. BEGIN
2. (x1,y1)=(2,3) Represent the independent and dependent point of the first coordinate given as integers variables.
3. (x2,y2)=(4,7) Represent the independent and dependent point of the second coordinate given as integers variables.
4. (xMidpoint,yMidpoint)=(((x1+x2)/2),((y1+y2)/2)) I am going to use this formula in order to find the midpoint coordinate.
5. xMidpoint=(x1+x2)/2)=3 is equal to the independent point of the midpoint coordinate as a integer variable.
6. yMidpoint=(y1+y2)/2)=5 is equal to the dependent point of the midpoint coordinate as integer variable.
7. PRINT To output to the screen the values of xMidpoint and yMidpoint.
8. END*/

public class Lab1{
    public static void main (String []args) {
        
        int x1; 
        int x2; 
        int y1; 
        int y2; 
        int xMidPoint; 
        int yMidPoint; 
        
        x1=2;
        x2=4;
        y1=3;
        y2=7;
        xMidPoint=((x1+x2)/2); 
        yMidPoint=((y1+y2)/2); 
        
        System.out.println(xMidPoint);
        System.out.println(yMidPoint);
    } }