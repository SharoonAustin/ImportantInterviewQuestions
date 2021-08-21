package Tree;
import java.util.*;

public class BoundaryTraversalOfBinaryTree {
	BinaryTreeNode root;
	static ArrayList<Integer> al=new ArrayList<Integer>();
	
	public static void leftTraversal(BinaryTreeNode root){
		if(root==null)
			return ;
		
		if(root.left!=null || root.right!=null){
			 al.add(root.key);
			leftTraversal(root.left);
			leftTraversal(root.right);
		}
	}
	
	private void leafTraversal(BinaryTreeNode root) {
		if(root==null)
			return ;
		
		if(root.left==null && root.right==null){
			 al.add(root.key);
		}
		else{
			leafTraversal(root.left);
			leafTraversal(root.right);
		}
	}
	
	private void rightTraversal(BinaryTreeNode root){
		if(root==null)
			return ;
		if(root.left!=null || root.right!=null){
		      rightTraversal(root.right);
		      rightTraversal(root.left);
	       al.add(root.key);
		}
	}
	
	
	public ArrayList<Integer> boundaryTraversal(BinaryTreeNode root){
		al.clear();
		if(root!=null){
			al.add(root.key);
			leftTraversal(root.left);
			leafTraversal(root);
			rightTraversal(root.right);
		}
		return al;
	}
	
	public static void main(String[] args) {
		BoundaryTraversalOfBinaryTree b1=new BoundaryTraversalOfBinaryTree();
		b1.root=new BinaryTreeNode(10);
		b1.root.left=new BinaryTreeNode(20);
		b1.root.right=new BinaryTreeNode(30);
		b1.root.left.left=new BinaryTreeNode(40);
		b1.root.left.right=new BinaryTreeNode(60);
		b1.root.right.right=new BinaryTreeNode(25);
		b1.root.left.right.left=new BinaryTreeNode(10);
		b1.root.left.right.right=new BinaryTreeNode(14);
		System.out.print(b1.boundaryTraversal(b1.root).toString());
	}

}
