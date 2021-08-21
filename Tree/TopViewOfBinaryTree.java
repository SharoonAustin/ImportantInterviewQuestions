package Tree;

import java.util.*;


public class TopViewOfBinaryTree {
	BinaryTreeNode root;

	public BinaryTreeNode insertInTheTree(BinaryTreeNode root,int data){
		if(root==null){
			BinaryTreeNode node=new BinaryTreeNode(data);
		}
		else{
			Queue<BinaryTreeNode> q1=new LinkedList<BinaryTreeNode>();
			q1.add(root);
			while(!q1.isEmpty()){
				BinaryTreeNode temp=q1.poll();
				if(temp.left==null){
					temp.left=new BinaryTreeNode(data);
					break;
				}
				if(temp.left!=null)
					q1.add(temp.left);
				
				if(temp.right==null){
					temp.right=new BinaryTreeNode(data);
					break;
				}
				if(temp.right!=null)
					q1.add(temp.right);
			}
		}
		return root;
	}
	
	
	static HashMap<BinaryTreeNode,Integer> hm=new HashMap<BinaryTreeNode,Integer>();
	
	public static void travel(BinaryTreeNode root, int distance){
		if(root==null)
			return;
		if(root.left!=null){
			hm.put(root.left,distance-1);
			travel(root.left,distance-1);
		}
		if(root.right!=null){
			hm.put(root.right, distance+1);
			travel(root.right,distance+1);
		}
		else{}
	}
	
	public static void levelOrderTraversal(BinaryTreeNode root, HashMap<BinaryTreeNode, Integer> hm2){
		Queue<BinaryTreeNode> q1=new LinkedList<BinaryTreeNode>();
		q1.add(root);
		
		while(!q1.isEmpty()){
			BinaryTreeNode temp=q1.poll();
			
			if(root==temp){
				System.out.print(temp.key+" ");
			}

			if(temp.left!=null){
				q1.add(temp.left);
				System.out.print(temp.left.key+" ");
			}
			if(temp.right!=null){
				q1.add(temp.right);
				System.out.print(temp.right.key+" ");
			}
		}
		
		
	}
	
	
	public void topViewOfBinaryTree(BinaryTreeNode root){
		if(root==null)
			return ;
		hm.put(root,0);
		travel(root,0);
		levelOrderTraversal(root,hm);
	}
	
	
	public static void main(String[] args) {
		TopViewOfBinaryTree t1=new TopViewOfBinaryTree();
		t1.root=new BinaryTreeNode(1);
		t1.root.right=new BinaryTreeNode(2);
		t1.root.right.right=new BinaryTreeNode(5);
		t1.root.right.right.left=new BinaryTreeNode(3);
		t1.root.right.right.left.right=new BinaryTreeNode(4);
		t1.root.right.right.right=new BinaryTreeNode(6);

		/*t1.insertInTheTree(t1.root,2);
		t1.insertInTheTree(t1.root,3);
		t1.insertInTheTree(t1.root,4);
		t1.insertInTheTree(t1.root,5);
		t1.insertInTheTree(t1.root,6);
		t1.insertInTheTree(t1.root,7);*/
		t1.topViewOfBinaryTree(t1.root);
	}

}
