package Arrays;

public class MaximumAdditiveScoreByRemovingElement {
	/*
	 * public static int solve(int[] nums) {
	 * 
	 * return Math.max(solveUtilRight(nums, nums.length-3, nums.length-2,
	 * nums.length-1), solveUtilLeft(nums, 0, 1, 2)); }
	 * 
	 * public static int solveUtilRight(int nums[], int left, int current, int
	 * right){ if(nums.length<=2) return 0;
	 * 
	 * if(current==0) return 0;
	 * 
	 * int temp=nums[left] + nums[current] + nums[right]; int sum=0; return sum =
	 * sum + temp + solveUtilRight(nums, --left, --current, right); }
	 * 
	 * public static int solveUtilLeft(int nums[], int left, int current, int
	 * right){ if(nums.length<=2) return 0;
	 * 
	 * if(current==nums.length-1) return 0;
	 * 
	 * int temp=nums[left] + nums[current] + nums[right]; int sum=0; return sum =
	 * sum + temp + solveUtilLeft(nums, left, ++current, ++right);
	 * 
	 * }
	 */	     
	     public static int[] solve(int[] nums, int k) {
	         int arr[]=new int[nums.length];
	         int index=0;
	         while(k<=nums.length-1){
	             arr[index]=nums[k];
	             index++;
	             k++;
	         }
	         int i=0;
	         while(index!=nums.length-1) {
	        	 arr[index++]=nums[i++];
	         }
	        
	         return arr;
	     }

	public static void main(String[] args) {
		int nums[]= {1, 2, 3, 4, 5, 6};
		
		System.out.println(solve(nums,2));

	}

	
}
