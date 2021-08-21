package Tree;

import java.util.*;

class Storage{
	int key;
	int distance;
	BinaryTreeNode node;
	Storage(int key, int distance, BinaryTreeNode node){
		this.key=key;
		this.distance=distance;
		this.node=node;
	}
}

public class BottomOfBinaryTree1 {
	BinaryTreeNode root;	
	
	static HashMap<Integer,Integer> tm=new HashMap<Integer,Integer>();
    static ArrayList<Integer> al=new ArrayList<Integer>();
    
	public static ArrayList<Integer> bottomView(BinaryTreeNode root){
		travel(root,0);
		
		System.out.print(al.toString());
		return al;
	}
	
	public static void travel(BinaryTreeNode root,int distance){
     Queue<Storage> queue=new LinkedList<Storage>();
     tm.put(distance,root.key);
     queue.add(new Storage(root.key, distance, root));
     while(!queue.isEmpty()){
    	 Storage temp=queue.poll();
    	 int key=temp.key;
    	 distance=temp.distance;
    	 
    	 if(temp.node.left!=null){
    	 queue.add(new Storage(temp.node.left.key, distance-1, temp.node.left));
    	 tm.put(distance-1,temp.node.left.key);
    	 }
    	 
    	 if(temp.node.right!=null){
        	 queue.add(new Storage(temp.node.right.key, distance+1, temp.node.right));
        	 tm.put(distance+1,temp.node.right.key);
        }
    	 
    	 
    	 }
    	 
    }
	
	public static void main(String[] args) {
		
		/*
		 *14 14 3 N 8 8 12 N 6 17 3 N 1 11 10 N 6 6 13 N 10 17 7 N 11 7
		 * */
		
		BottomViewOfBinaryTree b1=new BottomViewOfBinaryTree();
		b1.root=new BinaryTreeNode(14);
		b1.root.left=new BinaryTreeNode(14);
		b1.root.right=new BinaryTreeNode(3);
		
		b1.root.left.right=new BinaryTreeNode(8);
		b1.root.right.left=new BinaryTreeNode(8);
		b1.root.right.right=new BinaryTreeNode(12);
		
		b1.root.left.right.right=new BinaryTreeNode(6);
		b1.root.right.left.left=new BinaryTreeNode(17);
		b1.root.right.left.right=new BinaryTreeNode(3);
		b1.root.right.right.right=new BinaryTreeNode(1);

		b1.root.left.right.right.left=new BinaryTreeNode(11);
		b1.root.left.right.right.right=new BinaryTreeNode(10);
		b1.root.right.left.left.right=new BinaryTreeNode(6);
		b1.root.right.left.right.left=new BinaryTreeNode(6);
		b1.root.right.left.right.right=new BinaryTreeNode(13);
		b1.root.right.right.right.right=new BinaryTreeNode(10);

		
		b1.root.left.right.right.left.left=new BinaryTreeNode(17);
		b1.root.left.right.right.left.right=new BinaryTreeNode(7);
		b1.root.left.right.right.right.right=new BinaryTreeNode(11);
		b1.root.right.left.left.right.left=new BinaryTreeNode(7);
		
		b1.bottomView(b1.root);
	}

}






/*public class BottomViewOfBinaryTree {
	
	public static void main(String args[]) {
		

	}
}
*/