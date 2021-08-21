package Arrays;
import java.util.*;

public class NegativeOnLeftHandSide {

	public static void moveNegative(int arr[]){
		
	}
	
	
	public static void main(String[] args) {
		Scanner s1=new Scanner(System.in);
		int arr[]={-6,-3,-2,4,-7,2,-1,9};
		int i=0,j=arr.length-1,temp=0;
		while(i<j){
			while(arr[i]<0){
				if(i==arr.length-1)
					break;
				i++;
			}
			while(arr[j]>=0){
				if(j==0)
					break;
				j--;
			}
			if(i<j){
				temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		System.out.print(Arrays.toString(arr)+" ");
		
	}

}
