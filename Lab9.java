import java.io.*;

public class Lab5_Madrid_Priscila { 
	public static void main(String[] args){ 
		System.out.println();

		System.out.println("CAMEL CASE (Hello World)");
		System.out.println("Iterative Method 1");
		method1Iterative("Hello World");
		System.out.println("Recursive Method 1");
		System.out.println(method1Recursive("Hello World", 0));
		
		System.out.println();
		System.out.println("POWER N (3,3)");
		System.out.println("Iterative Method 2");
		method2Iterative(3, 3);
		System.out.println("Recursive Method 2");
		System.out.println(method2Recursive(3, 3));

		System.out.println();
		System.out.println("CLEAN STRING (Hello)");
		System.out.println("Iterative Method 3");
		method3Iterative("Hello");
		System.out.println("Recursive Method 3");
		System.out.println(method3Recursive("Hello"));

		System.out.println();
		System.out.println("ALL STAR (Hello)");
		System.out.println("Iterative Method 4");
		method4Iterative("Hello");
		System.out.println("Recursive Method 4");
		System.out.println(method4Recursive("Hello"));

		System.out.println();
		System.out.println("COUNT HI (xxhixx)");
		System.out.println("Iterative Method 5");
		method5Iterative("xxhixx");
		System.out.println("Recursive Method 5");
		System.out.println(method5Recursive("xxhixx"));

		System.out.println();
		System.out.println("REVERSE ORDER (s5f)");
		System.out.println("Iterative Method 6");
		method6Iterative("s5f");
		System.out.println("Recursive Method 6");
		System.out.println(method6Recursive("s5f"));

		//method7Iterative(a, b);
		//method7Recursive(a, b);

	}

		/*Given a string, produce a camelCase version of the string,
		e.g., camelCase("Hello World") → hElEo wOrLd*/
		
		public static void method1Iterative(String camelCase) { 
			String newString="";
			String original = camelCase;

		for(int i=0; i<camelCase.length(); i++){
				if(i%2!=0){
					camelCase=camelCase.toUpperCase();
					newString+=camelCase.charAt(i);
				}else if(i%2==0){
					camelCase=camelCase.toLowerCase();
					newString+=camelCase.charAt(i);
					}
				}
			System.out.println(newString);
		}

		public static String method1Recursive(String input, int startIndex){
			String newString = "";
			//base case
			//Stops method when startIndex reaches the end of the string
			if(startIndex == input.length()){
				return newString;//Aqui se va a detener el metodo
			}
			else{
				//Turns the indexes to lowercase if startIndex is even
				if(startIndex%2==0){
					input= input.toLowerCase();
					newString+=input.charAt(startIndex);
				}
				//Turns the indexes to uppercase if startIndex is odd
				else if(startIndex%2==1){
					input = input.toUpperCase();
					newString +=input.charAt(startIndex);
				}
				//recursive call
				return newString += method1Recursive(input, startIndex+1);
			}
			
		}

		/*Given base and n that are both 1 or more, compute 
		the value of base to the n power, e.g.,*/

		public static void method2Iterative(int a, int b) { 

			int power = a;
			for(int i=1; i<b; i++){
				power = power*a;

			}
			System.out.println(power);
		}
		
		public static int method2Recursive(int a, int b) { 
			if (b != 0){
			    return a * method2Recursive(a, b-1);//recursive call
			}
		    else{
		        return 1;
		    }
		}

		/*Given a string, return a "cleaned" string where adjacent 
		chars that are the same have been reduced to a single char. e.g., 
		stringClean("yyzzza") → "yza"*/

	   public static void method3Iterative(String s){
				String stringClean="";

				for (int i=0; i<s.length(); i++){
					char charAtPosition = s.charAt(i);
					if(stringClean.indexOf(charAtPosition)<0){//Returns the index of the first (last) occurrence of the specified character.
						stringClean+=charAtPosition;
					}
				}
			System.out.println(stringClean);
		}
		
		public static String method3Recursive(String s){
			if ( s.length() <= 1 ) {
            return s;
	        }
	        if( s.substring(1,2).equals(s.substring(0,1)) ) {
	            return method3Recursive(s.substring(1));
	        }
	        else{
	             return s.substring(0,1) + method3Recursive(s.substring(1));
	        }
		}

		/*Given a string, compute recursively a new string where all the 
		adjacent chars are now separated by a "*".	
		E.g. allStar("hello") → "h*e*l*l*o"*/
		public static void method4Iterative(String s){
		String allStar="*";

		for (int i=0; i<s.length(); i++){
		    char charAtPosition = s.charAt(i);
		        if(s != null){
		        	System.out.print(s.charAt(i)+allStar);
		        }
			}
		}
   
		//The contains() method checks whether a string contains a sequence of characters.
		public static String method4Recursive(String s){
		
		if(s.length()<1){
			  return "";   
		}
	        if(s.length() == 1) {
	            return s+"*";
	        }
	        return s.charAt(0)+"*"+method4Recursive(s.substring(1));
		}

		/*Given a string, compute recursively (no loops) the number of 
		times lowercase "hi" appears in the string. countHi("xxhixx") → 1*/
		public static void method5Iterative(String s){
    	int countHi=0;
    	int index = 0;
	
    	for (int i = 0; i <= s.length(); i++){
	    	    index++;
	    	    if (index > s.length()){
	    	        break;
	    	    }
	    	    if (s.charAt(i) == 'h' && s.charAt(i+1) == 'i'){
	    	        countHi++;
	    	    }
	    	}
		    System.out.println(countHi);
	    } 
			
		public static int method5Recursive(String s){
		if(s.length()<=1) return 0;
			else{
			    if(s.length()>=2&&s.substring(0,2).equals("hi")){
			        return 1+ method5Recursive(s.substring(2));
			    }else{
			        return method5Recursive(s.substring(1));
			    }
			}
	    }

		/* Print the letters in reverse order.Given a string, recursively 
		(no loops) print only the letters in reverse order. 
		printLetters("s5f") → fs*/

    public static void method6Iterative(String s){

			String reverse=" ";
			char ch;
			
			for (int i=s.length()-1; i>-1; i--){
			    if (s.charAt(i) > 'a' && s.charAt(i) < 'z'){
			    ch = s.charAt(i);
			    reverse += ch;
			    }
		}
		System.out.println(reverse);
	}

	public static String method6Recursive(String s){
        
       if(s==null||s.length()<=1){
           return s;
       }
       return method6Recursive (s.substring(1))+s.charAt(0);
	}

		/*Print a sequence of numbers.Given an integer number (N), print a 
		sequence of numbers (using recursion) starting with N where x[0] = N, 
		in which x[i+1] = x[i] - 2, until x[i] >= 0. After that x[i+1] = x[i] + 2 
		repeat it until x[i] = N printSequence(5) → 5 3 1 3 5*/
		
		//public static void method7Iterative(){

		//}
		
		/*public static int method7Recursive(){

		}*/

}

	