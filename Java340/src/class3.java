
import java.util.Scanner;

public class class3 {
	public static void main(String[] args) {
//		Scanner inputVal = new Scanner(System.in); 
//		//inputVal是個object，介於鍵盤與程式之間溝通的object
//		//System.in 指向鍵盤之意，new一個scanner就new 一個scanner
//		
//		System.out.println("Enter value? ");
//		int val = inputVal.nextInt();
//		System.out.println(val);
		
		//+=  可以幫char做字元位移
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
		
		inputVal.close();//避免Scanner出現warning
	}
}
