package Dynamic_Programming;
public class CountOfSubsetWithSumEqualToXRecursion {

	
	public static int countOfSubsetWithSumEqualToX(int arr[], int X, int N){	
		if(X==0)
			return 1;
		
		if(N==0 && X!=0)
			return 0;

		
		if(arr[N-1]<=X)			
			return countOfSubsetWithSumEqualToX(arr, X-arr[N-1], N-1)
			+countOfSubsetWithSumEqualToX(arr, X, N-1);
		
		else 
			return countOfSubsetWithSumEqualToX(arr, X, N-1);
	}
	
		
	
	
	public static void main(String[] args) {
		int arr[] = {1, 1, 1, 1};
		int X = 1;
		
		System.out.println(countOfSubsetWithSumEqualToX(arr, X, arr.length));
	}

}
