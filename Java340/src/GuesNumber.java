import java.util.InputMismatchException;
import java.util.Scanner;

public class GuesNumber {
	public static void main(String[] args) {
		//1. 產生隨機數字
		int rightNum = (int) (Math.random()*100);
		System.out.println("你看不到你看不到正確數字是：" + rightNum);
		System.out.println("請猜猜1~99的整數，給你5次答題機會：");
		//2. 讓使用者能輸入數字
		Scanner inputScanner  = new Scanner(System.in);
		int maxNum = 99;    //設定最大值初始值
		int minNum = 0;       //設定最小值初始值
		int times = 0;			//設定初始圈數
		
		while ( true ) { //3. 跑個迴圈，如果使用者答錯重複進入迴圈。
			if ( times > 7) {
				System.out.println("答題次數到達上限！");
				break;
			}else if( (maxNum - minNum ) < 3) {
				System.out.println("可選答案只剩正確答案，遊戲中止....");
				break;
			}
			try {
				int input = inputScanner.nextInt();
				if ( input == rightNum ) { //答對脫離迴圈
					System.out.println("答對了！");
					break;
				}
				else if ( input > minNum && input < maxNum ){ //先看看使用者輸入的是否在範圍內
					if ( rightNum > input ) 
						minNum = input + 1;
					else if ( rightNum < input ) 
						 maxNum = input - 1;
				}else {
					System.out.println("請輸入正確範圍內的數字！");
				}
				System.out.println( "請輸入 介於 ( " + minNum + " ~ " + maxNum + " )之間的整數");
				++times;
			}catch( InputMismatchException ex) {
				System.out.printf("請輸入整數數字！" , inputScanner .next());
			}
		}
		System.out.println("答案是" + rightNum);
		inputScanner.close();
	}
}
