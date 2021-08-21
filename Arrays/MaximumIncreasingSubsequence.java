package Arrays;
import java.util.*;

class MaximumIncreasingSubsequence{
public static void main(String args[]){
int arr[]={3, 2, 6, 4, 5, 1};
int sum[]=new int[arr.length];
Arrays.fill(sum, 0);
sum[0]=arr[0];
int i=0;
int maxIdx=0;
ArrayList<ArrayList<Integer>>aList=new ArrayList<ArrayList<Integer>>(); 
 
for(int current=1;current<arr.length;current++){
	ArrayList<Integer> a1 = new ArrayList<Integer>();
	while(i<current){
		if(arr[i]<arr[current] && sum[current]<arr[current]+sum[i]){
			sum[current]=arr[current]+sum[i];
			a1.add(i);
		}
		i++;
	}
	if(sum[current]==0){
	sum[current]=arr[i];
	}
	if(sum[current]>=sum[maxIdx]){
		maxIdx=current;
	}
	aList.add(a1);
	i=0;
}

ArrayList<Integer> a2=new ArrayList<Integer>();

if(maxIdx>0){
for(int m=0;m<aList.get(maxIdx-1).size();m++){
a2.add(arr[aList.get(maxIdx-1).get(m)]);
System.out.print(arr[aList.get(maxIdx-1).get(m)]+" ");
}
}
a2.add(arr[maxIdx]);
System.out.print(arr[maxIdx]);

}
}