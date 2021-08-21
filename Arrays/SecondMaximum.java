package Arrays;

public class SecondMaximum {

	public static void secondMaximum(int arr[]){
		int max=Integer.MIN_VALUE;
		int secondMax=Integer.MIN_VALUE;
		int thirdMax=Integer.MIN_VALUE;
		
		for(int i=0;i<arr.length;i++){
			if(arr[i]>max && arr[i]>secondMax && arr[i]>thirdMax){
				thirdMax=secondMax;
				secondMax=max;
				max=arr[i];
			}
			else if(arr[i]>secondMax && arr[i]>thirdMax){
				thirdMax=secondMax;
				secondMax=arr[i];
			}
			else if(arr[i]>thirdMax){
				thirdMax=arr[i];
			}
			else{}
		}
		System.out.println("Last three max are: "+max+" "+secondMax+" "+thirdMax);
		
	}
	
	public static void main(String[] args) {
	int arr[]={-2,-3,-4,-5,-6};
	secondMaximum(arr);	
	}
}