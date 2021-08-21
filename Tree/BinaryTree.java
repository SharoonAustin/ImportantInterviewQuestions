package Tree;
import java.util.*;

class BinaryTreeNode{
	BinaryTreeNode left,right;
	int key;
	public BinaryTreeNode(int key){
		this.left=null;
		this.key=key;
		this.right=null;
	}
}

public class BinaryTree {
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
	


	public void recursivePreorderTraversal(BinaryTreeNode root){
		if(root==null)
			return;
		System.out.print(root.key+" ");
		recursivePreorderTraversal(root.left);
		recursivePreorderTraversal(root.right);
	}
	
	public void iterativePreorderTraversal(BinaryTreeNode root){
		Stack<BinaryTreeNode> stack=new Stack<BinaryTreeNode>();
		while(root!=null || !stack.isEmpty()){
			if(root!=null){
			System.out.print(root.key+" ");
			stack.push(root);
			root=root.left;
			}
			else{
				root=stack.pop();
				root=root.right;
			}
		}
	}
	
	
	public void recursiveInorderTraversal(BinaryTreeNode root){
		if(root==null)
			return ;
		else{
			recursiveInorderTraversal(root.left);
			System.out.print(root.key+" ");
			recursiveInorderTraversal(root.right);
		}
	}
	
	public void recursivePostOrderTraversal(BinaryTreeNode root){
		if(root==null)
			return ;
		else{
			recursiveInorderTraversal(root.left);
			recursiveInorderTraversal(root.right);
			System.out.print(root.key+" ");
		}
	}
	
	
	public void iterativeInorderTraversal(BinaryTreeNode root){
		Stack<BinaryTreeNode> stack=new Stack<BinaryTreeNode>();
		while(root!=null || !stack.isEmpty()){
			if(root!=null){
				stack.push(root);
				root=root.left;
			}
			else{
				root=stack.pop();
				System.out.print(root.key+" ");
				root=root.right;
			}
		}
		
	}
	
	public static void levelOrderTraversal(BinaryTreeNode root){
		Queue<BinaryTreeNode> q1=new LinkedList<BinaryTreeNode>();
		q1.add(root);
		while(!q1.isEmpty()){
			BinaryTreeNode temp=q1.poll();
			System.out.print(temp.key+" ");
			if(temp.left!=null)
				q1.add(temp.left);
			if(temp.right!=null)
				q1.add(temp.right);
		}
		
	}
	public int sumOfAllTreeNodes(BinaryTreeNode root){
		if(root!=null){
			int x=sumOfAllTreeNodes(root.left);
			int y=sumOfAllTreeNodes(root.right);
			return x+y+root.key;
		}
		return 0;
	}
	
	public int countAllNodes(BinaryTreeNode root){
		if(root!=null){
			return countAllNodes(root.left)+countAllNodes(root.right)+1;
		}
		return 0;
	}
	
	public int heightOfTree(BinaryTreeNode root){
		if(root==null)
			return 0;
		return 1+ Math.max(heightOfTree(root.left), heightOfTree(root.right));
	}
	
	public boolean searchValue(BinaryTreeNode root,int data){
		Queue<BinaryTreeNode> myQueue=new LinkedList<BinaryTreeNode>();
		myQueue.add(root);
		while(!myQueue.isEmpty()){
			BinaryTreeNode temp=myQueue.poll();
			if(temp.key==data){
				return true;
			}
			if(temp.left!=null){
				myQueue.add(temp.left);
			}
			if(temp.right!=null){
				myQueue.add(temp.right);
			}
			else{}
			}
		return false;
		}
	
		public void deleteNode(BinaryTreeNode root,int key){
			Queue<BinaryTreeNode> queue=new LinkedList<BinaryTreeNode>();
			
			if(key==root.key){
				BinaryTreeNode temp=root;
				
				if(root.left!=null){
				while(root.left!=null){
					root=root.left;
				}
				temp=root.left;
				root.left=null;
				}
				
				else if(root.right!=null){
					while(root.right!=null){
					root=root.right;
					}
					temp=root.right;
					root.right=null;
				}
				
				else{
					root=null;
				}
			}
			else{
				queue.add(root);
				while(!queue.isEmpty()){
					BinaryTreeNode temp=queue.poll();
					if(temp.key==key){
						if(temp.left!=null){
							temp=temp.left;
							temp.left=null;
							break;
						}
						else if(temp.right!=null){
							temp=temp.right;
							temp.right=null;
							break;
						}
						else if(temp.left==null && temp.right==null){
							temp=null;
							break;
						}
						else{}	
					}
					if(temp.left!=null){
						queue.add(temp.left);
					}
					if(temp.right!=null){
						queue.add(temp.right);
					}
					
				}
				
				
			}
			
		}
	
