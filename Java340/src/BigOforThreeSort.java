import java.util.ArrayList;
import java.util.Arrays;

public class BigOforThreeSort {

	public static void main(String[] args) {
		//�}�l���q�t��k�ɶ��G
		// n=1000;
		System.out.printf("\t%s\t","Size");
		System.out.printf("\t%s\t","Bubble sort");
		System.out.printf("\t%s\t","Selection sort");
		System.out.printf("\t%s\t","Insertion sort");
		System.out.printf("\t%s\t\n","Arrays.sort ");
		
		int [] testScale = {1000,2000,4000,8000,16000,32000,64000};
		for (int i = 0; i < testScale.length ; i++) {
			int[] a = new generateArray().arrayUWant(testScale[i]);
			new TestTime().Test(a);
		}
	}
}

/*
 ArrayList 
 �W�Gadd(index,element); addAll(index,Collection);
 �R�Gremove(index);
 ��Gset(index,element);
 �d�Gget(index); subList(from,to); listIterator();
 */
class generateArray{
	static int[] arrayUWant(int n) {
		int[] a= new int[n];
		for(int i = 0 ; i < a.length ; i++) {
			a[i] = ((int) (Math.random()*n));
			if(i==a.length-1) 
				break;
		}
		return a;
	}
}

class TestTime{
	static void Test(int[] arr) {
		//�}�C�j�p
		System.out.printf("\t%d\t",arr.length);
		
		//Bobble Sort
		double startTime = System.currentTimeMillis(); //����}�l�ɶ�
		new Sort().BubbleSort(arr);
		double endTime = System.currentTimeMillis(); //��������ɶ�
		System.out.printf("%f\t",endTime - startTime);
		
		//Select Sort
		startTime = System.currentTimeMillis(); //����}�l�ɶ�
		new Sort().SelectSort(arr);
		endTime = System.currentTimeMillis(); //��������ɶ�
		System.out.printf("\t%f\t",endTime - startTime);
		
		//Insert sort
		startTime = System.currentTimeMillis(); //����}�l�ɶ�
		new Sort().InsertSort(arr);
		endTime = System.currentTimeMillis(); //��������ɶ�
		System.out.printf("\t%f\t\t",endTime - startTime);
		
		//Arrays sort
		startTime = System.currentTimeMillis(); //����}�l�ɶ�
		Arrays.sort(arr);
		endTime = System.currentTimeMillis(); //��������ɶ�
		System.out.printf("\t%f\t\n",endTime - startTime);
	}
}

class Sort {
	//	��w�ƧǪk
	static int[] BubbleSort (int[] arr) {
			int n = arr.length;
			int temp = 0;
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
	
	//	��ܱƧǪk
	static int[] SelectSort( int[] arr) {
		int min;
		for( int i = 0; i < arr.length ; i++) {
			int m = i;//���]�̤p�ȯ��ެOi
			int temp;
			for (int j = i + 1; j < arr.length ; j++) {
				//��M�̤p��
				if(arr[j] < arr[m]) {
					m = j;
				} 
			}
			//�p�G�̤p��index���ܫh�󴫦�m
			if( i != m ) {
				temp = arr[i];
				arr[i] = arr[m];
				arr[m] = temp;
			}
		}
		return arr ;
	}
	
	//	���J�ƧǪk
	static int[] InsertSort( int[] arr) {
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