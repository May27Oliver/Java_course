public class Lab04homework {
    public static void main(String[] args){
        System.out.printf("%10s%20s%n" , "O(logN) ","O(N) ");
        double t0 = System.nanoTime() / 1e6;
        seperatePow(2,10);//x ^ n
        double t1 = System.nanoTime() / 1e6;
        System.out.printf("%10f", t1 - t0 );

        t0 = System.nanoTime() / 1e6;
        countPow(2,10);
        t1 = System.nanoTime() / 1e6;
        System.out.printf("%20f", t1 - t0 );
    }

    public static long countPow(long x, int n){
        if(n == 1){
            return x;
        }else{
            return (long)(x * countPow(x,n-1));
        }
    }

    public static long beginner = 1;
    public static long seperatePow(long x, int n){

        //方法一，相依在countPow上
//        long result;
//        if(n % 2 == 1){
//            result = countPow(x,n/2);
//            result = result * result * x;
//        }else{
//            result = countPow(x,n/2);
//            result = result * result;
//        }
//        return result;

        //方法二，相依在一個全域變數上
        if(n==1){
            return x * beginner;
        }else if(n==2){
            return x * x * beginner;
        }else if(n % 2 == 1){
            beginner = x;
        }
        return seperatePow(x * x ,n / 2);
    }
}