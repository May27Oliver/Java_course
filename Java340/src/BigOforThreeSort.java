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
 �W�Gadd(index,element); addAll(index,Collection);
 �R�Gremove(index);
 ��Gset(index,element);
 �d�Gget(index); subList(from,to); listIterator();
 */

//���Ͱ}�C
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

//���դ�k
class TestTime{
	//�@����t
	void beginMsTest(int[] a){
		//�}�l���q�t��k�ɶ��G
		System.out.printf("\t���]%s�^%n","ms");
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
		//�}�l���q�t��k�ɶ��G
		System.out.printf("\t���]%s�^%n","ns");
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
		//�}�C�j�p
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
	//�`����t
	void nsTest(int[] arr) {
		//�}�C�j�p
		System.out.printf("\t%d\t",arr.length);
		//Bubble Sort
		long startTime = System.nanoTime(); //����}�l�ɶ�
		new Sort().BubbleSort(arr);
		long endTime = System.nanoTime(); //��������ɶ�
		System.out.printf("\t%d\t\t",endTime - startTime);

		//Select Sort
		long startSelectTime = System.nanoTime(); //����}�l�ɶ�
		new Sort().SelectSort(arr);
		long endSelectTime = System.nanoTime(); //��������ɶ�
		System.out.printf("\t%d\t\t",endSelectTime - startSelectTime);

		//Insert sort
		long startInsertTime = System.nanoTime(); //����}�l�ɶ�
		new Sort().InsertSort(arr);
		long endInsertTime = System.nanoTime(); //��������ɶ�
		System.out.printf("\t\t%d\t\t",endInsertTime - startInsertTime);

		//Arrays sort
		long startArraysTime = System.nanoTime(); //����}�l�ɶ�
		Arrays.sort(arr);
		long endArraysTime = System.nanoTime(); //��������ɶ�
		System.out.printf("\t\t%d\t\n",endArraysTime - startArraysTime);
	}
}

//�T�رƧǪk
class Sort {
	//	��w�ƧǪk
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
	
	//	��ܱƧǪk
	int[] SelectSort( int[] arr) {
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
* ���D�@�Astatic�bclass���i�H�ٲ��H
* ���D�G�AnsTest�MmsTest�����Ӧh���ƪ��{���X�A�������L��k��²
* */