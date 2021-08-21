package Arrays;
import java.util.*;
public class NextPermutation {
	
	public static void printTheNextPermutation(int arr[]){
			//Finding the element which is not ascending(Digit d1)
			int i=arr.length-2, j=arr.length-1;
			
			while(i>=0 && arr[i]>arr[i+1])
				i--;
			
			//Find the element to the right of the d1 such that it is smallest number greater than d1
			if(i>=0){
			while(arr[j]<arr[i])
				j--;
			
			//Swapped
			int temp=arr[j];  
	        arr[j]=arr[i];
	        arr[i]=temp;
			}
			//Sort the right part of d1
			swapTheElements(arr, i+1, arr.length-1);
			
			for(int m=0; m<arr.length; m++)
				System.out.print(arr[m]+" ");
			System.out.println();
			
		   }
		   
 
  
	public static void swapTheElements(int arr[], int i, int j){
		while(i<=j){
			int temp=0;
			temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i++;
			j--;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner s1=new Scanner(System.in);
		int T=s1.nextInt();
		while(T>0){
		    int N=s1.nextInt();
		    int arr[]=new int[N];
		    for(int i=0; i<N; i++)
		        arr[i]=s1.nextInt();
		    
		    new NextPermutation().printTheNextPermutation(arr);
		 
		    T--;
	}
	}
}
