
public class SumUp {

	public static void main(String[] args) {
//		int a = 1;
		int sum = 0;
//		while(a <= 100) {
//			sum += a;
//			a++;
//		}
//		
//		System.out.println( "while總共是：" + sum );
//		
//		sum = 0;
		
		for  ( int a = 1 ; 100 <= a ; ++a ) {
			System.out.println("執行");
			sum +=  a;
		}
		
		System.out.println("for總共是："  +  sum );
	}

}
