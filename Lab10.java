public class Lab6_Madrid_Priscila {
	
	public static void main(String args[]) {
		
		Person head1 = new Person("bob", 1);
		head1.next = new Person("jose", 2);
		head1.next.next = new Person("hannah", 4);
		head1.next.next.next = new Person("angel", 7);
		head1.next.next.next.next = new Person("eve", 8);
		
		Person head2 = new Person("jose", 2);
		head2.next = new Person("alex", 3);
		head2.next.next = new Person("neven", 5);
		head2.next.next.next = new Person("angel", 7);
		
		Person head = mergeSortedLL(head1, head2);
		System.out.println("---------After merge:---------\n");
		printLL(head);
		
		Person new_node = new Person("sillis",6 );
		head = insertInSortedOrder(head, new_node);
		Person new_node2 = new Person("mateo",0 );
		head = insertInSortedOrder(head, new_node2);
		System.out.println("-----After adding new node in sorted order:----\n");
		printLL(head);
		
		head = deleteDuplicate(head);
		System.out.println("-----After deleting duplicates:-----\n");
		printLL(head);
		
		head = reverseLL(head);
		System.out.println("----------After reverse:----------\n");
		printLL(head);
		
		System.out.println("----------Palindromic Names:----------\n");
		printPalindromicNames(head);
		
	}
	

	
	public static void printLL(Person curr) {
		
		if (curr == null)
            return;
 
        System.out.println(curr);
        printLL(curr.next);
	}
	
	/*	Given the two sorted linked list of the person (sorted by id),
	 * Merge the two linked lists of the person into one list where the id is still sorted. */
	
	public static Person mergeSortedLL(Person curr1, Person curr2) {
		{
	        if (curr1 == null)
	            return curr2;
	        if (curr2 == null)
	            return curr1;
	  
	        // start with the linked list
	        // whose head data is the least
	        if (curr1.getId() < curr2.getId()) {
	            curr1.next = mergeSortedLL(curr1.next, curr2);
	            return curr1;
	        }
	        else {
	            curr2.next = mergeSortedLL(curr1, curr2.next);
	            return curr2;
	        }
    	}
		
	}
	
	/* Given the head of a linked list of the Person Class (sorted by ID), 
	 * insert the given node at a position in the linked list, 
	 * so the list remains sorted by ID. 
	 * Do not choose the position manually. 
	 * Rather compare all the linked list ids with the new id 
	 * and insert at correct position.*/
	
	public static Person insertInSortedOrder(Person curr, Person new_node) {
		
		if(curr.next == null){
			curr.next = new_node;
		return curr;
		}

		if(curr.getId()>new_node.getId()){
			new_node.next=curr;
			return new_node;
		}
		if(curr.getId()<= new_node.getId()&&curr.next.getId()>=new_node.getId()){
			new_node.next=curr.next;
			curr.next=new_node;
			return curr;
		}
		insertInSortedOrder(curr.next, new_node);
		return curr;
	}
	
	/*	Given the head of a linked list of the Person Class (sorted by Id), 
	 * delete any Person that has a duplicate Id. 
	 * Compare the Ids only, not the name. 
	 * Hint: As the linked list is sorted by the Ids 
	 * so duplicate Ids will appear next to each other in the list.*/
	
	public static Person deleteDuplicate(Person curr) {
	
		Person nextPerson = null;	
		
		if (curr.next == null){
			return curr;
		}

		else if(curr.getId() != curr.next.getId()){
			nextPerson = curr;	
			nextPerson.next = deleteDuplicate(curr.next);	
		}

		else{	
			return deleteDuplicate(curr.next);
		}
		
		return nextPerson;
	}
	
	//	Given the head of a linked list of the Person Class, reverse the linked list. 		
	//	Linked Llist: (head) person1->person2->person3->person4->null
	//	reverseLL(head) → person4->person3->person2->person1->null
	
	public static Person reverseLL(Person curr) {
		
        if (curr == null ){
			return curr;
		}
		if(curr.next==null){
			return curr;
		}

		//Le asigno el siguiente curr al Person
		Person reversedPerson = reverseLL(curr.next);	

		curr.next.next = curr;	
		curr.next = null;

		return reversedPerson; 
	}
	
	/* Given the head of a linked list of Person class, 
	 * print all the palindromic names of Person */
	
	public static boolean isPalindrome(String name, int start, int end) {
		  
		if(start >= end){
			return true;
		}

		if(name.charAt(start)== name.charAt(end)){
			return isPalindrome(name, start+1, end-1);
		}
        return false;

	}
	
	// Recursively traverse the linked list and call isPalindrome for the name of each Person.
	public static void printPalindromicNames(Person curr) {
		
		if(isPalindrome (curr.getName(), 0, curr.getName().length()-1)){
			System.out.println(curr.getName()+" is a Palindrome.");
		}

		if(curr == null || curr.next == null){
			return;
		}
		printPalindromicNames(curr.next);
		
	}
	
}
