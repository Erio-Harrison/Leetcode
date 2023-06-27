package src;

public class Lee263 {
    public static boolean isUgly(int n) {
        if(n<=0){
            return false;
        }
        int[] divisors = {2,3,5};
        for(int d:divisors){
            while(n%d==0){
                n/=d;
            }
        }
        return n==1;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(14));
    }
}
