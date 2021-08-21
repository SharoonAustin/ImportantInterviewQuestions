package Tree;
import java.util.*;
public class MaximumWidthOfTree {
	BinaryTreeNode root;
	
	static TreeMap<Integer,ArrayList<Integer>> Hm=new TreeMap<Integer,ArrayList<Integer>>();
	static int maximum=0, currentMaximum=0;
	
	public int maximumWidthOfTree(BinaryTreeNode root){
		Hm.clear();
		Hm.put(0, new ArrayList<Integer>());
		calculateTheDistance(0,root);
		for(int i=0;i<Hm.size();i++){
			for(int j=0;j<Hm.get(i).size();j++){
				currentMaximum++;
			}
			maximum=Math.max(maximum, currentMaximum);
			currentMaximum=0;
		}
		return maximum;
	}
	
	public static void calculateTheDistance(int distance,BinaryTreeNode root){
        if(root==null)
            return ;
            
        	Hm.putIfAbsent(distance, new ArrayList<Integer>());
            Hm.get(distance).add(root.key);
            calculateTheDistance(distance+1,root.left);
            calculateTheDistance(distance+1,root.right);
        }
	
	public static void main(String[] args) {
		MaximumWidthOfTree b1=new MaximumWidthOfTree();
		b1.root=new BinaryTreeNode(4);
		b1.root.left=new BinaryTreeNode(4);
		b1.root.right=new BinaryTreeNode(10);
		b1.root.left.right=new BinaryTreeNode(5);
		b1.root.left.left=new BinaryTreeNode(10);
		b1.root.right.left=new BinaryTreeNode(7);
		b1.root.right.right=new BinaryTreeNode(2);
		b1.root.left.left.right=new BinaryTreeNode(3);
		b1.root.left.right.left=new BinaryTreeNode(8);
		
		System.out.println(b1.maximumWidthOfTree(b1.root));
		
	}

}
