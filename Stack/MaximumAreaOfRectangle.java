package Stack;

import java.util.*;
public class MaximumAreaOfRectangle {
	
	 public static int maxArea(int M[][], int m, int n) {
		 	int maximum=Integer.MIN_VALUE;
	        int arr[]=new int[m];
	        for(int i=0; i<n; i++)
	        	arr[i]=M[0][i];
	        maximum=Math.max(maximum, maximumAreaOfHistogram(arr, arr.length));

	        for(int i=1; i<m; i++){
	        	for(int j=0; j<n; j++){
	        		if(M[i][j]==0)
	        			arr[j]=0;
	        		else
	        			arr[j]=arr[j]+M[i][j];
	        	}
		        maximum=Math.max(maximum, maximumAreaOfHistogram(arr, arr.length));
	        }
	        return maximum;
	    }
	 
	 public static int maximumAreaOfHistogram(int arr[], int n)
	 {
		 	int right[]=NSR(arr, arr.length);
			int left[]=NSL(arr, arr.length);
			int weight[]=new int[arr.length];
			int maximum=Integer.MIN_VALUE;
			
			for(int i=0; i<weight.length; i++){
				weight[i]=right[i]-left[i]-1;
				maximum=Math.max(maximum, weight[i]*arr[i]);
			}
			return maximum;
	 }
	 
	 public static int[] NSR(int arr[], int n){
			Stack<Store> stack=new Stack<Store>();
			int newArray[]=new int[arr.length];
			for(int i=n-1; i>=0; i--){
				
				if(stack.isEmpty())
					newArray[i]=n;
				
				else if(!stack.isEmpty() && arr[i]>stack.peek().arrayElement)
					newArray[i]=stack.peek().index;
				
				else if(!stack.isEmpty() && arr[i]<=stack.peek().arrayElement){
					while(!stack.isEmpty() && arr[i]<=stack.peek().arrayElement)
						stack.pop();
					
					if(stack.isEmpty())
						newArray[i]=n;
					else
						newArray[i]=stack.peek().index;
				}
				stack.push(new Store(arr[i], i));
			}
			return newArray; 
		}
		
		public static int[] NSL(int arr[], int n){
			Stack<Store> stack=new Stack<Store>();
			int newArray[]=new int[arr.length];
			for(int i=0; i<n; i++){
				
				if(stack.isEmpty())
					newArray[i]=-1;
				
				else if(!stack.isEmpty() && arr[i]>stack.peek().arrayElement)
					newArray[i]=stack.peek().index;
				
				else if(!stack.isEmpty() && arr[i]<=stack.peek().arrayElement){
					while(!stack.isEmpty() && arr[i]<=stack.peek().arrayElement)
						stack.pop();
					
					if(stack.isEmpty())
						newArray[i]=-1;
					else
						newArray[i]=stack.peek().index;
				}
				stack.push(new Store(arr[i], i));
			}
			return newArray; 
		}
	 
	public static void main(String[] args) {
		int M[][] = new int[][]{
				{0, 1, 1, 0}, 
				{1, 1, 1, 1}, 
				{1, 1, 1, 1}, 
				{1, 1, 0, 0}};
		System.out.println(maxArea(M, M.length, M[0].length));
		
	}

}
