package Stack;
import java.util.*;

class Store{
	int arrayElement,index;
	Store(int arrayElement, int index){
		this.arrayElement=arrayElement;
		this.index=index;
	}
}

public class StockSpanProblem {
	
	public static int[] storeIndex(int arr[], int n){
		Stack<Store> stack=new Stack<Store>();
		int newArray[]=new int[n];
		for(int i=0; i<n; i++){
			if(stack.isEmpty())
				newArray[i]=-1;
			else if(!stack.isEmpty() && arr[i]<stack.peek().arrayElement){
				newArray[i]=stack.peek().index;
			}
			
			else if(!stack.isEmpty() && arr[i]>=stack.peek().arrayElement){
				while(!stack.isEmpty() && arr[i]>=stack.peek().arrayElement)
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
		int arr[]={100, 80, 60, 70, 60, 75, 85};
		int myarray[]=storeIndex(arr, arr.length);
		for(int i=0; i<myarray.length; i++)
			System.out.print(i-myarray[i]+" ");
	}

}
