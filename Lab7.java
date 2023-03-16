import java.lang.Math;
import java.io.File;
import java.util.Scanner;

class Lab3_Madrid_Priscila{
	public static void main(String[] args){

		//String fileName = "/Users/priscilamadrid/Desktop/input.txt";  

		Box[] boxes;

		boxes = getBoxArrayFromDataFile("input.txt");

		printAllBoxes(boxes);

		//randomly generate the diameter of the ball to be shipped. 
		int range = 20;  

		//int diameter = (int) (Math.random() * range) + 2;

		////for verification use diameter = 13; then you can return it to random diameters uncommenting the previous two lines
		int diameter = 13;

		canContain(boxes, diameter);

		smallestBox(boxes, diameter);

		int l_index = largestBox(boxes, diameter);
		if(l_index >= 0){
			int count = shipHowMany (diameter, boxes[l_index]);
			System.out.println(count+" ball(s) can be shipped in the largest box.");
			System.out.println("-----------------------------------------------------------------------------\n");
		}
		else{
			System.out.println("Found no such box");
 			System.out.println("-----------------------------------------------------------------------------\n");
		}
	}

	/**
	 * Complete this method to print the Box
	 * objects in the array parameter theBoxes
	 * @param boxes is the array of Box objects
	 */

	public static void printAllBoxes (Box[] boxes){
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Printing box dimensions.");

		// You are not allowed to change the header.
		// Change the body of this method.
		for(int i = 0; i < boxes.length; i++){
            System.out.println("index: " + i + "   width: " + boxes[i].getWidth() + "   height: " + boxes[i].getHeight() + "   length: " + boxes[i].getLength() 
            	+ "   Volume: " + (boxes[i].getWidth() * boxes[i].getHeight() * boxes[i].getLength()));
        }
		//System.out.println("I have not yet implemented the printBoxes method.");

	}

	/**
	 * Change the body of this method to print the box
	 * objects in the array parameter that can hold/store
	 * the ball whose diameter is given in the parameter. 
	 * @param theboxes is the array of Box objects
	 * @param diameter of the ball
	 */  


	public static void canContain(Box[] boxes, int diameter){
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Checking for boxes that can hold the ball.");
		System.out.println("The diameter of the ball: " + diameter);

		int count=0;

		// You are not allowed to change the header.
		// Change the body of this method.

		for(int i = 0; i < boxes.length; i++){
            if((diameter <= boxes[i].getWidth()) && (diameter <= boxes[i].getHeight()) && (diameter <= boxes[i].getLength())){
                System.out.println("index: " + i + "   width: " + boxes[i].getWidth() + "   height: " + boxes[i].getHeight() 
                	+ "   length: " + boxes[i].getLength() + "   Volume: " + (boxes[i].getWidth() * boxes[i].getHeight() * boxes[i].getLength()));
            count++;
            }
        }

		System.out.println("The number of boxes that can hold the ball is: "+ count);

	}

	/**
	 * Change the body of this method to print the information 
	 * of the smallest Box object that can hold the ball of 
	 * the given diameter	
	 * @param boxes is the array of Box objects
	 * @param diameter of the ball
	 */    


	public static void smallestBox (Box[] boxes, int diameter){
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Finding the smallest box to ship the ball.");

		// You are not allowed to change the header.
		// Change the body of this method.

		int boxindex = 0;
        for(int i = 0; i < boxes.length; i++){
            if((diameter <= boxes[i].getWidth()) && (diameter <= boxes[i].getHeight()) && (diameter <= boxes[i].getLength())){
                if((boxes[i].getWidth() * boxes[i].getHeight() * boxes[i].getLength()) < (boxes[boxindex].getWidth() * boxes[boxindex].getHeight() * boxes[boxindex].getLength())){
                    boxindex = i;
                }
            }
        }

        System.out.println("Diameter of the ball to ship: " + diameter + "\nInformation of the smallest box");

        System.out.println("index: " + boxindex + "   width: " + boxes[boxindex].getWidth() + "   height: " + boxes[boxindex].getHeight() + "   length: " 
        	+ boxes[boxindex].getLength() + "   Volume: " + (boxes[boxindex].getWidth() * boxes[boxindex].getHeight() * boxes[boxindex].getLength()));   
	    
		//System.out.println("I have not yet implemented the smallestBox method.");    
	}

	/**
	 * Change the body of this method to (a) print the information 
	 * of the largest Box object that can hold the ball of 
	 * the given diameter, and (b) return the index of that object.	
	 * @param boxes is the array of Box objects
	 * @param diameter of the ball
	 * @return index of the largest box, -1 if no such box is found. 
	 */    

	public static int largestBox(Box[] boxes, int diameter){
		// You are not allowed to change the header.
		// Change the body of this method.

		System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Finding the largest box to ship the ball");
        
        int boxIndex2 = 0;
        for(int i = 0; i < boxes.length; i++){
            if((diameter <= boxes[i].getWidth()) && (diameter <= boxes[i].getHeight()) && (diameter <= boxes[i].getLength())){
                if((boxes[i].getWidth() * boxes[i].getHeight() * boxes[i].getLength()) > (boxes[boxIndex2].getWidth()
                 * boxes[boxIndex2].getHeight() * boxes[boxIndex2].getLength())){
                    boxIndex2 = i;
                }
            }
        }
        System.out.println("Largest box that can hold the ball is in index " + boxIndex2 + " with volume: " 
        	+ (boxes[boxIndex2].getWidth() * boxes[boxIndex2].getHeight() * boxes[boxIndex2].getLength()));


        return boxIndex2;

		//System.out.println("I have not yet implemented the largestBox method.");

	}

	/**
	 * Change the body of this method to return “the number of  
	 * balls” with the given diameter that can be shipped in the largest box
	 * @param diameter of the ball to be shipped
	 * @param largestBox is the box Object with largest volume
	 * @return the number of ball(s) that can be shipped in the
	 * largest Box object 
	 */


	public static int shipHowMany(int diameter, Box largestBox){
		// You are not allowed to change the header.
		// Change the body of this method.

		System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Finding how many ball(s) can be shipped in the largest box.");

        int count = 0;

        int xBallintoLength = (int) largestBox.getLength()/diameter;
        int xBallintoWidfth = (int) largestBox.getWidth()/diameter;
        int xBallintoHeight = (int) largestBox.getHeight()/diameter;

        count = xBallintoHeight * xBallintoWidfth * xBallintoLength;

        return count;

		//System.out.println("I have not yet implemented the shipHowMany method.");

	}

	/**
	 * Change the body of this method to return an array 
	 * of Box objects, created after reading the file.
	 * @param filename
	 * @return the array of Box objects created from the fileName file 
	 */    

	static Box[] getBoxArrayFromDataFile(String fileName){
		// You are not allowed to change the header.
		// Change the body of this method.  
		Box [] boxesTotal= new Box[10];;
		int run = 0;

		try {
            File file = new File(fileName);
            Scanner scnr = new Scanner(file);
         
        
            while (scnr.hasNextLine()) {
                double firstValue = scnr.nextDouble();
                double secondValue = scnr.nextDouble();
                double thirdValue = scnr.nextDouble();
        
                boxesTotal[run] = new Box(firstValue, secondValue, thirdValue);
        
                run++;
            }

        scnr.close();//cierro scanner

            //return boxesTotal;

        }catch (Exception e) {

            System.out.println("Error reading file");
            //return null;
        }  
		//System.out.println("I have not yet implemented the method to \nconstruct the array from the input file.");

		return boxesTotal; //you will return here the boxes variable
	}  
}