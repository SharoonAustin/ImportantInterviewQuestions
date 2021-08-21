package Tree;
import java.util.*;
public class ConstructBSTFromInorderAndLevelOrder {
	static HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
	static int preIndex=0;
	
	public BinaryTreeNode buildTree(int inOrder[],int levelOrder[]){
		hm.clear();
		preIndex=0;
		
		for(int i=0;i<inOrder.length;i++)
			hm.put(inOrder[i], i);
		
		BinaryTreeNode node=build(inOrder, levelOrder, 0, inOrder.length-1);
		return node;
	}
	
	public static BinaryTreeNode build(int inOrder[],int levelOrder[],int start,int end){
			
		if(start>end)
			return null;
		   
			BinaryTreeNode tNode = new BinaryTreeNode(levelOrder[preIndex++]); 
	  
	        if (start == end) 
	            return tNode;
	  
	        int index = hm.get(tNode.key);
	  
	        tNode.left = build(inOrder, levelOrder, start, index - 1); 
	        tNode.right = build(inOrder, levelOrder, index + 1, end); 
	  
	        return tNode; 
	}
	

	public static void main(String[] args) {
		ConstructBSTFromInorderAndLevelOrder b1=new ConstructBSTFromInorderAndLevelOrder();
		int inorder[]={3,1,4,0,5,2,6};
		int levelOrder[]={0,1,2,3,4,5,6};
		b1.buildTree(inorder, levelOrder);
	}

}
