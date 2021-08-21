package Arrays;

public class MinimumNumberOfJumps {

	public static int minimumNumberOfJumps(int arr[]){
		int steps=arr[0];
		int maxReachable=arr[0];
		int jumps=1;
		for(int i=1; i<arr.length; i++){
			if(i==arr.length-1)
				return jumps;
			maxReachable=Math.max(maxReachable, arr[i]+i);
			steps--;
			if(steps==0){
				jumps++;
				if(i>=maxReachable) 
					return -1;
				steps=maxReachable-i;
			}
				
		}
		return jumps;
	}
	
	public static void main(String[] args) {
		int arr[] = {0,
	            0,
	            0,
	            0,
	            0,
	            0,
	            0,
	            0,
	            8};
		System.out.println(minimumNumberOfJumps(arr)); 
	}

}
