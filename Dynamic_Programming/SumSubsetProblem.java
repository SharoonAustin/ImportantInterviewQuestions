package Dynamic_Programming;
import java.util.Arrays;


public class SumSubsetProblem {
	
	static boolean t[][];
	
	public static boolean sumSubsetExistOrNot(int arr[], int sum, int n){
		t=new boolean[n+1][sum+1];
		for(int i=0; i<n+1; i++){
			for(int j=0; j<sum+1; j++){
				if(i==0)
					t[i][j]=false;
				if(j==0)
					t[i][j]=true;
			}
		}
		return sumSubsetExistOrNotUtil(arr, sum, n);
		
	}
	public static boolean sumSubsetExistOrNotUtil(int arr[], int sum, int n){
		for(int i=1; i<n+1; i++){
			for(int j=1; j<sum+1; j++){
				
				if(arr[i-1]<=j)
					t[i][j]=t[i-1][j-arr[i-1]] || t[i-1][j];

				else
					t[i][j]=t[i-1][j];
			}
			}
		return t[n][sum];
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 8, 2, 5};
		int sum = 4;		
		
		
		System.out.println(sumSubsetExistOrNot(arr, sum, arr.length));
	}

}
