package Tree;

import java.util.*;

class Store{
	int distance;
	BinaryTreeNode node;
	Store(int distance, BinaryTreeNode node){
		this.distance=distance;
		this.node=node;
	}
}

public class BottomViewOfBinaryTree {
	BinaryTreeNode root;	
	
	static TreeMap<Integer,Integer> tm=new TreeMap<Integer,Integer>();
    static ArrayList<Integer> al=new ArrayList<Integer>();
    
	public static ArrayList<Integer> bottomView(BinaryTreeNode root){
		travel(root,0);
		for(int i=tm.firstKey();i<=tm.lastKey();i++)
			al.add(tm.get(i));
		
		System.out.print(al.toString());
		return al;
	}
	
	public static void travel(BinaryTreeNode root,int distance){
     Queue<Store> queue=new LinkedList<Store>();
     tm.put(distance,root.key);
     queue.add(new Store(distance, root));
     while(!queue.isEmpty()){
    	 Store temp=queue.poll();
    	 BinaryTreeNode Node=temp.node;
    	 //int key=temp.key;
    	 distance=temp.distance;
    	 
    	 if(Node.left!=null){
    	 queue.add(new Store(distance-1, Node.left));
    	 tm.put(distance-1,Node.left.key);
    	 }
    	 
    	 if(Node.right!=null){
        	 queue.add(new Store(distance+1, Node.right));
        	 tm.put(distance+1,Node.right.key);
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
		b1.root.right.right.right.right=new BinaryTreeNode(1);

		
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