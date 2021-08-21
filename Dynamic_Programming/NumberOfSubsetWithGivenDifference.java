package Dynamic_Programming;

public class NumberOfSubsetWithGivenDifference {
	
	
	public static int sumSubSetUtil(int arr[], int sum, int N){
		if(sum==0)
			return 1;
		
		if(N==0 && sum!=0)
			return 0;

		
		if(arr[N-1]<=sum)			
			return sumSubSetUtil(arr, sum-arr[N-1], N-1)
			+sumSubSetUtil(arr, sum, N-1);
		
		else 
			return sumSubSetUtil(arr, sum, N-1);
		
		
	}
	
	public static void main(String[] args) {
	int arr[]={1,1,2,3};
	int diff=1;
	
	int sum=0;
	for(int i=0;i<arr.length;i++)
		sum+=arr[i];
	
	int newSum=(diff+sum)/2;
	
	System.out.println(sumSubSetUtil(arr, newSum, arr.length));

	}

}
