package Stack;
import java.util.*;
public class NearestSmallestToLeft {
	
	public static void nearestElementTotheLeft(int arr[], int n){
		Stack<Integer> stack=new Stack<Integer>();
		for(int i=0; i<arr.length; i++){
			
			if(stack.isEmpty())
				System.out.print(-1+" ");
			
			else if(!stack.isEmpty() && arr[i]>stack.peek())
				System.out.print(stack.peek()+" ");
			
			else if(!stack.isEmpty() && arr[i]<=stack.peek()){
				while(!stack.isEmpty() && arr[i]<stack.peek())
					stack.pop();
				if(stack.empty())
					System.out.print(-1+" ");
				else
					System.out.print(stack.peek()+" ");
			}
			
			stack.push(arr[i]);
	}
	}
	
	public static void main(String[] args) {
		int arr[]={4, 2, 1, 5, 3};
		nearestElementTotheLeft(arr, arr.length);
	}

}
