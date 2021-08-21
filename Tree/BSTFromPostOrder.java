package Tree;

public class BSTFromPostOrder {

	private static BinaryTreeNode constructBST(int[] postorder, int start, int end) {
		if(start>end)
			return null;
		
		int value=postorder[end];
		BinaryTreeNode root=new BinaryTreeNode(value);

		int i=end-1;
		while(i>=0 && postorder[i]>value)
			i--;
		
		root.left=constructBST(postorder, start, i);
		root.right=constructBST(postorder, i+1, end-1);
		
		return root;
		
	}
	
	private static void preOrderTraversal(BinaryTreeNode root) {
		if(root==null)
			return ;
		System.out.print(root.key+" ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
		
	}
	
	public static void main(String[] args) {
		int postorder[]={1, 3, 2, 5, 7, 6, 4};
		preOrderTraversal(constructBST(postorder, 0, postorder.length-1));

	}

}
