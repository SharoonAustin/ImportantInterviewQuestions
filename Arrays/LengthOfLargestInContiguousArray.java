package Arrays;
import java.util.*;

public class LengthOfLargestInContiguousArray {
	static int length=0,count=0,startIndex=0,endIndex=0;
	public static int lengthOfLargest(int arr[]){
		int maxSize=Arrays.stream(arr).max().getAsInt();
		int newArray[]=new int[maxSize+1];
		Arrays.fill(newArray,-1);		
		for(int i=0;i<arr.length;i++)
			newArray[arr[i]]=1;	
		
		for(int i=0;i<newArray.length;i++){
			if(newArray[i]>=1){
				count++;
				endIndex++;
				/*if(length<=count)
					length=count;*/
				length=Math.max(length, count);
			}
			else{
				startIndex=i;
				endIndex=startIndex+1;
				//endIndex=0;
				count=0;
			}
		}
		
		while(newArray[startIndex]>=1){
			System.out.println("The Largest Contiguous Array is: "+startIndex);
			startIndex++;
		}

		
		
		return length;
	}
	
	public static void main(String[] args) {
		int arr[]={1,2,3,4,7,8,9,10,11};
		System.out.println(lengthOfLargest(arr));
	}

}
