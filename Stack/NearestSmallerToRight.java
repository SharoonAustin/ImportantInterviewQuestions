package Stack;
import java.util.*;
public class NearestSmallerToRight {

	public static int[] nextSmallestToRight(int arr[], int n){
		Stack<Integer> stack=new Stack<Integer>();
		int newArray[]=new int[arr.length];
		for(int i=n; i>=0; i--){
			
			if(stack.isEmpty())
				newArray[i]=-1;
			
			else if(!stack.isEmpty() && arr[i]>stack.peek())
				newArray[i]=stack.peek();
			
			else if(!stack.isEmpty() && arr[i]<=stack.peek()){
				while(!stack.isEmpty() && arr[i]<stack.peek())
					stack.pop();
				
				if(stack.isEmpty())
					newArray[i]=-1;
				else
					newArray[i]=stack.peek();
			}
			stack.push(arr[i]);
		}
		return newArray; 
	}
	
	public static void main(String[] args) {
		int arr[]={4, 8, 5, 2, 25};
		int myArray[]=nextSmallestToRight(arr, arr.length-1);
		for(int i=0; i<myArray.length; i++)
			System.out.print(myArray[i]+" ");
		
	}

}
