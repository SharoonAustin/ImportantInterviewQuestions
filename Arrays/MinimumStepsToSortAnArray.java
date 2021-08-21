package Arrays;
import java.util.*;
public class MinimumStepsToSortAnArray {

	
	public static void main(String[] args) {
		int arr[]={8,6,9,5,10,7,11};
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		
		for(int i=0;i<arr.length;i++)
			hm.put(i,arr[i]);

		Arrays.sort(arr);

		for(int i=0;i<arr.length;i++){
			if(hm.get(i)!=arr[i]){
				
			}
		}
	}

}
