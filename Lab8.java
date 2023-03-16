import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.lang.Math; 

public class Lab4_Madrid_Priscila { 

	/** 
	 * Do not change the main method.
	 * you can only change the "input.txt" to the location of your input file.
	 * Before submitting change it back to "input.txt"
	 */ 
	public static void main(String[] args){ 

		Person head = null;
		head = getPersonFromDataFile("input.txt"); 
		System.out.println("--------------------------------------");
		System.out.println("Printing the Linked List");
		printLL(head);

		Person newPerson = new Person("newPerson_1", 888, 8.8, 8, 8);
		head = addPerson(head, newPerson, 0);
		System.out.println("\n\n--------------------------------------");
		System.out.println("Adding a new person at position 0\n");
		System.out.println("Printing the Linked List\n");
		printLL(head);

		Person newPerson2 = new Person("newPerson_2", 666, 6.6, 6, 6);
		head = addPerson(head, newPerson2, 3);
		System.out.println("\n\n--------------------------------------");
		System.out.println("Adding a new person at position 3\n");
		System.out.println("Printing the Linked List\n");
		printLL(head);

		head = deletePerson(head, 3);
		System.out.println("\n\n--------------------------------------");
		System.out.println("Deleting a person from position 3\n");
		System.out.println("Printing the Linked List\n");
		printLL(head);

		head = deletePerson(head, 0);
		System.out.println("\n\n--------------------------------------");
		System.out.println("Deleting a person from position 0\n");
		System.out.println("Printing the Linked List\n");
		printLL(head);

		System.out.println("\n\n--------------------------------------");
		System.out.println("\nThe person worked most years: ");
		workedMostYears(head);

		System.out.println("\n\n--------------------------------------");
		System.out.println("\nThe person worked least years: ");
		workedLeastYears(head);

		System.out.println("\n\n--------------------------------------");
		System.out.println("\nAverage hours worked in the last week: ");
		averageHoursWorked(head);

		System.out.println("\n\n--------------------------------------");
		System.out.println("\nTotal payment amount for each person based on hoursWorked and hourlyWage: ");
		totalPaymentToEachPerson(head);

		// Extra Credit
		System.out.println("\n\n--------------------------------------");
		Person newPerson3 = new Person("newPerson_3", 102, 8.8, 8, 8);
		head = addPersonByCheckingId(head, newPerson3, 4);
		System.out.println("Printing the Linked List\n");
		printLL(head);

		System.out.println("\n\n--------------------------------------");
		Person newPerson4 = new Person("newPerson_4", 103, 8.8, 8, 8);
		head = addPersonByCheckingId(head, newPerson4, 4);
		System.out.println("Printing the Linked List\n");
		printLL(head);

	} 

	/** 
	 * Complete this method to print the Person Linkedlist
	 * given the head of the Person LinkedList
	 * @param head of the Person LinkedList 
	 */ 
	public static void printLL (Person head) { 

		//Si esta null, significa que esta vacia
		if(head==null){
			System.out.println("You don not have items in your list");
		}
		//mientras es diferente a null, se lee y se imprime
		while (head!=null){
			System.out.println(head.toString());
			head=head.next;//asigno head a la siguiente posicion
		}
	} 

    /** 
	 * Change the body of this method to add a person to the linkedlist
	 * @param head
	 * @param newPerson 
	 * @param position
	 * @return head of the linked list which is a object of Person class 
	 */   
	public static Person addPerson (Person head, Person toAdd, int position) { 
		//Si esta vacio se retorna null
		if (head==null){
			return null;
		}
		if(position==0){ //I used an if to check if position to add is at 0
			toAdd.next=head;//Assign toAdd to head and return toAdd
			return toAdd;
		}
		//I create two new objects, assigning the previous and current head
		Person prev=head;
		Person current=head.next;

		int pos=1;//This int variable is for the the position(i) in the linked list

		while(current !=null){

			if(pos==position-1){//Comparing with the last one
				prev.next=toAdd;////If the position and the previous are identical, I will add
				toAdd.next=current;//update current value (i)
				return head;
			}
			prev=current;//If position for toAdd is not the same as position being looked at the current position to current.next
			current=current.next;
			pos++;//update position in the linked list
		}
		prev.next=toAdd;
		return head; //return the head's value
	} 

    /** 
	 * Change the body of this method to delete a person from the linkedlist
	 * @param head
	 * @param position
	 * @return head
	 */
	public static Person deletePerson (Person head, int position) { 
		if(head==null){//if head is null return null
			return null;
		}
		if(position==0){//This loop will revise if position to delete is at 0
			//assign head to the next position 
			head=head.next;
			return head;
		}

		Person current=head;//assign the current head (i) to a new person object
		int pos=1;//a variable for the position in the linked list

		while (current.next!=null && pos < position-1){//This while loop will go through current position, if the position is less than the position trying to be deleted 
			current=current.next;//current becomes the next position, and deletes the Person(position)
			pos++;//updating the linked list position
		}
		if (current.next!=null){//Si esta vacio se pasa al siguiente y se convierte en la nueva posicion
			current.next=current.next.next;
		}
		
		return head;
	}    

	/**
	 * Change the body of this method to find out who worked most years from the linkedlist
	 * @param head
	 */ 


