package Stack;

public class RainWaterTrapping {

	public static int calculateTheWaterUnits(int arr[], int length){
		int left[]=new int[length];
		int maxOnLeft=arr[0];
		left[0]=maxOnLeft;
		for(int i=1;i<arr.length;i++){
			if(arr[i]>maxOnLeft)
				maxOnLeft=arr[i];
			left[i]=maxOnLeft;
		}
		
		int right[]=new int[length];
		int maxOnRight=arr[length-1];
		right[length-1]=maxOnRight;
		for(int i=length-2; i>=0; i--){
			if(arr[i]>maxOnRight)
				maxOnRight=arr[i];
			right[i]=maxOnRight;
		}
		
		int water[]=new int[length];
		int sum=0;
		for(int i=0; i<water.length; i++){
			water[i]=Math.min(left[i], right[i])-arr[i];
			sum+=water[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int arr[]={8, 8, 2, 4, 5, 5, 1};
		System.out.println(calculateTheWaterUnits(arr, arr.length));

	}

}
