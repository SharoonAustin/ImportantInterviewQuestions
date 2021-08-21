package Tree;

public class BSTFromPreorder {
	
	public static BinaryTreeNode constructBST(int preorder[], int start, int end){
		if(start>end)
			return null;
		
		int value=preorder[start];

		BinaryTreeNode root=new BinaryTreeNode(value);
		int i=start+1;
		while(i<end && preorder[i]<value)
			i++;
		
		root.left=constructBST(preorder, start+1, i-1);
		root.right=constructBST(preorder, i, end);
		
		return root;
	}
	
	public static void main(String[] args) {
		int preorder[]={8, 5, 1, 7, 10, 12};
		BinaryTree.levelOrderTraversal(constructBST(preorder, 0, preorder.length-1));
		
	}

}
