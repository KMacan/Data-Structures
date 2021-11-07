//Write the codes for the methods defined for Binary Tree ADT. Create a program to use the ADT.

class Node<T> {
	T value;
	Node<T> left;
	Node<T> right;
	public Node(T value){
		this.value = value;
		right = null;
		left = null;
	}
}

abstract class BinaryTreeADT<T>{
	   abstract Node<T> create();
	   abstract boolean isEmpty(Node<T> root);
	   abstract Node<T> lChild(Node<T> root);
	   abstract Node<T> rChild(Node<T> root);
	   abstract Node<T> data (Node<T> root);
	   abstract void insert(int element);
	   abstract void delete(Node<T> node);
	   abstract boolean search(Node<T> node);
	}

class BinaryTree<T> extends BinaryTreeADT<T>{
	//class variables
	public Node<T> root;
	public Node<T> leftSubtree;
	public Node<T> rightSubtree;
	public int countNodes;
	
	//constructor
	public BinaryTree() {
		countNodes = 0;
		root = null;	
	}
	
   public Node<T> create(){ //creates empty binary tree
	  Node<T> bt = new Node<T>(null);
      return bt;
   }
   public boolean isEmpty(Node<T> root){ //checks if the tree is empty
	   if (root == null) {
		   return true;
	   } else {
		   return false;
	   }
   }
   public Node<T> lChild (Node<T> root){ //returns the left subtree
	   if (isEmpty(root)) {
		   return null; 
	   }
	   Node<T> current = root;
	   current = root.left;
	   return current;
   }
   public Node<T> rChild(Node<T> root){
	   return null;
   }
   public Node<T> data (Node<T> root){
	   return null;
   }
   public void insert(int value){
	   if(root == null) {
		   root = new Node<T> (value);
	   }
	   Node<T> current = root;
	   
   }
   public void delete(Node<T> node){}
   public boolean search(Node<T> node){
	   return true;
   }
}

public class Exer7 {
	public static void main (String [] args) {
		BinaryTree tree = new BinaryTree();
		
		tree.create();
		
		System.out.println("Hatdog");
	}
}
