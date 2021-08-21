package Arrays;
import java.util.*;
public class DuplicatesInAnUnsortedArray {

	
	public static void main(String[] args) {
	int arr[]={1,2,3,4,5,6,6,7,8,9};
	
	for(int i=0;i<arr.length;i++)
		arr[arr[i]-1]=-arr[arr[i]-1];
	
	System.out.println(Arrays.toString(arr)+" ");
	
	}

}
