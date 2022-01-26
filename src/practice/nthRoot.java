package practice;

public class nthRoot {

    public static void main(String[] args) {
        int n = 2;
        int m = 64;
       
        System.out.println(getRoot(n,m));
    }

    private static double getRoot(int n, int m) {

        double low = 1;
        double high = m;
        double eps = 1e-6;
        while((high - low) > eps){
            double mid = (low + high)/2.0;
            double mul = multiply(mid, n);
            if(mul >= m){
                high = mid;
            }else{
                low = mid;
            }
        }
        return low;


    }

    private static double multiply(double mid, int n) {
        double ans = 1.0;
        for (int i = 1; i <= n; i++) {
            ans *= mid;    
        }
        return ans;
    }
    
}
