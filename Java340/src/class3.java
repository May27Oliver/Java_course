
import java.util.Scanner;

public class class3 {
	public static void main(String[] args) {
//		Scanner inputVal = new Scanner(System.in); 
//		//inputVal�O��object�A������L�P�{���������q��object
//		//System.in ���V��L���N�Anew�@��scanner�Nnew �@��scanner
//		
//		System.out.println("Enter value? ");
//		int val = inputVal.nextInt();
//		System.out.println(val);
		
		//+=  �i�H��char���r���첾
//		char  s =  'a';
//		System.out.println(s);
//		System.out.println(s); // Output a.
//		s += 1;
//		 System.out.println(s); // Output b.
//		 s++;
//		 System.out.println(s); // Output c.
		
		//Math.random
		int x = (int) (Math.random()*10 );
		int y = (int) (Math.random()*10);
		System.out.println( x + " +" +  y + "= ? " ) ;
		
		//Enter an interger from KB
		Scanner inputVal = new Scanner(System.in);
		
		int  input = inputVal.nextInt();
		
		if(input == x+y) {
				System.out.println("Correct!");
		}
		else {
			System.out.println("Wrong Answer.");
			System.out.println("The answer is " + (x +y)+".");
		}
		
		inputVal.close();//�קKScanner�X�{warning
	}
}
