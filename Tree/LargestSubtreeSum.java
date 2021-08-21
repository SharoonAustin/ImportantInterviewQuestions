package Tree;

public class LargestSubtreeSum {

	static BinaryTreeNode root;
	static int currentSum=0;
	static int maxSum=0;
	
	public static int largestSum(BinaryTreeNode root){
		if(root==null)
			return 0;
		largestSumUtil(root);
		return maxSum;
	}
	
	public static int largestSumUtil(BinaryTreeNode root){

		if(root==null)
			return 0;
		int left=largestSumUtil(root.left);
		int right=largestSumUtil(root.right);
		int current=root.key+left+right;
		maxSum=Math.max(maxSum, current);
		return current;
	}
	
	public static void main(String[] args) {
		LargestSubtreeSum b1=new LargestSubtreeSum();
		b1.root=new BinaryTreeNode(-1);
		b1.root.left=new BinaryTreeNode(2);
		b1.root.right=new BinaryTreeNode(3);
		
		b1.root.left.left=new BinaryTreeNode(4);
		b1.root.left.right=new BinaryTreeNode(5);
		b1.root.right.left=new BinaryTreeNode(-6);
		b1.root.right.right=new BinaryTreeNode(-2);
				
		System.out.println(b1.largestSum(b1.root));

	}

}
