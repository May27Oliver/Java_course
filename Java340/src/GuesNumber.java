import java.util.Scanner;

public class GuesNumber {
	public static void main(String[] args) {
		//1. 產生隨機數字
		int rightNum = (int) (Math.random()*100);
		System.out.println(rightNum);
		System.out.println("請猜猜1~99的整數：");
		
		//2. 讓使用者能輸入數字
		Scanner inputScanner  = new Scanner(System.in);
		int maxNum = 99;    //設定最大值初始值
		int minNum = 0;       //設定最小值初始值
		int input = inputScanner.nextInt();
		
		//3. 跑個迴圈，如果使用者答錯重複進入迴圈。
		while(input != rightNum) {
			if ( input > minNum && input < maxNum ) {//先看看使用者輸入的是否在範圍內
				if ( rightNum > input ) 
					minNum = input + 1;
				else if ( rightNum < input ) 
					 maxNum = input - 1;
			} 
			else {
				System.out.println("請輸入正確範圍內的數字！");
			}
			System.out.println( "請輸入 介於 ( " + minNum + " ~ " + maxNum + " )之間的整數");
			input = inputScanner.nextInt();
		}
		
		System.out.println("答對了！");
		inputScanner.close();
	}
}
