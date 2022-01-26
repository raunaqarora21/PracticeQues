package dpAss;

import java.util.Scanner;

public class histogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = sc.nextInt();
        }
        int ans = largestRectangleArea(heights);
        System.out.println(ans);
        sc.close();
    }

    private static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = -1;
        right[n - 1] = n;
        int ans = 0;

        //finding less on left
        for (int i = 1; i < left.length; i++) {
            int p = i - 1;
            while(p >= 0 && heights[p] >= heights[i]){
                p = left[p];
            }
            left[i] = p;
        }

        //finding less from right
        for (int i = n - 2; i >= 0; i--) {
            int p = i + 1;
            while(p < n && heights[p] >= heights[i]){
                p = right[p];
            }
            right[i] = p;
            
        }

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, heights[i] * (right[i] - left[i] - 1));
        }   

        return ans;
    }
    
}
