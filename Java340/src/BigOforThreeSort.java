import java.util.Arrays;

// 小地方, 編碼一般是用 UTF-8， Eclipse 中需要設定一下

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
// 小地方, Java 的慣例命名 class 是首字大寫駝峰式命名
class GenerateArray{
	int[] arrayUWant(int n) {
		int[] a= new int[n];
		for(int i = 0 ; i < a.length ; i++) {
			a[i] = ((int) (Math.random()*n));
			// 下面這兩行可以不用，因為 for 迴圈已經會檢查 i < a.length
			// if(i==a.length-1)
			// 	break;
		}
		return a;
	}
}

//測試方法
class TestTime{

	private final Sort[] sortMethods = new Sort[]{new BubbleSort(), new SelectSort(), new InsertSort(), new ArraySort()};

	//毫秒測速
	void beginMsTest(int[] a){
		//開始測量演算法時間：
		System.out.printf("%10s", "單位（ms）\n");
		System.out.printf("%10s%20s%20s%20s%20s\n", "Size", "Bubble sort", "Selection sort", "Insertion sort", "Arrays.sort");

		// for (int i = 0; i < a.length ; i++) {
		// 	int[] arr = new GenerateArray().arrayUWant(a[i]);
		// 	msTest(arr);
		// }

		// GenerateArray 可以 new 一次就好，原本的寫法會重複建立多個
		// 但因為呼叫的 instance method 沒有用到 member field 所以不用每次都建立新的,
		// 或者宣告成 static method 用也可以
		GenerateArray generateArray = new GenerateArray();
		for (int i = 0; i < a.length ; i++) {
			int[] arr = generateArray.arrayUWant(a[i]);
			System.out.printf("%10d", arr.length);
			for (Sort sortMethod : sortMethods) {
				msTest(arr, sortMethod);
			}
			System.out.println();
		}
	}

	void beginNsTest(int[] a){
		//開始測量演算法時間：
		System.out.printf("%10s", "單位（ns）\n");
		System.out.printf("%10s%20s%20s%20s%20s\n", "Size", "Bubble sort", "Selection sort", "Insertion sort", "Arrays.sort");

		// for (int i = 0; i < a.length ; i++) {
		// 	int[] arr = new GenerateArray().arrayUWant(a[i]);
		// 	nsTest(arr);
		// }

		// 理由同 beginMsTest
		GenerateArray generateArray = new GenerateArray();
		for (int i = 0; i < a.length ; i++) {
			int[] arr = generateArray.arrayUWant(a[i]);
			System.out.printf("%10d",arr.length);
			for (Sort sortMethod : sortMethods) {
				nsTest(arr, sortMethod);
			}
			System.out.println();
		}
	}

	void msTest(int[] arr, Sort sortMethod) {
		//陣列大小
		long startTime = System.currentTimeMillis();
		sortMethod.sort(arr);
		long endTime = System.currentTimeMillis();
		System.out.printf("%20d",endTime - startTime);
	}

	//奈秒測速
	void nsTest(int[] arr, Sort sortMethod) {
		//陣列大小
		long startTime = System.nanoTime(); //獲取開始時間
		sortMethod.sort(arr);
		long endTime = System.nanoTime(); //獲取結束時間
		System.out.printf("%20d",endTime - startTime);
	}
}

//三種排序法
interface Sort {
	int[] sort(int[] arr);
}

class ArraySort implements Sort {
	public int[] sort(int[] arr) {
		Arrays.sort(arr);
		return arr;
	}
}
class BubbleSort implements Sort {
	//	氣泡排序法
	// 小地方, Java 慣例 instance method 命名為首字小寫駝峰式,
	// 所以原本 int[] BubbleSort (int[] arr) 通常命名是 int[] buubleSort(int[] arr)
	// 下面相同就不重複寫
	public int[] sort (int[] arr) {
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
}

class SelectSort implements Sort {
	//	選擇排序法
	// int[] SelectSort( int[] arr) {
	public int[] sort( int[] arr) {
		// min 沒用到?
		// int min;
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
}

class InsertSort implements Sort {
	//	插入排序法
	// int[] InsertSort( int[] arr) {
	public int[] sort( int[] arr) {
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
  這個看不太懂 @@?
* 問題二，nsTest和msTest內有太多重複的程式碼，不知有無方法精簡
  嗯...我覺得簡單的小程式是還好 XD|||, 如果要重複使用算時間的邏輯的話, 我想到的一個方法是用多型處理
* */