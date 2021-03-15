import java.util.Scanner;
import java.util.Random;

public class Lab1 {
	public static void main(String[] args) {
		double random = Math.round(Math.random()*100);//產生1~100隨機數
		System.out.println((int) random);//將這個數字轉換型別為int
		
		int int1;
		Scanner scanner = new Scanner(System.in);
		System.out.println("請輸入第一個浮點數：");
		int1 = scanner.nextInt();
		System.out.println("第一個浮點數為" + int1);
	}
}
