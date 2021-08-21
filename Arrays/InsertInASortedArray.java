package Arrays;
import java.util.*;


public class InsertInASortedArray {
	public static void main(String[] args) {
		Scanner s1=new Scanner(System.in);
		int free=0;
		int arr[]=new int[s1.nextInt()];
		
		for(int i=0;i<5;i++){
			arr[i]=s1.nextInt();
			free++;
		}
		
		for(int i=free;i<arr.length;i++){
			arr[i]=Integer.MAX_VALUE;
		}
		Arrays.sort(arr);
		
		if(arr[arr.length-1]==Integer.MAX_VALUE){
			int element=s1.nextInt();
			arr[free]=element;
			int i=free-1;
			while(i>=0 && element<arr[i]){
				arr[i+1]=arr[i];
				arr[i]=element;
				i--;
			}
			free++;
			if(free!=arr.length-1){
				arr[free]=Integer.MAX_VALUE;
			}
		}
		
		System.out.print(Arrays.toString(arr)+" ");
		
	}
}
