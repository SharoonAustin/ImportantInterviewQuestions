package Tree;

import java.util.*;

public class VerticalTraversalOFtree {

static TreeMap<Integer,ArrayList<Integer>> hm=new TreeMap<Integer,ArrayList<Integer>>();
static ArrayList<Integer> l1=new ArrayList<Integer>();

		public static void VerticalTraversalOfBinaryTree(BinaryTreeNode root){
			if(root==null)
				return ;
			hm.put(0, new ArrayList<Integer>(Arrays.asList(root.key)));
			travel(0,root);
			for (Map.Entry mapElement : hm.entrySet()) 
	            l1.addAll((Collection<? extends Integer>) mapElement.getValue());
			
			for(int i=0;i<l1.size();i++){
				System.out.print(l1.get(i)+" ");
			}
			
		}

		public static void travel(int distance,BinaryTreeNode root){
		if(root==null)
			return;
		if(root.left!=null){
			hm.putIfAbsent(distance-1, new ArrayList<Integer>());
			hm.get(distance-1).add(root.left.key);
			travel(distance-1,root.left);
		}
		if(root.right!=null){
			hm.putIfAbsent(distance+1, new ArrayList<Integer>());
			hm.get(distance+1).add(root.right.key);
			travel(distance+1,root.right);
		}
		else{}
	}
	
	
	public static void main(String[] args) {
		TopViewOfBinaryTree t1=new TopViewOfBinaryTree();
		t1.root=new BinaryTreeNode(1);
		t1.root.left=new BinaryTreeNode(2);
		t1.root.right=new BinaryTreeNode(3);
		t1.root.left.left=new BinaryTreeNode(4);
		t1.root.left.right=new BinaryTreeNode(5);
		t1.root.right.right=new BinaryTreeNode(6);
		//t1.root.right.right.right=new BinaryTreeNode(6);
		VerticalTraversalOfBinaryTree(t1.root);
	}

}
