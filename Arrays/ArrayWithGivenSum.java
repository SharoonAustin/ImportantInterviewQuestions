package Arrays;
import java.util.*;
public class ArrayWithGivenSum {

	public static void getSum(int arr[],int K){
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();

		for(int i=0;i<arr.length;i++){
			if(hm.containsKey(K-arr[i])){
				System.out.println("Pair found at index "+hm.get(K-arr[i])+" and "+i);
				System.out.println("Element are: "+arr[hm.get(K-arr[i])]+" and "+arr[i]);
			}
			hm.put(arr[i],i);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner s1=new Scanner(System.in);
		int arr[]={8,7,2,5,3,1};
		int K=s1.nextInt();
		getSum(arr,K);
	}

}
