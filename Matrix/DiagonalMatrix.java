package Matrix;

public class DiagonalMatrix {

	public static void set(int newArray[],int i,int j,int x){
		if(i==j)
			newArray[i]=x;
	}
	
	public static int get(int newArray[],int i,int j){
		if(i==j)
			return newArray[i];
		else
			return 0;
	}
	public static void display(int arr[][],int newArr[],int i,int j){
		for(int m=0;m<i;m++){
			for(int n=0;n<j;n++){
				if(m==n)
					System.out.print(newArr[m]+" ");
				else{
					System.out.print(arr[m][n]+" ");
				}
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		int arr[][]=new int[5][5];
		int newArray[]=new int[arr[0].length];	
		set(newArray, 0, 0, 1);
		set(newArray, 1, 1, 2);
		set(newArray, 2, 2, 3);
		set(newArray, 3, 3, 4);
		set(newArray, 4, 4, 5);
		System.out.println(get(newArray,4,4));
		System.out.println();
		display(arr, newArray, 5, 5);
	}

}
