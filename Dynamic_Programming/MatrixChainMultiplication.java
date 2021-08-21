package Dynamic_Programming;

public class MatrixChainMultiplication {
	
	static int minimum=Integer.MAX_VALUE;
	public static int minCost(int nums[], int i, int j){
		if(i>=j)
			return 0;
		
		for(int k=i; k<j; k++){
			int temp=minCost(nums, i, k)+minCost(nums, k+1, j)+(nums[i-1]*nums[k]*nums[j]);
			minimum=Math.min(minimum, temp);
		}
		return minimum;
	}
	
	public static void main(String[] args) {
		int nums[]={3,1,5,8};
		int i=1, j=nums.length-1;
		
		System.out.println(minCost(nums, i, j));
	}

}
