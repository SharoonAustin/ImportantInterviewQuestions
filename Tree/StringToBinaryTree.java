package Tree;

import java.util.logging.Level;

public class StringToBinaryTree {
	int start=0;
	public BinaryTreeNode stringToBinary(String s){
		if(s==null|| s.length()==0)
			return null;
		else
			return stringHelper(s);
	}
	
	public BinaryTreeNode stringHelper(String str){
		if(start>str.length())
			return null;
		
		//Logic for negative value
		boolean neg=false;
		if(str.charAt(start)=='-'){
			neg=true;
			start++;
		}
				
		//Fetching the value
		int num=0;
		
		while(start<str.length() && Character.isDigit(str.charAt(start))){
			int digit=Character.getNumericValue(str.charAt(start));
			num=num*10+digit;
			start++;
		}
		
		if(neg) num=-num;
		BinaryTreeNode root=new BinaryTreeNode(num);
		
		if(start>=str.length())
			return root;
		
		if(start<str.length() && str.charAt(start)=='('){
			start++;
			root.left=stringHelper(str);
		}
		
		if(start<str.length() && str.charAt(start)=='('){
			start++;
			root.right=stringHelper(str);
		}
		
		if(start<str.length() && str.charAt(start)==')'){
			start++;
			return root;
		}
		return root;
	}
	
	public static void main(String[] args) {
		String str="-42(2(3)(1))(6(-5))";
		StringToBinaryTree b1=new StringToBinaryTree();
		BinaryTreeNode root=b1.stringToBinary(str);
		Tree.BinaryTree.levelOrderTraversal(root);
	}
	
}
