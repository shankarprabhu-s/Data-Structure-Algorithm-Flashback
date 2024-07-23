package Sorting;
/**
 * Sorting
 */
public class Sorting_1 {
    
    public static void display(int[] arr)
    {
        for(int i: arr)
        System.out.print(i+" ");
        System.out.println();
    }
    public static void bubbleSort(int[] arr)
    {
        for(int i=0;i<arr.length-1;i++)
        {
            for(int j=0;j<arr.length-1-i;j++) //add -i to the condition for optimised
            {
                if(arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                }
            }
        }
    }

    public static void selectionSort(int[] arr)
    {
        for(int i=0;i<arr.length-1;i++)
        {
            int minIndex = i;
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[minIndex] > arr[j])
                minIndex = j;
            }
            if(minIndex != i)
            {

                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void insertionSort(int[] arr)
    {
        for(int i=1;i<arr.length;i++)
        {
            int temp = arr[i];
            int j = i-1;
            while (j >= 0 && temp < arr[j]) {
                arr[j+1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {10,5,7,1,8,63,1,4,7,5,22,1,4,4,5,1,2,6,8,2,0,3,1};
        System.out.println(arr.length);
        display(arr);
        insertionSort(arr);
        display(arr);
        System.out.println(arr.length);
        System.out.println("=======================================");


    }
}
