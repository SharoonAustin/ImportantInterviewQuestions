package Arrays;
import java.util.*;
public class ThreeSumProblem {

	public static boolean find3Numbers(int arr[], int N, int K){
		Arrays.sort(arr);
		int i=0, j=1, k=N-1;
		while(i<=arr.length-3){
			K=K-arr[i];
			while(j<k){
				if(arr[j]+arr[k]==K)
					return true;
				else if(arr[j]+arr[k]>K)
					k--;
				else
					j++;
			}
			K=K+arr[i];
			i++;
			j=i+1;
			k=N-1;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int N = 6, K = 50;
		int arr[] = {1, 4, 45, 6, 10, 8};
		System.out.println(find3Numbers(arr, N, K));
		
	}

}
