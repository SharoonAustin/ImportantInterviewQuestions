package Arrays;
import java.util.*;
public class MaximumLengthOfSubArrayWithGivenSum {

	public static int maxLength(int arr[],int K){
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		int length=0,sum=0;
		
		for(int i=0;i<arr.length;i++){
			sum=sum+arr[i];
			
			if(sum==K)
				length=i+1;
			
			if(!map.containsKey(sum))
				map.put(sum, i);
			
			if(map.containsKey(sum-K))
				length=Math.max(length, i-map.get(sum-K));
			
		}
		return length;
	}
	
	public static void main(String[] args) {
		Scanner s1=new Scanner(System.in);
		int K=s1.nextInt();
		int arr[] = { 10, 5, 2, 7, 1, 9 };
		System.out.print(maxLength(arr,K));
	}

}
