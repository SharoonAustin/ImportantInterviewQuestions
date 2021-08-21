package Dynamic_Programming;

public class CountOfSubsetWithSumEqualToX {

	
	public static int countOfSubsetWithSumEqualToX(int arr[], int X, int N){
		int t[][]=new int[N+1][X+1];
		for(int i=0; i<N+1; i++){
			for(int j=0; j<X+1; j++){
				if(i==0)
					t[i][j]=0;
				if(j==0)
					t[i][j]=1;
			}
		}
		
		for(int i=1; i<N+1; i++){
			for(int j=1; j<X+1; j++){
				
				if(arr[i-1]<=j)
					t[i][j]=t[i-1][j-arr[i-1]]+t[i-1][j];
				else
					t[i][j]=t[i-1][j];
			
				
			}
		}
		return t[N][X];
	}
	
		
	
	
	public static void main(String[] args) {
		int arr[] = {1, 1, 1, 1};
		int X = 1;
		
		System.out.println(countOfSubsetWithSumEqualToX(arr, X, arr.length));
	}

}
