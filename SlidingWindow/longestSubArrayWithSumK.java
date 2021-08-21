package SlidingWindow;

public class longestSubArrayWithSumK {

	public static int subArray(int arr[], int K, int countTillNow){
		int i=0,j=0,sumTillNow=0;
		while(j<arr.length){
			sumTillNow+=arr[j];
			
			if(sumTillNow==K){
				printAllOfThem(i, j, arr);
				countTillNow=Math.min(countTillNow, j-i+1);
			}
			if(sumTillNow>K){
				while(sumTillNow>K){
					if(arr[i]<0)
						sumTillNow+=arr[i];
					else
						sumTillNow-=arr[i];
					i++;
					if(sumTillNow==K){
						printAllOfThem(i, j, arr);
					}
				}
			}
			
			j++;
		}
		
		return countTillNow; 
	}

	public static void printAllOfThem(int startIndex, int endIndex, int arr[]){
	for(int i=startIndex; i<=endIndex; i++)
		System.out.print(arr[i]+" ");
	System.out.println();
	}

	
	public static void main(String[] args) {
		int arr[]={5, 6, -5, 5, 3, 5, 3, -2, 0};
		int K=8;
		int countTillNow=Integer.MAX_VALUE;
		System.out.println(subArray(arr, K, countTillNow));
	}

}
