//Write the codes for the methods defined for Binary Tree ADT. Create a program to use the ADT.

// node class
class BinNode{
	//class variables
	private Object key;
	private BinNode left;
	private BinNode right;
	
	//constructor
	public BinNode(Object key) {
		this.key = key;
		left = right = null;
	}
	
	//get and set methods
	public Object getKey() {
		return key;
	}
	public BinNode getLeft() {
		return left;
	}
	public BinNode getRight() {
		return right;
	}
	public void setLeft(BinNode node) {
		this.left = node;
	}
	public void setRight(BinNode node) {
		this.right = node;
	}
	public void setKey(Object key) {
		this.key = key;
	}
	public boolean isLeaf(BinNode node) {
		if(node.getLeft() == null && node.getRight() == null) {
			return true;
		} else {
			return false;
		}
	}
}

class Stack {
	//node class that takes a binNode as its data
	class Node{
		BinNode node;
		Node next;
		public Node(BinNode node) {
			this.node = node;
			next = null;
		}
	}
	
	//class variables
	public static Node top;
	public int countNodes;
	
	//push method
	public void push(BinNode node) {
		if (top == null) {
			top = new Node(node);
		}
		Node current = top;
		while (current.next != null){ //traverses from head to the top
	         current = current.next; 
	      }
      current.next = new Node(node); //creates new node next to top          
      countNodes++;
	}
	
	//pop method
	public BinNode pop(){
		if(top == null){
			return null;
		}
		Node current = top;
		while (current.next.next != null){ 
			current = current.next; 
		}
		Node popped = current.next; 
		current.next = null; 
		countNodes--;  
		return popped.node;   
	}
	
	//checks if the stack is empty
	public boolean isEmpty(){
		if(countNodes == 0) {
			return true;
		} else {
			return false;
		}
	 }
	
	public BinNode top(){
	      Node current = top;
	      if (current.next == null){ 
	         return current.node;
	      }
	      while (current.next != null){ 
	         current = current.next;
	      }
	      BinNode top = current.node;
	      return top;
	   }
}

abstract class BinaryTreeADT{
	abstract boolean isEmpty();
	abstract void visit(BinNode node);
	abstract void preorder(BinNode node);
	abstract void traverse(); 
	abstract void insertion(BinNode node, Object key);
	abstract void insert(Object key);
	abstract boolean matchFound(BinNode node, Object key);
	abstract void search(Object key);
	abstract BinNode getRightMost(BinNode node, int level, boolean ifRight);
	abstract void deletion(BinNode node, Object key);
	abstract void delete(Object key);
	
}

class BinaryTree extends BinaryTreeADT{
	//class variables
	public static BinNode root;
	public int currentLevel;
	public BinNode rightMostNode;
		
	public BinaryTree() {
		root = null;
	}
	
	//checks if the tree is empty
	public boolean isEmpty() {
		if (root == null) {
			return true;
		} else {
			return false;
		}
	}
	
	//prints the key of the BinNode
	public void visit(BinNode node) {
		if(node.getKey() != null) {
			System.out.print(node.getKey() + " ");
		}
	}
		
	// pre-order traversal of the tree
	public void preorder(BinNode node) {
		if (node == null) {
			return;
		}
		visit(node);
		preorder(node.getLeft());
		preorder(node.getRight());
	}
	
	//post-order traversal of the node
	public void postorder(BinNode node){
		if (node == null) {
			return;
		}
		postorder(node.getLeft());
		postorder(node.getRight());
		visit(node);
	}
	
	//inorder traversal of the node
	public void inorder(BinNode node){
		if (node == null) {
			return;
		}
		postorder(node.getLeft());
		visit(node);
		postorder(node.getRight());
		
	}
	
	//traversal of binary tree
	public void traverse() {
		System.out.print("\nPre-order	: ");
		preorder(root);
		System.out.print("\nPost-order	: ");
		postorder(root);
		System.out.print("\nInorder		: ");
		inorder(root);
		System.out.println("");
	}
	
	//inserts new node to tree
	public void insertion(BinNode node, Object key) {
		//creates a root node 
		if(isEmpty()) {
			root = new BinNode (key);
			return;
		}
		
		//crate a stack object
		Stack stack = new Stack();
		stack.push(node);
		
		//link new node as child of a parent node
		while(!stack.isEmpty()) {
			BinNode temp = stack.top();
			stack.pop();
			
			//if the left side is not null, push into the stack
			if(temp.getLeft() != null) {
				stack.push(temp.getLeft());
			} else {
				temp.setLeft(new BinNode (key));
				break;
			}
			
			//if the right side is not null, push into the stack
			if (temp.getRight() != null) {
				stack.push(temp.getRight());
			} else {
				temp.setRight(new BinNode(key));
				break;
			}
		}
	}
	
	//method that the user will call to insert a node
	public void insert(Object key) {
		insertion(root, key);
		System.out.println(key + " has been inserted. ");
	}
	
	//searches for a key object within the tree
	public boolean matchFound(BinNode node, Object key) {
		if(node == null) {
			return false;
		}
		if(node.getKey() == key) {
			return true;
		}
		boolean foundOnLeft = matchFound(node.getLeft(), key);
		if(foundOnLeft) {
			return true;
		}
		boolean foundOnRight = matchFound(node.getRight(), key);
		return foundOnRight;
	}
	
	//method for the user to call the matchFound method
	public void search(Object key) {
		boolean found = matchFound(root, key);
		if(found == true) {
			System.out.println("Found. " + key + " is part of the tree.");
		} else {
			System.out.println("Not found. " + key + " is not part of the tree.");
		}
	}
	
	//gets the deepest rightmost node of the tree
	public BinNode getRightMost(BinNode node, int level, boolean ifRight) {
		if(node == null) {
			return node;
		}
		if(node.isLeaf(node) && ifRight && level > currentLevel) {
			rightMostNode = node;
			currentLevel = level;
		}
		getRightMost(node.getLeft(), level+1, true);
		getRightMost(node.getRight(), level+1, false);
		return rightMostNode;
	}
	
	//deletes a node based on the searchKey
	public void deletion(BinNode node, Object key) {
		if(node == null) {
			return;
		}
		if(node.getKey() == key) {
			BinNode rightMostNode = getRightMost(root, 0, false); 
			node.setKey(rightMostNode.getKey());
			rightMostNode.setKey(null);	
		}
		deletion(node.getLeft(), key);
		deletion(node.getRight(), key);
	}
	
	public void delete(Object key) {
		if (!matchFound(root, key)) {
			System.out.println("Not found. " + key + " cannot be deleted.");
		} else {
			deletion(root, key);
			System.out.println("Found. " + key + " has been deleted.");
		}
	}
}

public class Exer6{
	public static void main(String [] args) {
		BinaryTree bt = new BinaryTree();
		
		bt.insert(4);
		bt.insert(5);
		bt.insert(6);
		bt.insert(7);
		
		bt.traverse();
		
		System.out.print("\nSearch [5]	: ");
		bt.search(5);
		
		System.out.print("\nDelete [5]	: ");
		bt.delete(5);
		bt.traverse();
		
		System.out.print("\nInsert [10]	: ");
		bt.insert(10);
		bt.traverse();
	}
}