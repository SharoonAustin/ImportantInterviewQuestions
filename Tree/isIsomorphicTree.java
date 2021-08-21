package Tree;

public class isIsomorphicTree {
	BinaryTreeNode root;
	
	public static boolean isomrophicTree(BinaryTreeNode root1, BinaryTreeNode root2){
		
		if(root1==null && root2==null)
			return true;
		
		if(root1==null || root2==null)
			return false;
		
		if(root1.key!=root2.key)
			return false;
		
		return((isomrophicTree(root1.left,root2.left) && isomrophicTree(root1.right,root2.right)) || (isomrophicTree(root1.left,root2.right) && isomrophicTree(root1.right,root2.left)));
	}
	
	public static void main(String[] args) {
		isIsomorphicTree b1=new isIsomorphicTree();
		b1.root=new BinaryTreeNode(1);
		b1.root.left=new BinaryTreeNode(2);
		b1.root.right=new BinaryTreeNode(3);
		b1.root.left.left=new BinaryTreeNode(4);
		b1.root.left.right=new BinaryTreeNode(5);
		
		isIsomorphicTree b2=new isIsomorphicTree();
		b2.root=new BinaryTreeNode(1);
		b2.root.left=new BinaryTreeNode(5);
		b2.root.right=new BinaryTreeNode(2);
		b2.root.right.left=new BinaryTreeNode(4);
		b2.root.right.right=new BinaryTreeNode(5);
			
		System.out.println(isomrophicTree(b1.root,b2.root));
	}

}
