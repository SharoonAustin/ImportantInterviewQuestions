package Stack;

public class ArrayImplementationOfStack {

	public void push(int arr[],int x, int top){
		if(top==arr.length){
			System.out.println("Stack Overflow");
			return ;
		}
		arr[++top]=x;
	}
	public int pop(int arr[], int top){
		if(top==-1)
			return -1;
		int temp=top;
		top-=1;
		return arr[temp];
	}
	
	
	
	
	public static void main(String[] args) {
		int arr[]=new int[10];
		int top=-1;
		
	}

}
