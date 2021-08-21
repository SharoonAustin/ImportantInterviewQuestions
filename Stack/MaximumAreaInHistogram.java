package Stack;

import java.util.Stack;

public class MaximumAreaInHistogram {
	
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
		int arr[]={1,8,6,2,5,4,8,3,7};
		int right[]=NSR(arr, arr.length);
		int left[]=NSL(arr, arr.length);
		int weight[]=new int[arr.length];
		long maximum=Integer.MIN_VALUE;
		
		for(int i=0; i<weight.length; i++){
			weight[i]=right[i]-left[i]-1;
			maximum=Math.max(maximum, weight[i]*arr[i]);
		}
		System.out.println(maximum);
		
		
	}

}
