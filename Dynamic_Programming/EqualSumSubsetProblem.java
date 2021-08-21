package Dynamic_Programming;

public class EqualSumSubsetProblem {

	static int sum=0;

	static int equalPartition(int N, int arr[]){
		sum=0;
		for(int i=0; i<N; i++)
			sum+=arr[i];

		if(sum%2!=0)
			return 0;
	
			
		else{
			boolean t[][]=new boolean[N+1][sum+1];
			for(int i=0; i<N+1; i++){
				for(int j=0; j<((sum/2)+1); j++){
					if(i==0)
						t[i][j]=false;
					if(j==0)
						t[i][j]=true;
				}
			}
		
			if(equalPartitionUtil(N,arr, t, sum/2))
				return 1;
			else
				return 0;
		}	
	}
	
	public static boolean equalPartitionUtil(int N, int arr[], boolean t[][], int sum){
		for(int i=1; i<N+1; i++){
			for(int j=1; j<sum+1; j++){
				
				if(arr[i-1]<=j)
					t[i][j]=t[i-1][j-arr[i-1]] || t[i-1][j];
				else
					t[i][j]=t[i-1][j];
			}
		}
		return t[N][sum];
	}
	
	
	public static void main(String[] args) {
		
		int arr[]={1, 3, 5};
		int n=arr.length;
		System.out.print(equalPartition(n, arr));

	}

}
