import java.util.Scanner;

public class GuesNumber {
	public static void main(String[] args) {
		//1. �����H���Ʀr
		int rightNum = (int) (Math.random()*100);
		System.out.println(rightNum);
		System.out.println("�вq�q1~99����ơG");
		
		//2. ���ϥΪ̯��J�Ʀr
		Scanner inputScanner  = new Scanner(System.in);
		int maxNum = 99;    //�]�w�̤j�Ȫ�l��
		int minNum = 0;       //�]�w�̤p�Ȫ�l��
		int input = inputScanner.nextInt();
		
		//3. �]�Ӱj��A�p�G�ϥΪ̵������ƶi�J�j��C
		while(input != rightNum) {
			if ( input > minNum && input < maxNum ) {//���ݬݨϥΪ̿�J���O�_�b�d��
				if ( rightNum > input ) 
					minNum = input + 1;
				else if ( rightNum < input ) 
					 maxNum = input - 1;
			} 
			else {
				System.out.println("�п�J���T�d�򤺪��Ʀr�I");
			}
			System.out.println( "�п�J ���� ( " + minNum + " ~ " + maxNum + " )���������");
			input = inputScanner.nextInt();
		}
		
		System.out.println("����F�I");
		inputScanner.close();
	}
}
