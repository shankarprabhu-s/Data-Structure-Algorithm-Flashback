package Sorting;

import java.util.Arrays;

public class QuickSort {
    private static void swap(int[] arr,int index1,int index2)
    {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private static int pivot(int[] arr,int pivotIndex,int endIndex)
    {
        int swapIndex = pivotIndex;
        for(int i=pivotIndex+1;i<=endIndex;i++)
        {
            if(arr[i] < arr[pivotIndex])
            {
                swapIndex++;
                swap(arr,swapIndex,i);
            }
        }
        swap(arr,pivotIndex,swapIndex);
        return swapIndex;
    }
    public static void sort(int[] arr,int left ,int right)
    {
        if(left < right)
        {
            int pivotIndex = pivot(arr, left, right);
            sort(arr, left, pivotIndex-1);
            sort(arr, pivotIndex+1, right);
        }
    }
    public static void main(String[] args) {
        int[] arr = {10,5,7,1,8,63,1,4,7,5,22,1,4,4,5,1,2,6,8,2,0,3,1};
        System.out.println(Arrays.toString(arr));
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
}
