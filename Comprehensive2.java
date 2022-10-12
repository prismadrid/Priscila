import java.util.Scanner; //Scenner the file
import java.io.*;


public class Comprehensive2 {
    public static void main (String [] args)throws IOException{

        Scanner keyboard = new Scanner (System.in);

        int option = 0;
        String item_Name = "";
        double cost = 0;
        Boolean is_Beverage = false;
        double subtotal = 0;
        String cart = "";
        String menu = "";
        int quantity = 0;
        String choice = "";
        Boolean exist = false;
        int user_drink_size;
        String info = "";
        double tall = 0;
        double grande = 0;
        double venti = 0;
        double bakery = 0;
        String checkout = "";


                while(option >= 0 && option <5) { //Todo el programa esta bajo la scoop de este while. La variable opcion guarda el valor de la opcion que desea del menu
                System.out.println ("Welcome to Mejia Coffee! Please select an option below to continue:");
                System.out.println ("1, Display Menu");
                System.out.println ("2. Add item to order");
                System.out.println ("3. View cart");
                System.out.println ("4. Checkout");
                System.out.println ("5. Exit Mejia Coffee");
                System.out.print ("> ");
                option = keyboard.nextInt(); //Inicializamos la variable que almacenara el input de la opcion seleccionada del menu
                System.out.println("");

        
                if(option == 1){ //Si el usuario selecciona la 

                        System.out.printf("+-------------------------------------------------------+%n");
                        System.out.printf("|                    MEJIA COFFEE MENU                  |%n");
                        System.out.printf("+-------------------------------------------------------+%n");
                        System.out.printf("| %-32s | %-11s | %-4s |\n", "Item Name: ", "Is Beverage: ", "Cost: ");
                        System.out.printf("+----------------------------------+-------------+------+%n");


                        File fileToRead = new File ("starbucks_menu.txt");
                        Scanner fileReader = new Scanner (fileToRead);

                        while(fileReader.hasNextLine()){
                            fileReader.nextLine();

                            item_Name = fileReader.next();
                            is_Beverage = fileReader.nextBoolean();
                            cost = fileReader.nextDouble();

                         System.out.printf("| %-32s | %-11s |$ %-4s |\n", item_Name, is_Beverage, cost);
                         System.out.printf("+----------------------------------+-------------+------+%n");
                        }
                }

                if (option == 2){
                    System.out.println("Please enter the name of the item as shown on the menu:");
                       choice = keyboard.next();

                        File fileToRead = new File ("starbucks_menu.txt");
                        Scanner fileRead = new Scanner (fileToRead);
                        fileRead.nextLine();

                        while(fileRead.hasNext()){

                            item_Name = fileRead.next();
                            is_Beverage = fileRead.nextBoolean();
                            cost = fileRead.nextDouble();

                                if (choice.equals(item_Name) && (is_Beverage == true)){
                                    exist = true;
                                    System.out.println("What size would you like for your drink?");
                                    System.out.println("1. Tall (+$0.00)");
                                    System.out.println("2. Grande (+$1.50)");
                                    System.out.println("3. Venti (+$2.75)");        
                                    user_drink_size = keyboard.nextInt();


                                    if (user_drink_size == 1){
                                        subtotal += cost;
                                        tall += cost;
                                        info = info.concat(item_Name + cost);
                                        cart += "Tall " + item_Name + " $" + tall;
                                        cart = cart.concat("%n");
                                        System.out.println("Item was added to your cart");
                                        tall = 0;
                                        
                                        

                                    }
                                    else if (user_drink_size == 2){
                                        subtotal += cost + 1.50;
                                        grande += cost + 1.50;
                                        cart += "Grande " + item_Name + " $" + grande;
                                        cart = cart.concat("%n");
                                        System.out.println("Item was added to your cart");
                                        grande = 0;
                                    }
                                    else if (user_drink_size == 3){
                                        subtotal += cost + 2.75;
                                        venti += cost + 2.75;
                                        cart += "Venti " + item_Name + " $" + venti;
                                        cart = cart.concat("%n");
                                        System.out.println("Item was added to your cart");
                                        venti = 0;
                                    }
                                    else{
                                        System.out.println("Sorry, we do not have this size");
                                    }
                                }


                                else if (choice.equals(item_Name) && (is_Beverage == false)){
                                    exist = true;
                                    System.out.println("How many would you like?");
                                    quantity = keyboard.nextInt();
                                    subtotal += cost*quantity;
                                    bakery += cost*quantity;
                                    cart += quantity + (" ")+ item_Name + " $" + bakery;
                                    cart = cart.concat("%n");
                                    System.out.println("Item was added to your cart");
                                    bakery = 0;
                                    

                                }

                                 
                    }

                    if (exist == false){
                                    System.out.println("I'm sorry. We do not carry that item");
                    } 
                

                }
                if (option == 3){
                    System.out.println("---------------- YOUR CART ----------------");
                    System.out.printf(cart);
                    System.out.println(" ");
                    System.out.print("Subtotal "+ "$");
                    System.out.printf("%.2f", (subtotal));
                }

                if (option == 4){
                    System.out.println("---------------- YOUR CART ----------------");
                    System.out.printf(cart);
                    System.out.println(" ");
                    System.out.print("Subtotal "+ "$");
                    System.out.printf("%.2f", (subtotal));
                    System.out.println("");
                    System.out.print("Total after tax: "+ "$");
                    System.out.printf("%.2f", (subtotal=subtotal+(subtotal*0.0675)));
                    System.out.println("");
                    System.out.println("Please enter CHECKOUT to complete your purchase.");
                    checkout = keyboard.next();
                    System.out.println("Thank you for your purchase. Enjoy!");
                        
                        if(checkout == "CHECKOUT"){
                            System.out.println("Thank you for your purchase. Enjoy!");

                        }

                        }
                }
System.out.println("Thank you for shopping at Mejia Coffee.");

            }
           
    }