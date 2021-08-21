package Dynamic_Programming;
import java.util.*;

public class HouseRobberProblem {

	 public int rob(int[] money, int arr[],int n) {
	        
		 	if(n==0 || n<0)
	        	return 0;
		 	
		 	if(arr[n]!=-1)
		 		return arr[n];
		 	
	        return arr[n]=Math.max(money[n-1]+rob(money, arr,n-2), rob(money, arr,n-1));
	 }
	
	public static void main(String[] args) {
		int money[]={2,7,9,3,1};
		int arr[]=new int[money.length+1];
		Arrays.fill(arr, -1);
		System.out.println(new HouseRobberProblem().rob(money, arr,money.length));
	
	}

}