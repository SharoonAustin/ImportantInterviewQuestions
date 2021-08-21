package Tree;

public class constructBSTFromOnlyPreOrder {
	
	static BinaryTreeNode root;
	public BinaryTreeNode BinaryTreeNodeBSTFromPreOrder(int preorder[],BinaryTreeNode root,int start,int end){
		
		while(start<=end){
		
		if(start==end)
			return null;
		if(root==null)
			root=new BinaryTreeNode(preorder[start++]);
		
		else if(preorder[start]<=root.key)
			root.left=BinaryTreeNodeBSTFromPreOrder(preorder,root.left,++start,end);
		
		else
			root.right=BinaryTreeNodeBSTFromPreOrder(preorder,root.right,++start,end);
		}
		
		return root;

		}
	

	public static void main(String[] args) {
		constructBSTFromOnlyPreOrder b1=new constructBSTFromOnlyPreOrder();
		int []preorder={10, 5, 1, 7, 40, 50};
		BinaryTreeNode node=b1.BinaryTreeNodeBSTFromPreOrder(preorder,root,0,preorder.length-1);
		BinaryTree.levelOrderTraversal(node);
		
	}

}
