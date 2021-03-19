import java.util.List;
import java.util.Collections;
import java.util.Arrays;

public class CovidIsolate {
    public static void main(String[] args){
        //產生一組公民
        GenerateID camp = new GenerateID();
        int[] citizens = camp.generate(camp.citizens);
        int[] connection = camp.generate(camp.connection);
        new ShuffleTheArray().shuffleFactory(connection);
    }
}

//集中檢疫公民的class與其聯繫關係
class GenerateID{
    int[] citizens =  new int[15];
    int[] connection = new int[15];

    static int[] generate(int[] a){
        for ( int i = 0; i<a.length; i++){
            a[i] = i + 1 ;
        }
        return a;
    }
}
//array在java中有int[]，array，List三種模式
//查詢這些公民之間的聯繫關係
class ShuffleTheArray {
    static int[] shuffleFactory(int[] a){
        List<int[]> intList = Arrays.asList(a);
        System.out.println(intList.get(0));
//        Collections.shuffle(intList);
//        intList.toArray(a);
        return a;
    }
}