package Matrix;

public class LowTriangularMatrixRowByRow {
	
	static int count=0;
	private static void set(int[] newArray, int i, int j, int k) {
		if(newArray[count]!=0)
			newArray[((i*(i-1))/2)+j]=k;
		else
			newArray[((i*(i-1))/2)+j+1]=k;
		count++;
	}
	
	private static int get(int[] newArray, int i, int j){
		return newArray[((i*(i-1))/2)+j];
	}
	/*static int count1=0;
	private static void printMatrix(int arr[][],int newArray[],int i,int j){
		for(int m=0;m<i;m++){
			for(int n=0;n<=m;n++){
				System.out.print(newArray[count1]+" ");
				count1++;
			}
			System.out.println();
		}
	}*/
	
	public static void main(String[] args) {
		int arr[][]=new int[5][5];
		int size=(arr[0].length*(arr.length+1))/2;
		int newArray[]=new int[size];	
		set(newArray, 0,0,0);
		set(newArray, 1,0,1);
		set(newArray, 1,1,2);
		System.out.print(get(newArray, 1, 1));
	}

}
