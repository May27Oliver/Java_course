import java.util.Scanner;

public class BMI {

	public static void main(String[] args) {
		System.out.println("�п�J�魫�]kg�^�G");
		Scanner weightScanner = new Scanner(System.in);
		double weight = weightScanner.nextDouble();
		
		System.out.println("�п�J�����]cm�^�G");
		Scanner heightScanner = new Scanner(System.in);
		double height = heightScanner.nextDouble()/100;
		
		double bmi = weight /(height*height);
		
		System.out.println("BMI�Ȭ��G"+bmi);
		
		weightScanner.close();

	}

}
