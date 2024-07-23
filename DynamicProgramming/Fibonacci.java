package DynamicProgramming;

public class Fibonacci {
    // here we are using memoization technique
    static Integer[] memo = new Integer[300];
    static int counter1 = 0; // to check how many steps are there in the program
    public static int fib1(int n)
    {
        counter1++;
        if(n==0 || n==1)
        return n;
        if(memo[n] != null)
        return memo[n];
        memo[n] = fib1(n-1) + fib1(n-2);
        return memo[n];
    }

    //here we aare using the bottom up approach
    static int counter2 = 0;
    public static int fib2(int n)
    {
        int[] arr = new int[n+1];
        arr[0] = 0; 
        arr[1] = 1; 
        for(int i=2;i<=n;i++)
        {
            arr[i] = arr[i-1] + arr[i-2];
            counter2++;
        }
        return arr[n];
 }
    public static void main(String[] args) {
        System.out.println(fib1(20));
        System.out.println(counter1);
        System.out.println(fib2(20));
        System.out.println(counter2);
    }
}
