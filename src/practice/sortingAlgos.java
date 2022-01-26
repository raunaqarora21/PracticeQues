package practice;

import java.util.Arrays;

public class sortingAlgos {
    static int[] arr;
    public static void main(String[] args) {
        arr = new int[]{4,5,6,1,2,8,7,3};
        mergeSort(0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    private static void mergeSort(int l, int r) {
        if(l < r){
            int mid = l + (r - l)/2;
            mergeSort(l, mid);
            mergeSort(mid + 1, r);
            merge(l,mid, r);
        }
    }
    private static void merge(int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[l + i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid + i + 1];
        }
        int i = 0, j = 0;
        int k = l;
        while(i < n1 && j < n2){
            if(left[i] < right[j]){
                arr[k++] = left[i++];
            }else{
                arr[k++] = right[j++];
            }
        }

        while(i < n1){
            arr[k++] = left[i++];
        }
        while(j < n2){
            arr[k++] = right[j++];
        }


    }

    

    
}
