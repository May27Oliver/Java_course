
public class SumUp {

	public static void main(String[] args) {
		int sum = 0;
		int a = 1;
		
		while(a <= 100) {
			sum += a;
			a++;
		}
		
		System.out.println( "while�`�@�O�G" + sum );
		sum = 0;
		for  ( int i = 1 ; i <= 100   ; ++i ) {
			sum +=  i;
		}
		
		System.out.println("for�`�@�O�G"  +  sum );
	}

}
