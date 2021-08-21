package Stack;
import java.util.*;
public class NextGreaterElementToLeft {

	public static long[] nextGreaterToLeft(long arr[], int n){
		Stack<Long> stack=new Stack<Long>();
		long newArray[]=new long[n];
		for(int i=0; i<arr.length; i++){
			
			if(stack.isEmpty())
				newArray[i]=-1;
			
			else if(!stack.isEmpty() && arr[i]<stack.peek())
				newArray[i]=stack.peek();
			
			else if(!stack.isEmpty() && arr[i]>=stack.peek()){
				while(!stack.isEmpty() && arr[i]>stack.peek())
					stack.pop();
				if(stack.empty())
					newArray[i]=-1;
				else
					newArray[i]=stack.peek();
			}
			stack.push(arr[i]);
			
		}
		return newArray;
	}
	
	public static void main(String[] args) {
		long arr[]={1, 3, 2, 4};
		long myArray[]=nextGreaterToLeft(arr, arr.length);
		for(int i=0; i<myArray.length; i++)
			System.out.print(myArray[i]+" ");
	}

}
