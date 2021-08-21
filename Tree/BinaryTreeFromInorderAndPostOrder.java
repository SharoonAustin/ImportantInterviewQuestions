package Tree;
import java.util.*;
public class BinaryTreeFromInorderAndPostOrder {
	
	public static BinaryTreeNode btFromInorderAndPostorder(int inOrder[], int postOrder[], int inStart, int inEnd, int postStart, int postEnd, HashMap<Integer,Integer> hmap){
		if(inStart>inEnd)
			return null;
		
		//Last Value in the starting will be the root
		int value=postOrder[postEnd];
		BinaryTreeNode root=new BinaryTreeNode(value);
		
		//Finding the index of that value in the inOrder
		int index=hmap.get(value);
		
		int leftSize=index-inStart;
		int rightSize=inEnd-index;
		root.left=btFromInorderAndPostorder(inOrder, postOrder, inStart, index-1, postStart, postStart+leftSize-1, hmap);
		root.right=btFromInorderAndPostorder(inOrder, postOrder, index+1, inEnd, postEnd-rightSize, postEnd-1, hmap);

		return root;
	}
	
	
	public static void main(String[] args) {
		int inOrder[]={4, 2, 5, 1, 6, 3, 7};
		int postOrder[]={4, 5, 2, 6, 7, 3, 1};
		HashMap<Integer,Integer> hmap=new HashMap<Integer,Integer>();
		for(int i=0; i<inOrder.length; i++)
			hmap.put(inOrder[i], i);
		
		BinaryTree.levelOrderTraversal(btFromInorderAndPostorder(inOrder, postOrder, 0, inOrder.length-1, 0, postOrder.length-1, hmap));
		
	}

}
