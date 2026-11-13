public class Problem3_ReverseTheQueue {
 static class Node{int data;Node next;Node(int d){data=d;}}
 static Node reverse(Node head){Node previous=null,current=head;while(current!=null){Node next=current.next;current.next=previous;previous=current;current=next;}return previous;}
 static Node of(int... a){Node dummy=new Node(0),t=dummy;for(int x:a){t.next=new Node(x);t=t.next;}return dummy.next;}
 static void print(Node h){while(h!=null){System.out.print(h.data+" -> ");h=h.next;}System.out.println("null");}
 public static void main(String[] args){print(reverse(of(1,2,3,4)));print(reverse(of(9)));print(reverse(null));}
}
// Time O(n), auxiliary space O(1); reverses links without allocating nodes.