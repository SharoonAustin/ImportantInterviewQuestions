package Tree;
import java.util.*;
public class BSTFromPreorderAndInorder {
	static int preIndex=0;
	static BinaryTreeNode root;
	static HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
	public BinaryTreeNode constructTree(int inorder[], int []preorder){
		
		for(int i=0;i<inorder.length;i++){
			hm.put(inorder[i],i);
		}
		
		BinaryTreeNode node=constructTreeUtil(inorder,preorder,0,preorder.length-1);
		return node;
	}
	
	//Steps we followed here:-
	//In BST, Inorder is always in the ascending order.
	//1) Stored the inorder along with index in the hashmap
	
	
	public static BinaryTreeNode constructTreeUtil(int inorder[], int []preorder,int startIndex,int endIndex){
		if(startIndex>endIndex)
			return null;
		   
			BinaryTreeNode tNode = new BinaryTreeNode(preorder[preIndex++]); 
	  
	        if (startIndex == endIndex) 
	            return tNode;
	  
	        int inIndex = hm.get(tNode.key);
	  
	       
	        tNode.left = constructTreeUtil(inorder, preorder, startIndex, inIndex - 1); 
	        tNode.right = constructTreeUtil(inorder, preorder, inIndex + 1, endIndex); 
	  
	        return tNode; 
	}
	
	public static void main(String[] args) {
		BSTFromPreorderAndInorder b1=new BSTFromPreorderAndInorder();
		int [] prorder={3,1,0,2,4,5};
		int[] inOrder={0,1,2,3,4,5};
		BinaryTreeNode node=b1.constructTree(inOrder, prorder);
		BinaryTree.levelOrderTraversal(node);
		}
		

}
