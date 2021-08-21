package Tree;
import java.util.*;

public class LeftViewOfBinaryTree {
	BinaryTreeNode root;
	
	static HashMap<Integer,BinaryTreeNode> hm=new HashMap<Integer,BinaryTreeNode>();
	static ArrayList<Integer> al=new ArrayList<Integer>();
	
	public static ArrayList<Integer> leftViewOfBinaryTree(BinaryTreeNode root){
		hm.clear();
		al.clear();
		hm.put(0,root);
		travel(0,root);
		
		for(Map.Entry<Integer, BinaryTreeNode> el:hm.entrySet()){
			if(el.getValue()!=null)
				al.add(el.getValue().key);
		}
		return al;
	}
	
	
	private static void travel(int distance, BinaryTreeNode root) {
		if(root==null)
			return;
		
		if(root.left!=null){
			hm.putIfAbsent(distance+1, root.left);
			travel(distance+1, root.left);
		}
		
		if(root.right!=null){
			hm.putIfAbsent(distance+1, root.right);
			travel(distance+1, root.right);
		}
	}


	public static void main(String[] args) {
		LeftViewOfBinaryTree b1=new LeftViewOfBinaryTree();
		b1.root=new BinaryTreeNode(1);
		b1.root.left=new BinaryTreeNode(2);
		b1.root.right=new BinaryTreeNode(3);
		b1.root.left.left=new BinaryTreeNode(4);
		b1.root.left.right=new BinaryTreeNode(5);
		b1.root.right.left=new BinaryTreeNode(6);
		b1.root.right.right=new BinaryTreeNode(7);
		System.out.println(b1.leftViewOfBinaryTree(b1.root).toString());
		
		
		LeftViewOfBinaryTree b2=new LeftViewOfBinaryTree();
		
		b2.root=new BinaryTreeNode(2);
		
		b2.root.left=new BinaryTreeNode(2);
		b2.root.right=new BinaryTreeNode(13);
		
		b2.root.left.left=new BinaryTreeNode(7);
		b2.root.left.right=new BinaryTreeNode(10);
		b2.root.right.left=new BinaryTreeNode(1);
		b2.root.right.right=new BinaryTreeNode(10);

		b2.root.left.left.left=new BinaryTreeNode(5);
		b2.root.left.left.right=new BinaryTreeNode(2);
		b2.root.left.right.right=new BinaryTreeNode(14);
		b2.root.right.left.left=new BinaryTreeNode(5);
		b2.root.right.left.right=new BinaryTreeNode(11);
		b2.root.right.right.right=new BinaryTreeNode(5);
		b2.root.right.right.left=new BinaryTreeNode(5);

		b2.root.left.left.left.left=new BinaryTreeNode(13);

		System.out.println(b2.leftViewOfBinaryTree(b2.root).toString());


		


	}

}
