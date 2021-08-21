package Tree;

public class BSTFromInorder {
	
	public static BinaryTreeNode constructBST(int inorder[], int start, int end){
		if(start>end)
			return null;
		
		int mid=start+(end-start)/2;
		
		BinaryTreeNode root=new BinaryTreeNode(inorder[mid]);
	
		root.left=constructBST(inorder, start, mid-1);
		root.right=constructBST(inorder, mid+1, end);
		
		return root;
	}

	public static void main(String[] args) {
		int inorder[]={1, 2, 3, 4, 5, 6, 7};
		BinaryTree.levelOrderTraversal(constructBST(inorder, 0, inorder.length-1));
		
	}
	
}


