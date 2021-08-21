package Dynamic_Programming;

public class SumSubsetUsingRecursion {

	public static boolean sumSubSetUsingRecursion(int arr[], int X, int N){
		
		if(X==0)
			return true;
		
		if(N==0 && X!=0)
			return false;
		
		if(arr[N-1]<=X)
			return sumSubSetUsingRecursion(arr, X-arr[N-1], N-1) ||
			sumSubSetUsingRecursion(arr, X, N-1);
		
		else
			return sumSubSetUsingRecursion(arr, X, N-1);
			
	}

	
	public static void main(String[] args) {
		int arr[] = {1, 5, 11, 5};
		int sum = 22;
		System.out.println(sumSubSetUsingRecursion(arr, sum, arr.length));

	}

}
