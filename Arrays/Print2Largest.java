package Arrays;

public class Print2Largest {

	 public static int print2largest(int A[]) 
	    {
	        int firstMax=A[0];
	        int secondMax=-1;
	        for(int i=1;i<A.length;i++){
	            if(A[i]>firstMax){
	                secondMax=firstMax;
	                firstMax=A[i];
	            }
	            else if(A[i]<firstMax && A[i]>secondMax){
	                secondMax=A[i];
	            }
	            else{}
	        }
	        return secondMax;
	    }
	 
	public static void main(String[] args) {
		int arr[]={1,1,1,1,1};
		System.out.println(print2largest(arr));
	}

}
