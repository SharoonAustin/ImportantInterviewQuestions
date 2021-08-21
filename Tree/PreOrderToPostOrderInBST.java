package Tree;

public class PreOrderToPostOrderInBST {
	BinaryTreeNode root;
	static int i=0;
	
	public BinaryTreeNode PreOrderToPostOrderInBST(int arr[]){
		i=0;
		return PreOrderToPostOrderInBST(arr,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	
	
	public BinaryTreeNode PreOrderToPostOrderInBST(int arr[], int minValue,int maxValue) {
		
		if(i==arr.length)
			return null;

		BinaryTreeNode root=null;

		if(arr[i]>minValue && arr[i]<maxValue)
			root=new BinaryTreeNode(arr[i++]);
		else
			return null;
		
		root.left=PreOrderToPostOrderInBST(arr,minValue,root.key);
		root.right=PreOrderToPostOrderInBST(arr,root.key,maxValue);
		
		return root;
	}

	public void postOrderTraversal(BinaryTreeNode root){
		if(root==null)
			return ;
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.key+" ");
	}

	public static void main(String[] args) {
		PreOrderToPostOrderInBST b1=new PreOrderToPostOrderInBST();
		int arr[]={40,30,35,80,100};
		b1.postOrderTraversal(b1.PreOrderToPostOrderInBST(arr));
		
	}

}
