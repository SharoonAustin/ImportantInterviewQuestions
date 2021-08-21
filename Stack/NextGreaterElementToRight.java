package Stack;

import java.util.*;

public class NextGreaterElementToRight {

	public static long[] nextLargerElement(long[] arr, int n) { 
	      Stack<Long> stack=new Stack<Long>();
	      long next[]=new long[n];
	      
	      for(int i=arr.length-1; i>=0; i--){
	          
	          if(stack.isEmpty())
	            next[i]=-1;
	          
	          else if(!stack.isEmpty() && arr[i]<stack.peek())
	            next[i]=stack.peek();
	            
	          else if(!stack.isEmpty() && arr[i]>stack.peek()){
	              
	              while(!stack.isEmpty() && arr[i]>=stack.peek()){
	                  stack.pop();
	              }
	              
	              if(stack.isEmpty())
	                next[i]=-1;
	              
	              else
	                next[i]=stack.peek();
	              
	          }
	          
	          stack.push(arr[i]);
	          
	      }
	      
	     return next; 
	    } 
	
	public static void main(String[] args) {
		long arr[]={8,9,2,4};
		long newArray[]=nextLargerElement(arr, arr.length);
		for(int i=0; i<newArray.length; i++)
			System.out.print(newArray[i]+" ");
	}

}
