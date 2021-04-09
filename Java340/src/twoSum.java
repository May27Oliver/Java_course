import java.util.*;

public class twoSum {
    public static void main(String[] args) {
        int[] apple = {2, 4, 6, 5, 7, 8, 9, 33, 64, 34};
//      twSumN2(apple,36);
//        twoSumList(apple,36);
        twoSumN(apple,36);
    }
    //O(n ^ 2)
    public static int[] twSumN2(int[] num, int target){
        int[] res = new int[2];
        for(int i = 0 ; i < num.length ; i++){
            for(int j = i + 1 ; j < num.length ; j++) {
                if (num[i] + num[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    System.out.printf("%s, %s", i , j );
                    return res;
                }
            }
        }
        return res;
    }
    //實際上還是O(n ^ 2)
    public static int[] twoSumList(int[] nums, int target){
        int len = nums.length;
        int[] result = new int[2];
        List list = new ArrayList<>();
        System.out.print(list);
        for(int i = 0; i < len; i++){
            int v = nums[i];
            int id = list.indexOf(target-v);
            if(id >= 0){
                result[0] = id ;
                result[1] = i;
                System.out.printf("%s, %s", i , id );
                return result;
            }else {
                list.add(nums[i]);
            }
        }
        return result;
    }


    //哈希表HashTable：對應key:value的集合，簡單說就是js的物件，可以實現搜尋O(n)速度
    public static int[] twoSumN(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i = 0;i < nums.length; i++){
            if(map.containsKey(nums[i])){
                res[0]=i;
                res[1]=map.get(nums[i]);
                System.out.printf("%s, %s",res[0],res[1]);
                return res;
            }else{
                map.put(target - nums[i], i);
            }
        }
        return res;
    }
}
