package Arrays;
import java.util.*;

public class SumOfTwoElementsEqualToKInSortedArray {

	static void sumOfElements(int arr[],int K){
		int i=0,j=arr.length-1;
		
		while(i<j){
			if(arr[i]+arr[j]<K)
				i++;
			
			else if(arr[i]+arr[j]>K)
				j--;
			else
				System.out.println(arr[i++]+" "+arr[j--]);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner s1=new Scanner(System.in);
		int arr[]={-1,2,3,4,5,6,7,8,9};
		int K=s1.nextInt();
		sumOfElements(arr,K);
		
	}

}
