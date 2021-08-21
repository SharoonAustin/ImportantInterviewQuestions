package Arrays;
import java.util.*;

public class SmallestPositiveNumber {
	
	 static long smallestpositive(long[] array, int n){ 
	        Arrays.sort(array);
	        long answer=Integer.MAX_VALUE;
	        long counter=0;
	        long sum=0;
	        for(int i=0; i<array.length;i++){
	        	sum+=array[i];
		        counter++;
		        if(counter!=sum)
		        	return counter;
	        }
	        return Math.min(answer,counter+1);
	    }
	
	public static void main(String[] args) {
		long array[]={1, 10, 3, 11, 6, 15};
		int n=array.length;
		System.out.println(smallestpositive(array, n));
	}

}
