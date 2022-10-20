class Node{
   public int value;
   public Node next;
   public Node (int value){
      this.value = value; //takes int value and turns it into something that Node can use
   }
}

abstract class List{
   abstract void addFirst(int value);
   abstract void deleteFirst();
   abstract void deleteIndex(int index);
   abstract void deleteLast();
   abstract void search(int searchKey);
   abstract void print();
}

class LinkedList extends List{
   public static Node head;
   public static int countNodes; //counts the number of nodes
   
   public void addFirst(int value){
      if (head == null){
         head = new Node (value); //creates a new Node if the head is null
      }
      Node newHead = new Node(value); //stores head Node away temporarily
      newHead.next = head; //takes value and makes it head Node
      head = newHead; //stored head Node will be the 2nd Node
      countNodes++;
   }
   
   public void deleteFirst(){
      if (head == null){
         return;
      }
      head = head.next;
      countNodes--;
   }
   
   public void deleteIndex(int index){
      Node temp = head; //stores head temporarily
      for (int i = 0; i < index - 1 && temp.next != null; i++){
         temp = temp.next; //makes the head into vice head
      }
      temp.next = temp.next.next; //the head slash vice head will be the secretary
      countNodes--;
   }
   
   public void deleteLast(){
      Node current = head; //points the head
      while (current.next.next != null){ //while the 2nd next is not null
         current = current.next; //change the pointer to the next
      }
      current.next = null; //if the 2nd next is null, then make the next one null
      countNodes--;
   }
   
   public void search(int searchKey){
      boolean found = false;
      Node current = head; //points to the head
      while (current.next != null){
         if (current.value == searchKey){
            System.out.println("Element found!");
            found = true;
         }
         current = current.next;
      }
      if (found == false){
         System.out.println("Element not found.");
      }
   }
   
   public void print(){
      Node current = head; //current pointer will point to the head
      while (current.next != null){
         System.out.print(current.value + " ");
         current = current.next; //current pointer will go to the next node
      }
   }
   
}


public class Exer2{
   public static void main (String [] args){
      LinkedList list = new LinkedList();
      
      list.addFirst(10);      
      list.addFirst(20);
      list.addFirst(30);
      list.addFirst(40);
      list.addFirst(50);
      
      System.out.println("Here is the linked list:");
      list.print();
      System.out.println("");
      
      System.out.println("\nSearching for value 10: ");
      list.search(10);
      
      System.out.println("\nSearching for value 5: ");
      list.search(5);
      
      System.out.println("\nRemoving an element from index 3 results to: ");
      list.deleteIndex(3);
      list.print();
      System.out.println("");
      
      System.out.println("\nRemoving the head results to: ");
      list.deleteFirst();
      list.print();
      System.out.println("");
      
      System.out.println("\nRemoving the tail results to: ");
      list.deleteLast();
      list.print();
      
      
     
            
      
      
   }
}