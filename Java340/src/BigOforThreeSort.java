import java.util.ArrayList;
import java.util.Arrays;

public class BigOforThreeSort {
	public static void main(String[] args) {
		int [] testScale = {1000,2000,4000,8000,16000,32000,64000};
		TestTime startTest = new TestTime();
		startTest.beginMsTest(testScale);
		startTest.beginNsTest(testScale);
	}
}

/*
 ArrayList 
 增：add(index,element); addAll(index,Collection);
 刪：remove(index);
 改：set(index,element);
 查：get(index); subList(from,to); listIterator();
 */

//產生陣列
class generateArray{
	int[] arrayUWant(int n) {
		int[] a= new int[n];
		for(int i = 0 ; i < a.length ; i++) {
			a[i] = ((int) (Math.random()*n));
			if(i==a.length-1) 
				break;
		}
		return a;
	}
}

//測試方法
class TestTime{
	//毫秒測速
	void beginMsTest(int[] a){
		//開始測量演算法時間：
		System.out.printf("\t單位（%s）%n","ms");
		System.out.printf("\t%s\t","Size");
		System.out.printf("\t%s\t","Bubble sort");
		System.out.printf("\t%s\t","Selection sort");
		System.out.printf("\t%s\t","Insertion sort");
		System.out.printf("\t%s\t\n","Arrays.sort ");

		for (int i = 0; i < a.length ; i++) {
			int[] arr = new generateArray().arrayUWant(a[i]);
			msTest(arr);
		}
	}

	void beginNsTest(int[] a){
		//開始測量演算法時間：
		System.out.printf("\t單位（%s）%n","ns");
		System.out.printf("\t%s\t","Size");
		System.out.printf("\t%s\t","Bubble sort");
		System.out.printf("\t%s\t","Selection sort");
		System.out.printf("\t%s\t","Insertion sort");
		System.out.printf("\t%s\t\n","Arrays.sort ");

		for (int i = 0; i < a.length ; i++) {
			int[] arr = new generateArray().arrayUWant(a[i]);
			nsTest(arr);
		}
	}

	void msTest(int[] arr) {
		//陣列大小
		System.out.printf("\t%d\t\t",arr.length);
		//Bubble Sort
		long startTime = System.currentTimeMillis();
		new Sort().BubbleSort(arr);
		long endTime = System.currentTimeMillis();
		System.out.printf("%d\t\t\t\t",endTime - startTime);
		
		//Select Sort
		long startSelectTime = System.currentTimeMillis();
		new Sort().SelectSort(arr);
		long endSelectTime = System.currentTimeMillis();
		System.out.printf("\t%d\t\t\t",endSelectTime - startSelectTime);
		
		//Insert sort
		long startInsertTime = System.currentTimeMillis();
		new Sort().InsertSort(arr);
		long endInsertTime = System.currentTimeMillis();
		System.out.printf("\t%d\t\t\t\t",endInsertTime - startInsertTime);

		//Arrays sort
		long startArraysTime = System.currentTimeMillis();
		Arrays.sort(arr);
		long endArraysTime = System.currentTimeMillis();
		System.out.printf("\t%d\t\n", endArraysTime - startArraysTime);
	}
	//奈秒測速
	void nsTest(int[] arr) {
		//陣列大小
		System.out.printf("\t%d\t",arr.length);
		//Bubble Sort
		long startTime = System.nanoTime(); //獲取開始時間
		new Sort().BubbleSort(arr);
		long endTime = System.nanoTime(); //獲取結束時間
		System.out.printf("\t%d\t\t",endTime - startTime);

		//Select Sort
		long startSelectTime = System.nanoTime(); //獲取開始時間
		new Sort().SelectSort(arr);
		long endSelectTime = System.nanoTime(); //獲取結束時間
		System.out.printf("\t%d\t\t",endSelectTime - startSelectTime);

		//Insert sort
		long startInsertTime = System.nanoTime(); //獲取開始時間
		new Sort().InsertSort(arr);
		long endInsertTime = System.nanoTime(); //獲取結束時間
		System.out.printf("\t\t%d\t\t",endInsertTime - startInsertTime);

		//Arrays sort
		long startArraysTime = System.nanoTime(); //獲取開始時間
		Arrays.sort(arr);
		long endArraysTime = System.nanoTime(); //獲取結束時間
		System.out.printf("\t\t%d\t\n",endArraysTime - startArraysTime);
	}
}

//三種排序法
class Sort {
	//	氣泡排序法
	int[] BubbleSort (int[] arr) {
			int n = arr.length;
			int temp;
			for (int i = 0 ; i < n ;i++) {
				for (int j = 1; j < ( n - i ); j++) {
					if( arr[ j - 1 ] > arr[ j ] ) {
						temp = arr[ j - 1 ];
						arr[ j - 1 ] = arr[ j ];
						arr[ j ] = temp;
					}
				}
			}
			return arr;
	}
	
	//	選擇排序法
	int[] SelectSort( int[] arr) {
		int min;
		for( int i = 0; i < arr.length ; i++) {
			int m = i;//假設最小值索引是i
			int temp;
			for (int j = i + 1; j < arr.length ; j++) {
				//找尋最小值
				if(arr[j] < arr[m]) {
					m = j;
				} 
			}
			//如果最小的index有變則更換位置
			if( i != m ) {
				temp = arr[i];
				arr[i] = arr[m];
				arr[m] = temp;
			}
		}
		return arr ;
	}
	
	//	插入排序法
	int[] InsertSort( int[] arr) {
		int temp;
		for (int i = 1 ; i < arr.length ; i++) {
			temp = arr[i];
			
			int j = i - 1;
			while( j >= 0 && temp < arr[ j ]) {
				arr[ j + 1 ] = arr[ j ];
				j-- ;
			}
			arr[ j+1 ] = temp;
		}
		return arr;
	}
}

/*
* 問題一，static在class內可以省略？
* 問題二，nsTest和msTest內有太多重複的程式碼，不知有無方法精簡
* */