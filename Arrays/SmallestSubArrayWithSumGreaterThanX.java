package Arrays;
import java.util.*;
public class SmallestSubArrayWithSumGreaterThanX {
	
	static int sum=0;
	static ArrayList<Integer> list=new ArrayList<Integer>();
	
	public static int calculateTheSmallestSubArraySize(int arr[], int x){
		int i=0;
		int ptr=0;
		
		while(sum<x){
			sum+=arr[i];
			list.add(arr[i]);
			i++;
		}
		while(sum>x){
			if(sum-arr[ptr]>x){
			sum-=arr[ptr];
			list.remove(ptr);
			ptr++;
			}
			else
				break;
		}
		return list.size();
	}
	
	public static void main(String[] args) {
		Scanner s1=new Scanner(System.in);
		int T=s1.nextInt();
		while(T>0){
		    sum=0;
		    list.clear();
		    int N=s1.nextInt();
		    int arr[]=new int[N];
		    for(int i=0;i<arr.length;i++)
		        arr[i]=s1.nextInt();
		    int x=s1.nextInt();
		    System.out.println(calculateTheSmallestSubArraySize(arr,x));
		    T--;
		}
	}

}
