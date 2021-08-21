package Tree;
import java.util.*;

public class AllKSumPathInBinaryTree {

	BinaryTreeNode root;
	public static void printThePath(ArrayList<Integer> l1, int index){
		for(int i=index;i<l1.size();i++)
			System.out.print(l1.get(i)+" ");
		System.out.println();
	}
	
	public void printSumPath(BinaryTreeNode root, int K){
		ArrayList<Integer> l1=new ArrayList<Integer>();
		printSumPathUtil(root,l1,K);
		
	}
	public void printSumPathUtil(BinaryTreeNode root,ArrayList<Integer> l1,int K){
		if(root==null)
			return;
		
		l1.add(root.key);
		printSumPathUtil(root.left,l1,K);
		printSumPathUtil(root.right,l1,K);
		
		int sum=0;
		for(int i=l1.size()-1;i>=0;i--){
			sum+=l1.get(i);
			
			if(sum==K)
				printThePath(l1,i);
		}
		l1.remove(l1.size()-1);
	}
	
	
	
	public static void main(String[] args) {
		AllKSumPathInBinaryTree b1=new AllKSumPathInBinaryTree();
		b1.root = new BinaryTreeNode(1); 
		b1.root.left = new BinaryTreeNode(3); 
		b1.root.left.left = new BinaryTreeNode(2); 
		b1.root.left.right = new BinaryTreeNode(1); 
		b1.root.left.right.left = new BinaryTreeNode(1); 
		b1.root.right = new BinaryTreeNode(-1); 
		b1.root.right.left = new BinaryTreeNode(4); 
		b1.root.right.left.left = new BinaryTreeNode(1); 
		b1.root.right.left.right = new BinaryTreeNode(2); 
		b1.root.right.right = new BinaryTreeNode(5); 
		b1.root.right.right.right = new BinaryTreeNode(2); 
	  
	    int k = 5; 
	    b1.printSumPath(b1.root, k); 
	}

}
