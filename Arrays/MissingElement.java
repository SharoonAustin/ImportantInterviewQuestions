package Arrays;
import java.util.*;

public class MissingElement {
	
	
	public static void firstWay(int arr[]){
		int element=arr[0];
		int index=1;
		
		while(index<arr.length){
			if(element==arr[index]-index){}
			else{
				while(element<arr[index]-index){
				System.out.print("Missing number: "+(element+index)+"\n");
				element++;
				}
			}
		index++;
		}
	}
	
//			System.arraycopy(a, 0, temp, 0, temp.length); 

	public static void secondWay(int arr[]){
		int temp[]=new int[arr.length];
		System.arraycopy(arr, 0, temp, 0, arr.length); 
		Arrays.sort(temp);
		int l=temp[0];
		int h=temp[temp.length-1];
		System.gc();
		int newArray[]=new int[h+1];
		for(int i=0;i<arr.length;i++)
			newArray[arr[i]]=1;
		for(int i=l;i<h;i++){
			if(newArray[i]==0)
				System.out.println(i);
		}
		}

	public static void main(String[] args) {
		Scanner s1=new Scanner(System.in);
		int n=s1.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=s1.nextInt();
		secondWay(arr);
	}
	
}
