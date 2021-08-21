package Arrays;
import java.util.*;
public class ChocolateDistributionProblem {

	public int chocolateDistribution(int arr[]){
		int leftArr[]=new int[arr.length];
		Arrays.fill(leftArr, 1);
		
		int sum=0;
		
		int rightArr[]=new int[arr.length];
		Arrays.fill(rightArr, 1);
		
		for(int i=1; i<arr.length; i++){
			if(arr[i]>arr[i-1])
				leftArr[i]=leftArr[i-1]+1;
		}
		
		for(int i=arr.length-2; i>=0; i--){
			if(arr[i]>arr[i+1])
				rightArr[i]=rightArr[i+1]+1;
		}
	
		for(int i=0; i<arr.length; i++)
			sum=sum+Math.max(leftArr[i],rightArr[i]);
		
		return sum;
	}
	
	public static void main(String[] args) {
		int arr[]={3, 4, 1, 9, 56, 7, 9, 12};
		System.out.println(new ChocolateDistributionProblem().chocolateDistribution(arr));
	}

}
