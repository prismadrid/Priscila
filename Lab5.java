import java.io.*;
import java.io.File; //open a file
import java.io.FileNotFoundException; //If the file does not exist or can not find it.
import java.util.Scanner; //Scanner 


public class Lab1_Madrid_Priscila{
    public static void main(String args[]) throws FileNotFoundException{

    try{
        File file = new File ("/Users/priscilamadrid/Desktop/input.txt");//La direccion del documento input
        Scanner scan = new Scanner (file); //Start reading 
        

        double [][] data = new double [12][3]; //Creo el 2D Array
        double sumWindspeed=0;
        double sumRainfall=0;

            for (int i=0; i<12; i++){
                for (int j=0; j<3; j++){
                    if(scan.hasNextDouble()){
                        data [i][j]=scan.nextDouble();
                        System.out.print(data[i][j]+"   ");
                    }
                }
            System.out.println("\n");
            }

            for (int i = 0; i < 12; i++){ //La loop se dentendra cuando i = 12, el uno es constante por que es la columna del windspeed.
                    sumWindspeed += data[i][1]; //Avanza en el indice de la columna
            }  
            sumWindspeed /= 12;//Se dividira la variable de sumWindspeed entre doce y se actualizara su valor.

            System.out.printf("The average windspeed for the year is: "+"%.2f",(sumWindspeed)); //Solo redondea el promedia a dos decimales
            System.out.println("");
            System.out.println("");
            System.out.println("Months that had more than the average windspeed:");
            System.out.println("Index  Month Name");

            for(int i=0; i < 12; i++){ 
                if(data[i][1] > sumWindspeed){ //Si la coordenada de la segunda columa es mayor al promedio de sumWindspeed... 
                    //convierte de double a int la primera columa que es igual a cero.

                    System.out.print(Math.round(data[i][0])); //Se imprimira la coordenada 0 dependiendo en el indice que se encuentre
                    System.out.print("");
                    
                    //Se compara el numero del indice y se le asigna el nombre del mes correspondiente

                    if(data[i][0]==1){ 
                        System.out.print("      January");
                    }
                    else if(data[i][0]==2){
                        System.out.print("      February");
                        System.out.println("");
                    }
                    else if(data[i][0]==3){
                        System.out.print("      March");
                        System.out.println("");
                    }
                    else if(data[i][0]==4){
                        System.out.print("      April");
                        System.out.println("");
                    }
                    else if(data[i][0]==5){
                        System.out.print("      May");
                        System.out.println("");
                    }
                    else if(data[i][0]==6){
                        System.out.print("      June");
                        System.out.println("");
                    }
                    else if(data[i][0]==7){
                        System.out.print("      July");
                        System.out.println("");
                    }
                    else if(data[i][0]==8){
                        System.out.print("      August");
                        System.out.println("");
                    }
                    else if(data[i][0]==9){
                        System.out.print("      September");
                        System.out.println("");
                    }
                    else if(data[i][0]==10){
                        System.out.print("      October");
                        System.out.println("");
                    }
                    else if(data[i][0]==11){
                        System.out.print("      November");
                        System.out.println("");
                    }
                    else if(data[i][0]==12){
                        System.out.print("      December");
                        System.out.println("");
                    }    
                }
            }   
            System.out.println("");
    
            for(int i = 0; i < 12; i++){
                sumRainfall += data[i][2];// Similar al anterior solo se pasa a la segunda columna y se actualiza el valor de la variable llamada rainfall
            }
            sumRainfall /= 12; //Una vez alcanzado el valor total se saca el promedio dividiendolo entre doce

            System.out.printf("The average rainfall for the year is: "+"%.1f",(sumRainfall)); //
            System.out.println("");
            System.out.println("");
            System.out.println("Months that had more than the average rainfall:");
            System.out.println("Index  Month Name");
    
            for(int i=0; i < 12; i++){
                if(data[i][2] > sumRainfall){ 
                    System.out.print(Math.round(data[i][0]));
                    System.out.print("");
                    
                    if(data[i][0]==1){
                        System.out.print("      January");
                    }
                    else if(data[i][0]==2){
                        System.out.print("      February");
                        System.out.println("");
                    }
                    else if(data[i][0]==3){
                        System.out.print("      March");
                        System.out.println("");
                    }
                    else if(data[i][0]==4){
                        System.out.print("      April");
                        System.out.println("");
                    }
                    else if(data[i][0]==5){
                        System.out.print("      May");
                        System.out.println("");
                    }
                    else if(data[i][0]==6){
                        System.out.print("      June");
                        System.out.println("");
                    }
                    else if(data[i][0]==7){
                        System.out.print("      July");
                        System.out.println("");
                    }
                    else if(data[i][0]==8){
                        System.out.print("      August");
                        System.out.println("");
                    }
                    else if(data[i][0]==9){
                        System.out.print("      September");
                        System.out.println("");
                    }
                    else if(data[i][0]==10){
                        System.out.print("      October");
                        System.out.println("");
                    }
                    else if(data[i][0]==11){
                        System.out.print("      November");
                        System.out.println("");
                    }
                    else if(data[i][0]==12){
                        System.out.print("      December");
                        System.out.println("");
                    }
                }
            }   
        } catch (Exception e) {
            System.out.print("Ups, something went wrong while reading the file :(");
        }
    }    
}
        
 