package SlidingWindow;
import java.util.*;
public class MaxSumSubarrayOfSizeK {
	
	public static int getMax(ArrayList<Integer> list, int K){
		int i=0, j=0, sum=0, temp=K,maxSum=Integer.MIN_VALUE;
		while(j<list.size()){
			if(temp>0){
				sum=sum+list.get(j);
				j++;
				temp--;
			}
			else{
				maxSum=Math.max(maxSum, sum);
				sum=sum-list.get(i);
				i++;
				temp=1;
			}
		}
		maxSum=Math.max(maxSum, sum);
		return maxSum;
	}
	
	
	public static void main(String[] args) {
		ArrayList<Integer> alist=new ArrayList<Integer>();
		alist.add(2);
		alist.add(5);
		alist.add(1);
		alist.add(8);
		alist.add(2);
		alist.add(9);
		alist.add(1);
		System.out.println(getMax(alist, 3));
	}

}
