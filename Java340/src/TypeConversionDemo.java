
public class TypeConversionDemo {

	public static void main(String[] args) {
		int x = 1;
		double y = x;
		x = (int) y ; //casting�j���ഫy��int�A�g�k�p�� cast :(target type)
		//int �i�Hassign��double
		//double����Assign��int
		
		byte a = 6;
		short b = 5;
        int c = 4;
        long d = 3;
        float e = 2.5f;
        double f = 1.5;
         
        System.out.println(a / b);
        System.out.println(c / e);
        System.out.println(d / f);
	}

}
