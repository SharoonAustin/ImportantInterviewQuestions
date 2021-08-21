package Arrays;
import java.util.*;

public class SumOfTwoElementsEqualToK {

	public static void SumOfTwoElementEqualToK(int arr[],int K){
		int temp[]=new int[arr.length];
		System.arraycopy(arr, 0, temp, 0, temp.length); 
		Arrays.sort(temp);
		int size=temp[temp.length-1];
		System.gc();
		int newArray[]=new int[size+1];
		Arrays.fill(newArray, -1);
		newArray[0]=1;
		for(int i=0;i<arr.length;i++){
			newArray[arr[i]]=1;
			if(K-arr[i]>=0){
			if(K-arr[i]<size && newArray[K-arr[i]]!=-1)
				System.out.println(arr[i]+" "+(K-arr[i]));
			}
		}
	}
	
	public static void main(String[] args) {
	Scanner s1=new Scanner(System.in);
	int K=s1.nextInt();
	int arr[]={1,2,3,4,5,6,7,8,9};
	
	SumOfTwoElementEqualToK(arr,K);
	}

}
