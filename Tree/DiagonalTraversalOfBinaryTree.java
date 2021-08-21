package Tree;
import java.util.*;
public class DiagonalTraversalOfBinaryTree {
	BinaryTreeNode root;
	
	static HashMap<Integer,ArrayList<Integer>> hm=new HashMap<Integer,ArrayList<Integer>>();
	static ArrayList<Integer> al=new ArrayList<Integer>();
	
	public static void diagonalTraversal(BinaryTreeNode root){
		travel(0,root);
		for(int i=0;i<hm.size();i++){
			for(int j=0; j<hm.get(i).size();j++){
				System.out.print(hm.get(i).get(j)+" ");
			}
		}
	}
	
	public static void travel(int distance, BinaryTreeNode root){
		if(root==null)
			return;
		
			hm.putIfAbsent(distance, new ArrayList<Integer>());
			hm.get(distance).add(root.key);
			travel(++distance,root.left);
			travel(--distance,root.right);
		}

	public static void main(String[] args) {
		DiagonalTraversalOfBinaryTree b1=new DiagonalTraversalOfBinaryTree();
		
		b1.root=new BinaryTreeNode(1);
		b1.root.left=new BinaryTreeNode(2);
		b1.root.right=new BinaryTreeNode(3);
		b1.root.left.left=new BinaryTreeNode(4);
		b1.root.left.right=new BinaryTreeNode(5);
		b1.root.left.right.left=new BinaryTreeNode(8);
		b1.root.right.left=new BinaryTreeNode(6);
		b1.root.right.right=new BinaryTreeNode(7);
		b1.diagonalTraversal(b1.root);
	}

}
