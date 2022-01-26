package dpAss;

import java.util.Scanner;

public class binaryString {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();

            long a[] = new long[n];
            long b[] = new long[n];
            a[0] = b[0] = 1;
            for (int i = 1; i < n; i++) {
                a[i] = a[i - 1] + b[i - 1];
                b[i] = a[i - 1];
            }
            System.out.println(a[n - 1] + b[n - 1]);
            
           
        }
        sc.close();
    }

   
    
}
