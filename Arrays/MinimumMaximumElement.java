package Arrays;
import java.util.*;
public class MinimumMaximumElement {

	public static void minMax(int arr[]){
	int min=arr[0],max=arr[0];
		for(int i=1;i<arr.length;i++){
			if(arr[i]<min)
				min=arr[i];
			else if(max<arr[i])
				max=arr[i];
			else{}
		}
		System.out.print(min+" "+max);
		
	}
	
	public static void main(String[] args) {
		Scanner s1=new Scanner(System.in);
		int arr[]={5,8,3,9,6,2,10,7,-1,4};
		minMax(arr);

	}

}
