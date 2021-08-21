package Arrays;

import java.util.Arrays;

public class MaxProduct {

	public static int maxProduct(int arr[]){
		Arrays.sort(arr);
		
		return Math.max((arr[0]*arr[1]),(arr[arr.length-2])*arr[arr.length-1]);
	}
	
	public static void main(String[] args) {
		int arr[]={-10,-3,5,6,-2};
		System.out.println(maxProduct(arr));
	}

}
