package Stack;
import java.util.*;
public class MaximumDifference {

	 public static int[] nextSmallestToRight(int arr[], int n){
			Stack<Integer> stack=new Stack<Integer>();
			int newArray[]=new int[arr.length];
			for(int i=n-1; i>=0; i--){
				
				if(stack.isEmpty())
					newArray[i]=0;
				
				else if(!stack.isEmpty() && arr[i]>stack.peek())
					newArray[i]=stack.peek();
				
				else if(!stack.isEmpty() && arr[i]<=stack.peek()){
					while(!stack.isEmpty() && arr[i]<=stack.peek())
						stack.pop();
					
					if(stack.isEmpty())
						newArray[i]=0;
					else
						newArray[i]=stack.peek();
				}
				stack.push(arr[i]);
			}
			return newArray; 
		}
		
		
		
		public static int[] nextSmallestToLeft(int arr[], int n){
			Stack<Integer> stack=new Stack<Integer>();
			int newArray[]=new int[arr.length];
			for(int i=0; i<n; i++){
				
				if(stack.isEmpty())
					newArray[i]=0;
				
				else if(!stack.isEmpty() && arr[i]>stack.peek())
					newArray[i]=stack.peek();
				
				else if(!stack.isEmpty() && arr[i]<=stack.peek()){
					while(!stack.isEmpty() && arr[i]<=stack.peek())
						stack.pop();
					
					if(stack.isEmpty())
						newArray[i]=0;
					else
						newArray[i]=stack.peek();
				}
				stack.push(arr[i]);
			}
			return newArray; 
		}
		
	public static void main(String[] args) {
		int arr[]={2, 4, 8, 7, 7, 9, 3};
		int left[]=nextSmallestToLeft(arr, arr.length);
		int right[]=nextSmallestToRight(arr, arr.length);
		int Maximum=Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++){
		    int calculate=Math.abs(left[i]-right[i]);
		    Maximum=Math.max(Maximum, calculate);
		}

	}

}