		public BinaryTreeNode formMirrorTree(BinaryTreeNode root){
			if(root==null)
				return null;
			
			BinaryTreeNode left;
			BinaryTreeNode right;
			
			left=formMirrorTree(root.left);
			right=formMirrorTree(root.right);
			
			root.left=right;
			root.right=left;
			
			return root;
		}
		
	public void postOrderTraversal(BinaryTreeNode root){
		if(root==null)
			return ;
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.key+" ");
	}
	
	public void iterativePostOrderTraversal(BinaryTreeNode root){
		Stack<BinaryTreeNode> stack=new Stack<BinaryTreeNode>();
		Stack<Integer> supportStack=new Stack<Integer>();
		if(root!=null)
			stack.push(root);
		
		while(!stack.isEmpty()){
			BinaryTreeNode popTheNode=stack.pop();
			
			supportStack.push(popTheNode.key);
			
			if(popTheNode.left!=null)
				stack.push(popTheNode.left);
			
			if(popTheNode.right!=null)
				stack.push(popTheNode.right);
			
		}
		
		while(!supportStack.isEmpty())
			System.out.print(supportStack.pop()+" ");
	}
	
	public ArrayList<Integer> leftViewOfBinaryTree(BinaryTreeNode root){
		ArrayList<Integer> a1=new ArrayList<Integer>();
		a1.add(root.key);
		while(root!=null){
			if(root.left!=null && root.right!=null || (root.left!=null && root.right==null)){
				root=root.left;
				a1.add(root.key);
			}
			else if(root.left==null && root.right!=null){
				root=root.right;
				a1.add(root.key);
			}
			
			else if(root.left==null && root.right==null){
				break;
			}
		}
		
		return a1;
		
	}
		
	public static void main(String[] args) {
		BinaryTree b1=new BinaryTree();
		b1.root=new BinaryTreeNode(1);
		b1.root.left=new BinaryTreeNode(2);
		b1.root.left.left=new BinaryTreeNode(4);
		b1.root.left.right=new BinaryTreeNode(5);
		b1.root.right=new BinaryTreeNode(3);
		b1.root.right.left=new BinaryTreeNode(6);
		b1.root.right.right=new BinaryTreeNode(7);
		//System.out.print("\n"+"Recursive Inorder Traversal: ");
		//b1.recursiveInorderTraversal(b1.root);
		/*b1.root.left.left=new BinaryTreeNode(4);
		b1.root.left.right=new BinaryTreeNode(5);
		b1.root.right.left=new BinaryTreeNode(6);
		b1.root.right.right=new BinaryTreeNode(7);
		b1.root.left.left.right=new BinaryTreeNode(8);*/
		/*System.out.print("Recursive Preorder Traversal: ");
		b1.recursivePreorderTraversal(b1.root);
		System.out.print("\n"+"Iterative Preorder Traversal: ");
		b1.iterativePreorderTraversal(b1.root);
		System.out.print("\n"+"Recursive Inorder Traversal: ");
		b1.recursiveInorderTraversal(b1.root);
		System.out.print("\n"+"Iterative Inorder Traversal: ");
		b1.iterativeInorderTraversal(b1.root);
		System.out.print("\n"+"Level order Traversal: ");
		b1.levelOrderTraversal(b1.root);
		System.out.print("\n"+"Sum of all nodes is: "+b1.sumOfAllTreeNodes(b1.root));
		System.out.print("\n"+"Number of nodes is: "+b1.countAllNodes(b1.root));
		System.out.print("\n"+"Height of the tree is:"+(b1.heightOfTree(b1.root)-1));
		System.out.println("\n"+b1.searchValue(b1.root, 2213));
		
		BinaryTree b2=new BinaryTree();
		b2.root=new BinaryTreeNode(1);
		b2.insertInTheTree(b2.root, 2);
		b2.insertInTheTree(b2.root, 3);
		b2.insertInTheTree(b2.root, 4);
		b2.insertInTheTree(b2.root, 5);
		System.out.print("\n"+"Level order Traversal: ");
		b1.levelOrderTraversal(b2.root);
		b2.deleteNode(b2.root, 2);
		System.out.print("\n"+"Level order Traversal after deleting an element: ");
		b2.levelOrderTraversal(b2.root);*/
		//System.out.print("\n"+"Left view of the binary tree: ");
		//System.out.print(b1.leftViewOfBinaryTree(b1.root).toString()+"\n");
		
		//System.out.println(b1.heightOfTree(b1.root));
		
		System.out.print("\n"+"Recurive post order traversal of tree: ");
		b1.postOrderTraversal(b1.root);
		System.out.print("\n"+"Iterative post order traversal of tree: ");
		b1.iterativePostOrderTraversal(b1.root);

	}

}
