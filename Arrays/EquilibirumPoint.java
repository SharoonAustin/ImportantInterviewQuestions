package Arrays;

public class EquilibirumPoint {
	
    public static int equilibriumPoint(long arr[], int n) {
        long sumOfArray=getSum(arr);
        long left=0;
        
        
        if(arr.length==1)
            return 1;
            
        for(int i=1;i<arr.length;i++){

            if(left==sumOfArray-arr[i])
                return i+1;
            left+=arr[i];
            sumOfArray-=arr[i];
        }
        return -1;
    }
    
    public static long getSum(long arr[]){
        long sum=0;
        for(int i=0; i<arr.length; i++)
            sum+=arr[i];
        return sum;
    }
	public static void main(String[] args) {
		long arr[]={32, 41, 34, 26, 34, 30, 10, 11, 23, 20, 10, 12, 25, 5, 7, 41, 7, 43, 25};
		System.out.println(equilibriumPoint(arr, arr.length));
	}

}
