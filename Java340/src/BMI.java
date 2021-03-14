import java.util.Scanner;

public class BMI {

	public static void main(String[] args) {
		System.out.println("請輸入體重（kg）：");
		Scanner weightScanner = new Scanner(System.in);
		double weight = weightScanner.nextDouble();
		
		System.out.println("請輸入身高（cm）：");
		Scanner heightScanner = new Scanner(System.in);
		double height = heightScanner.nextDouble()/100;
		
		double bmi = weight /(height*height);
		
		System.out.println("BMI值為："+bmi);
		
		weightScanner.close();

	}

}