	//voy aqui
	public static void workedMostYears(Person head) { 
		Person most =head; //Declaring to the head of the list
		Person current=head.next;//This object is assigned to the next position(i)

		while (current!=null){//Revisa que no sea null
			if(most.years<current.years){//Checks if years at the most position is less than current years
				most=current;//the current position is assigned to the most years
			}
			current=current.next;//Se actualiza para la siguiente
		}
		System.out.println("Name: "+ most.getName()+ " Year: "+most.years);
	
	} 


	/**  
	 * Change the body of this method to find out who worked least years from the linkedlist
	 * @param head
	 */ 
	public static void workedLeastYears(Person head) { 
		
		Person least=head;//Este objeto guardara el valor de least years worked y se declara al head of the list
		Person current=head.next;//Assigned to the next position

		while(current!=null){
			if(least.years> current.years){//Check if least years is bigger then current years
				least=current;//Se asigna current a least years
			}
			current=current.next;//Updating to the next position
		}	
		System.out.println("Name: "+ least.getName()+ " Years: "+least.years);
	} 

	/**  
	 * Change the body of this method to find out the average hours all employees worked from the linkedlist
	 * @param head
	 */ 
	public static void averageHoursWorked(Person head) {
		
		double totalHours=0;//Aqui guardare la suma de todas las horas
		double totalPersons=0;//Guardara el numero de persons en la linked list

		while (head!=null){//
			totalHours+=head.hoursWorked;//I am adding the hoursworked in the head position in the variable totalhours
			totalPersons++;//updating the number of persons
			head=head.next;//Update head position to the next
		}
		double averageHours=totalHours/totalPersons;//Compute the average
		System.out.println("Average hours worked: " +averageHours);

	}

	/**  
	  * Change the body of this method to find the total payment each person gets from the linkedlist. 
	  * If a person worked<= 40 hours then he/she will get the hourlyWage for the hours worked. 
	  * If a person worked > 40 hours then he/she will get double the hourlyWage for the overtime. 
	 * @param head
	 */ 
	public static void totalPaymentToEachPerson(Person head) {
		while (head!=null){
			if(head.hoursWorked<=40){
				double totalPayment = head.hoursWorked *head.hourlyWage;//The totalPayment is going to calculate and store the head's hoursworked times hpurlyWge
				System.out.println("Name: "+head.getName() + "\nHours Worked: "+head.hoursWorked+"\nPayment: "+totalPayment);
				System.out.println();
				head=head.next;//Update head i to the next one
			}else if(head.hoursWorked>40){//OVERTIME
				double extraPayment=((head.hoursWorked-40)*head.hourlyWage)*2;//
				double totalPayment=(40*head.hourlyWage)+extraPayment;
				System.out.println("Name: "+head.getName() + "\nHours Worked: "+head.hoursWorked+"\nPayment: "+totalPayment);			
				System.out.println();
				head=head.next;
			}
		}
	}

	/**  
	 * Change the body of this method to add person by checking id if aleady present in the linkedlist
	 * @param head
	 * @param newPerson 
	 * @param position
	 * @return head
	 */ 
	// Extra Credit
	public static Person addPersonByCheckingId(Person head, Person newPerson, int position) {
	
		if(head==null){
			return newPerson;
		}		

		Person temporary = head;//New person object temporary will be assigned to head
		while (temporary!=null){//
			if(temporary.getId()==newPerson.getId()){//Revisara si la actual id position es igual a una existente
				System.out.println("This Id is alredy taken");
				return head;
			}
			temporary=temporary.next;//update temporary to next
		}
		if(position==0){
			newPerson.next=head;//Assigned newPerson to head and return newPerson
			return newPerson;
		}

		Person prev=head;//These two objects will assign the previous and current head (i)
		Person current = head.next;
		int pos = 1;//position in the linked list's int variable

		while(current!=null){//
			if(pos==position){//Compares if the previous position is the same then position
				prev.next=newPerson;//If it is the same position becomes the position for the newPerson
				newPerson.next=current;//Update current position

				System.out.println("A position had being filled with a new person"+position);
				return head;
			}
			prev=current;//If position for newPerson is not the same as position being looked at
			current=current.next;//Update the current position to current.next
			pos++;//update position in the linked list
		}

	return head;
	}

	/** 
	 * Change the body of this method to add persons from the data file to a linkedlist
	 * Change the body of this method to return   
	 * the head of linkedlist of Person, created after reading the file. 
	 * @param filename 
	 * @return head of the created Linked List  
	 */     
	static Person getPersonFromDataFile (String fileName){ 

		Person head=null;
		Person previous = null;

		try{
			
			File myObj = new File (fileName);
			Scanner scanFile = new Scanner (myObj);

			while (scanFile.hasNextLine()){
				String scanLine = scanFile.nextLine();

				String [] split_line = scanLine.split("\t");

				String name = split_line[0];
				int id = Integer.parseInt(split_line[1]);
				double hoursWorked=Double.parseDouble(split_line[2]);
				double wage = Double.parseDouble(split_line[3]);
				int years = Integer.parseInt(split_line[4]);

				Person currentPerson=new Person (name, id, hoursWorked, wage, years);

				if(previous == null){
					head=currentPerson;
					previous=currentPerson;
				}
				else{
					previous.next=currentPerson;
					previous= previous.next;
				}
			}
			scanFile.close();
		}

		catch (FileNotFoundException e){
			System.out.println("An error ocurred");
			e.printStackTrace();
		}
		return head;
	}
	
} 