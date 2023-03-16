import java.io.*;
import java.util.Scanner; //Scanner 

    public class Lab2_Madrid_Priscila{
    public static void main(String args[]) throws FileNotFoundException{
        
    try{

        File file = new File ("/Users/priscilamadrid/Desktop/input2.txt");
        Scanner fileReader = new Scanner (file); 
        int [][] data = new int [5][12]; //

        while (fileReader.hasNextLine()){
            for (int row=0; row<data.length; row++){
                String [] line = fileReader.nextLine().split (","+" ");
                for(int col=0; col<line.length; col++){
                    data[row][col]= Integer.parseInt(line[col]);
                }
            }
        }

        //calling the methods
        farm_avg(data);
        System.out.println("\n");
        month_avg(data);
        System.out.println("\n");
        top_farms (data);
        System.out.println("\n");
        top_months (data);
        System.out.println("\n");

        fileReader.close();  

        } 
        catch (Exception e) {
        System.out.print("Ups, something went wrong while reading the file :(");
        
        }//End try catch
    } 

    public static void farm_avg(int[][] data){
        for(int i = 0; i < data.length; i++){ 
            int sum = 0;
            for(int j = 0; j < data[i].length; j++){
                sum += data[i][j];
            }
            System.out.println("Average production for farm "+ i +" is: " + (sum/data[i].length)); 
        }
    }

    public static void month_avg(int[][] data){
        for(int i = 0; i < data[0].length; i++){
            int sum = 0;
            for(int j = 0 ; j < data.length; j++){
                sum += data[j][i];
            }
            System.out.println("Average production for month "+ i +" is: " + (sum/data.length)); 
        }
    }

    public static void top_farms (int [][] data){
        int [] farmSum = new int [5];
        int max1=farmSum[0];
        int max2=farmSum[0];
        int max3=farmSum[0];

        int index1=0;
        int index2=0;
        int index3=0;

        for(int row=0; row<data.length; row++){
            for (int col=0; col<data[row].length; col++){
                farmSum[row]= farmSum[row] + data [row][col];
            }
            for(int rowMax=1; rowMax<farmSum.length; rowMax++){
                if(farmSum[rowMax]> max1){
                    max3=max2;
                    max2=max1;
                    max1=farmSum[rowMax];

                    index3=index2;
                    index2=index1;
                    index1=rowMax;

                }else if(farmSum[rowMax]> max2&&farmSum[rowMax]!=max1){
                    max3=max2;
                    max2=farmSum[rowMax];
                    index3=index2;
                    index2=rowMax;
                }else if (farmSum[rowMax]> max3&&farmSum[rowMax]!=max2){
                    max3=farmSum[rowMax];
                    index3=rowMax;
                }
            }
        }
        System.out.println("Farm with the highest production is: "+index1+"with a production of: "+max1);
        System.out.println("Farm with the highest production is: "+index2+"with a production of: "+max2);
        System.out.println("Farm with the highest production is: "+index3+"with a production of: "+max3);

    }

        public static void top_months (int[][] data){
        
        int max1 = 0;
        int index1 = 0;
        int max2 = 0;
        int index2 = 0;
        int max3 = 0;
        int index3 = 0;

        for(int i = 0; i < data[0].length; i++){
            int sum = 0;
            for(int j = 0 ; j < data.length; j++){
                sum += data[j][i];
            }
            if(sum > max1){
                max3 = max2;
                index3 = index2;
                max2 = max1;
                index2 = index1;
                max1 = sum;
                index1 = i;    
            }
            else if(sum > max2){
                max3 = max2;
                index3 = index2;
                max2 = sum;
                index2 = i;     
            }
            else if (sum > max3){
                max3 = sum;
                index3 = i;
            }
        }

        System.out.println("Month with the highest production is: "+index1+"with a production of: "+max1);
        System.out.println("Month with the highest production is: "+index2+"with a production of: "+max2);
        System.out.println("Month with the highest production is: "+index3+"with a production of: "+max3);

    }       

}
        
 