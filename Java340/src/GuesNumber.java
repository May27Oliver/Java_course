import java.util.InputMismatchException;
import java.util.Scanner;

public class GuesNumber {
	public static void main(String[] args) {
		//1. �����H���Ʀr
		int rightNum = (int) (Math.random()*100);
		System.out.println("�A�ݤ���A�ݤ��쥿�T�Ʀr�O�G" + rightNum);
		System.out.println("�вq�q1~99����ơA���A5�����D���|�G");
		//2. ���ϥΪ̯��J�Ʀr
		Scanner inputScanner  = new Scanner(System.in);
		int maxNum = 99;    //�]�w�̤j�Ȫ�l��
		int minNum = 0;       //�]�w�̤p�Ȫ�l��
		int times = 0;			//�]�w��l���
		
		while ( true ) { //3. �]�Ӱj��A�p�G�ϥΪ̵������ƶi�J�j��C
			if ( times > 7) {
				System.out.println("���D���ƨ�F�W���I");
				break;
			}else if( (maxNum - minNum ) < 3) {
				System.out.println("�i�ﵪ�ץu�ѥ��T���סA�C������....");
				break;
			}
			try {
				int input = inputScanner.nextInt();
				if ( input == rightNum ) { //��������j��
					System.out.println("����F�I");
					break;
				}
				else if ( input > minNum && input < maxNum ){ //���ݬݨϥΪ̿�J���O�_�b�d��
					if ( rightNum > input ) 
						minNum = input + 1;
					else if ( rightNum < input ) 
						 maxNum = input - 1;
				}else {
					System.out.println("�п�J���T�d�򤺪��Ʀr�I");
				}
				System.out.println( "�п�J ���� ( " + minNum + " ~ " + maxNum + " )���������");
				++times;
			}catch( InputMismatchException ex) {
				System.out.printf("�п�J��ƼƦr�I" , inputScanner .next());
			}
		}
		System.out.println("���׬O" + rightNum);
		inputScanner.close();
	}
}
