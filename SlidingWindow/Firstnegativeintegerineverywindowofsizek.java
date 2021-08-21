package SlidingWindow;
import java.util.*;
public class Firstnegativeintegerineverywindowofsizek {

	public static void firstNegative(int arr[], int K, ArrayList<Integer> list){
		int i=0, j=0;
		while(j<arr.length){
			if(arr[j]<0){
				list.add(arr[j]);
			}
			
			if(j-i+1<K)
				j++;
			
			else{
				if(list.size()==0)
					System.out.print(0+" ");
				else{
				System.out.print(list.get(0)+" ");
				if(arr[i]==list.get(0)){
					list.remove(0);
				}
				}
				i++;
				j++;
			}
			
		}
	}
	
	public static void main(String[] args) {
		int arr[]={-8, 2, 3, -6, 10};
		
		int K=2;
		ArrayList<Integer> list=new ArrayList<Integer>();
		firstNegative(arr, K, list);
	}

}
