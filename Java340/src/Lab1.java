import java.util.Scanner;
import java.util.Random;

public class Lab1 {
	public static void main(String[] args) {
		double random = Math.round(Math.random()*100);//����1~100�H����
		System.out.println((int) random);//�N�o�ӼƦr�ഫ���O��int
		
		int int1;
		Scanner scanner = new Scanner(System.in);
		System.out.println("�п�J�Ĥ@�ӯB�I�ơG");
		int1 = scanner.nextInt();
		System.out.println("�Ĥ@�ӯB�I�Ƭ�" + int1);
	}
}
