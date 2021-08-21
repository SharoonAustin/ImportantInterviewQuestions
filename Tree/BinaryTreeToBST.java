package Tree;
import java.util.*;

public class BinaryTreeToBST {
	BinaryTreeNode root;
	static ArrayList<Integer> l1=new ArrayList<Integer>();
	static int increaseIndex=0;
	
	//Steps followed to convert a binary tree to BinarySearchTree
	//1) Do the Inorder traversal of the BT and store it in the array or list.
	//2) Sort the list
	//3)Again Do the inorder traversal and modify the data.
	
	
	public BinaryTreeNode BTtoBST(BinaryTreeNode root){
		l1.clear();
		increaseIndex=0;
		storeTheResults(root);
		Collections.sort(l1);
		BinaryTreeNode node=BTtoBSTUtil(root,l1);
		
		return node;
	}
	
	public static BinaryTreeNode BTtoBSTUtil(BinaryTreeNode root,ArrayList l1){
		if(root==null)
			return null;
		BTtoBSTUtil(root.left,l1);
		root.key=(Integer) l1.get(increaseIndex++);
		BTtoBSTUtil(root.right,l1);
		
		return root;
	}
	
	
	public static void storeTheResults(BinaryTreeNode root){
		if(root==null)
			return ;
		else 
			storeTheResults(root.left);
			l1.add(root.key);
			storeTheResults(root.right);
	}
	
	
	public static void main(String[] args) {
		BinaryTreeToBST b1=new BinaryTreeToBST();
		b1.root=new BinaryTreeNode(1);
		b1.root.left=new BinaryTreeNode(2);
		b1.root.right=new BinaryTreeNode(3);
		b1.root.left.left=new BinaryTreeNode(4);
		BinaryTree.levelOrderTraversal(b1.BTtoBST(b1.root));
		
		
	}

}
