package Dynamic_Programming;
import java.util.*;
public class CountStairs {

	public static int climbStairs(int A) {
		int myArray[]=new int[A+2];
        Arrays.fill(myArray, -1);
        return fibonaci(A+1, myArray); 
		
    }
    
    public static int fibonaci(int n, int arr[]){
        if(n<=1)
            return n;
        
        if(arr[n]!=-1)
        	return arr[n];
        
        return arr[n]=fibonaci(n-1, arr) + fibonaci(n-2, arr);
        
    }
    
    
	public static void main(String[] args) {
		System.out.println(climbStairs(1));
		
	}

}
