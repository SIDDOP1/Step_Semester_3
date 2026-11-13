public class Problem2_CancelledOrdersCleanup {
 static class Node{int data;Node next;Node(int d){data=d;}}
 static Node removeAll(Node head,int code){
  while(head!=null&&head.data==code)head=head.next;
  Node c=head;while(c!=null&&c.next!=null){if(c.next.data==code)c.next=c.next.next;else c=c.next;}return head;
 }
 static Node of(int... a){Node dummy=new Node(0),t=dummy;for(int x:a){t.next=new Node(x);t=t.next;}return dummy.next;}
 static void print(Node h){while(h!=null){System.out.print(h.data+" -> ");h=h.next;}System.out.println("null");}
 public static void main(String[] args){print(removeAll(of(5,3,5,8,5),5));print(removeAll(of(5,5,5),5));print(removeAll(null,5));}
}
// Time O(n); additional space O(1). All matching nodes are unlinked in place.