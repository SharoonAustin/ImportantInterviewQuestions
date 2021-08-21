package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestSubsequenceByConsecutiveInteger {

	public static void longestSubSequence(int arr[]){
		 int max = Math.abs(Arrays.stream(arr).max().getAsInt());
		 int newArray[]=new int[max+1];
		 
		 for(int i=0;i<arr.length;i++){
			 newArray[Math.abs(arr[i])]=1;
		 }
		int local=0,global=0;
		for(int i=0;i<newArray.length;i++){
			if(newArray[i]==1)
				local++;
			else
				local=0;
			global=Math.max(local, global);
		}
		System.out.println(global);
	}

	
	public static void main(String[] args) {
		int arr[]={2,6,1,9,4,5,3};
		longestSubSequence(arr);

	}

}
