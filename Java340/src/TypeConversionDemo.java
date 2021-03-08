
public class TypeConversionDemo {

	public static void main(String[] args) {
		int x = 1;
		double y = x;
		x = (int) y ; //casting強制轉換y為int，寫法如左 cast :(target type)
		//int 可以assign給double
		//double不能Assign給int
		
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
