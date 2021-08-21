package Tree;

public class NthNodeInorderTraversal {
	BinaryTreeNode root;
	static int i=0;
	public static void inOrderTraversal(BinaryTreeNode root,int n){
		if(root==null){
			return ;
		}
		inOrderTraversal(root.left,n);
		i++;
		if(i==n)
			System.out.print(root.key);
		inOrderTraversal(root.right,n);
	}
	
	public static void main(String[] args) {
		NthNodeInorderTraversal b1=new NthNodeInorderTraversal();

		b1.root=new BinaryTreeNode(1);
		b1.root.left=new BinaryTreeNode(2);
		b1.root.right=new BinaryTreeNode(3);
		b1.root.left.left=new BinaryTreeNode(4);
		b1.root.left.right=new BinaryTreeNode(5);
		b1.root.right.left=new BinaryTreeNode(6);
		b1.root.right.right=new BinaryTreeNode(7);
		b1.inOrderTraversal(b1.root, 5);
	}

}
