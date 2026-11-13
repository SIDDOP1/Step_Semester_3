public class Problem1_PriorityTokenInsertion {
 static class Node { int data; Node next; Node(int d){data=d;} }
 static class TokenList {
  Node head;
  void addFirst(int token){Node n=new Node(token);n.next=head;head=n;}
  void addLast(int token){Node n=new Node(token);if(head==null){head=n;return;}Node c=head;while(c.next!=null)c=c.next;c.next=n;}
  void insertAt(int index,int token){
   if(index<0)throw new IndexOutOfBoundsException("Negative index");
   if(index==0){addFirst(token);return;}
   Node p=head;for(int i=0;i<index-1&&p!=null;i++)p=p.next;
   if(p==null)throw new IndexOutOfBoundsException("Index exceeds list size");
   Node n=new Node(token);n.next=p.next;p.next=n;
  }
  void print(){Node c=head;while(c!=null){System.out.print(c.data+" -> ");c=c.next;}System.out.println("null");}
 }
 public static void main(String[] args){TokenList l=new TokenList();l.addLast(101);l.addLast(102);l.addLast(103);l.addFirst(100);l.addLast(104);l.insertAt(2,150);l.print();}
}
// addFirst O(1); addLast and insertAt O(n) with head-only list; auxiliary operation space O(1).