package Dynamic_Programming;
import java.util.*;
public class MinimumSumSubsetDifference {

	
	/*
	 * In this Problem we have to divide the array into subsets 
	 * in such a way that S1-S2=Minimum (Here S1 and S2 are subsets)
	 * Here we don't need to calculate the S2 because S2=range(sum)-s1
	 * 
	 * 1) Calculate the sum of the array i.e. range
	 * 
	 * 2) Firstly we made the matrix of[n+1][range+1] and solve it using
	 * 	  sum subset problem
	 * 
	 * 3) Then we checked for the half of the last rows of the matrix
	 *    if true is found then add it to the list
	 * 
	 * 4) Now create one min variable and initialize it with maximum value 
	 * 	  traverse through the list and check if range-s*list.get(item) is minimum 
	 *    then the value present in the already minimum variable
	 *    
	 * 
	 * */
	
	public static int minDifference(int arr[], int n) 
	{ 
	  int range=calculateTheSum(arr);
	  boolean t[][]=new boolean[n+1][range+1];
	  for(int i=0; i<arr.length+1; i++){
		  for(int j=0; j<n+1; j++){
			  if(i==0)
				  t[i][j]=false;
			  if(j==0)
				  t[i][j]=true;
		  }
	  }
	  ArrayList<Integer> list=new ArrayList<Integer>();
	  
	  sumSubsetExistOrNotUtil(arr, range, n, t);
	 
	  
	  for(int i=0; i<=(range/2); i++){
		  if(t[n][i]==true)
			  list.add(i);
	  }
	  
	  int minimum=Integer.MAX_VALUE;
	  for(int i=0; i<list.size(); i++){
		minimum=Math.min(minimum, (range-(2*list.get(i))));
	  }
	  return minimum;
	}
	
	public static boolean sumSubsetExistOrNotUtil(int arr[], int sum, int n, boolean t[][]){
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
	
	public static int calculateTheSum(int arr[]){
		int sum=0;
		for(int i=0;i<arr.length;i++)
			sum+=arr[i];
		return sum;
	}
	
	public static void main(String[] args) {
		 int arr[] = {1, 4};
		 int N=2;
		 System.out.println(minDifference(arr,N));
	}

}
