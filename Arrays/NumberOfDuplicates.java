package Arrays;
import java.util.*;
public class NumberOfDuplicates {

	public static void Duplicates(int arr[]){
		for(int i=0;i<arr.length-1;i++){
			if(arr[i]==arr[i+1]){
				int count=1;
				int j=i+1;
				while(arr[i]==arr[j]){
					j++;
					count++;
				}
				System.out.println(arr[i]+" is appearing "+count+" times.");
				i=j-1;
			}
		}
		}
	
	public static void findDuplicatesUsingHasing(int arr[]){
		int temp[]=new int[arr.length];
		System.arraycopy(arr, 0, temp, 0, temp.length); 
		int size=temp[temp.length-1];
		System.gc();
		int newArray[]=new int[size+1];
		for(int i=0;i<arr.length;i++){
			newArray[arr[i]]=newArray[arr[i]]+1;
		}
		for(int i=0;i<newArray.length;i++){
			if(newArray[i]>1)System.out.println(i+" is appearing "+newArray[i]+" times.");
		}
		int m=2;
		int result=(m++)+(++m)+(m++)+(++m)+(++m)+(m++);
		System.out.println(result);
	}
	
	
	
	public static void main(String[] args) {
		int arr[]={3,6,18,18,10,10,10,10,12,12,15,15,15,20};
		findDuplicatesUsingHasing(arr);
		
	}

}
