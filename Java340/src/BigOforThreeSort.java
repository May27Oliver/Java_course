import java.util.Arrays;

public class BigOforThreeSort {
    public static void main(String[] args){
        int[] testScale = {1000,2000,4000,8000,16000,32000,64000};
        TestTime startTest = new TestTime();
        startTest.beginMsTest(testScale);
        startTest.beginNsTest(testScale);
    }
}

//���Ͱ}�C
// �p�a��, Java ���D�ҩR�W class �O���r�j�g�m�p���R�W
class GenerateArray{
    int[] arrayUWant(int n) {
        int[] a= new int[n];
        for(int i = 0 ; i < a.length ; i++) {
            a[i] = ((int) (Math.random()*n));
        }
        return a;
    }
}

//���դ�k
class TestTime{
    private final Sort[] sortMethods = new Sort[]{new BubbleSort(), new SelectSort(), new InsertSort(), new ArraySort()};

    //�@����t
    void beginMsTest(int[] a){
        //�}�l���q�t��k�ɶ��G
        System.out.printf("%10s", "���]ms�^\n");
        System.out.printf("%10s%20s%20s%20s%20s\n", "Size", "Bubble sort", "Selection sort", "Insertion sort", "Arrays.sort");

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
        //�}�l���q�t��k�ɶ��G
        System.out.printf("%10s", "���]ns�^\n");
        System.out.printf("%10s%20s%20s%20s%20s\n", "Size", "Bubble sort", "Selection sort", "Insertion sort", "Arrays.sort");

        // for (int i = 0; i < a.length ; i++) {
        // 	int[] arr = new GenerateArray().arrayUWant(a[i]);
        // 	nsTest(arr);
        // }

        // �z�ѦP beginMsTest
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
        //�}�C�j�p
        long startTime = System.currentTimeMillis();
        sortMethod.sort(arr);
        long endTime = System.currentTimeMillis();
        System.out.printf("%20d",endTime - startTime);
    }

    //�`����t
    void nsTest(int[] arr, Sort sortMethod) {
        //�}�C�j�p
        long startTime = System.nanoTime(); //����}�l�ɶ�
        sortMethod.sort(arr);
        long endTime = System.nanoTime(); //��������ɶ�
        System.out.printf("%20d",endTime - startTime);
    }
}


//�T�رƧǪk
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
    //	��w�ƧǪk
    // �p�a��, Java �D�� instance method �R�W�����r�p�g�m�p��,
    // �ҥH�쥻 int[] BubbleSort (int[] arr) �q�`�R�W�O int[] bubbleSort(int[] arr)
    // �U���ۦP�N�����Ƽg
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
    //	��ܱƧǪk
    // int[] SelectSort( int[] arr) {
    public int[] sort( int[] arr) {
        // min �S�Ψ�?
        // int min;
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
}

class InsertSort implements Sort {
    //	���J�ƧǪk
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

// �P��@blackdiz����