package Sorting;

import java.util.Arrays;

public class MergeSort {

    public static void display(int[] arr)
    {
        for(int i: arr)
        System.out.print(i+" ");
        System.out.println();
    }

    public static int[] merge(int[] arr1 , int[] arr2)
    {
        int[] mergedArray = new int[arr1.length+arr2.length];
        int index = 0, i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j])
            {
                mergedArray[index++] = arr1[i++];
            }
            else
            {
                mergedArray[index++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            mergedArray[index++] = arr1[i++];
        }
        while (j < arr2.length) {
            mergedArray[index++] = arr2[j++];
        }
        return mergedArray;

    }

    public static int[] sort(int[] arr)
    {
        if(arr.length == 1)
        return arr;
        int midIndex = arr.length /2;
        int[] left = sort(Arrays.copyOfRange(arr, 0, midIndex));
        int[] right =sort(Arrays.copyOfRange(arr, midIndex, arr.length));

        return merge(left, right);


    }
    public static void main(String[] args) {
        int[] arr = {10,5,7,1,8,63,1,4,7,5,22,1,4,4,5,1,2,6,8,2,0,3,1};
        System.out.println(arr.length);
        display(arr);
        arr = sort(arr);
        display(arr);
        System.out.println(arr.length);
        System.out.println("=======================================");


    }
}
