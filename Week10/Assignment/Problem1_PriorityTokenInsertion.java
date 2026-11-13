public class Problem1_PriorityTokenInsertion {
    static class Node { int data; Node next; Node(int data) { this.data=data; } }
    static class SinglyLinkedList {
        Node head;
        void addFirst(int token) { Node n=new Node(token); n.next=head; head=n; }
        void addLast(int token) {
            Node n=new Node(token);
            if(head==null){head=n;return;}
            Node c=head; while(c.next!=null)c=c.next; c.next=n;
        }
        void insertAt(int index,int token) {
            if(index<0)throw new IndexOutOfBoundsException("Negative index");
            if(index==0){addFirst(token);return;}
            Node p=head;
            for(int i=0;i<index-1 && p!=null;i++)p=p.next;
            if(p==null)throw new IndexOutOfBoundsException("Index exceeds list size");
            Node n=new Node(token); n.next=p.next; p.next=n;
        }
        void print(){Node c=head;while(c!=null){System.out.print(c.data+" -> ");c=c.next;}System.out.println("null");}
    }
    public static void main(String[] args) {
        SinglyLinkedList t=new SinglyLinkedList();
        t.addLast(101);t.addLast(102);t.addLast(103);
        t.addFirst(100);t.addLast(104);t.insertAt(2,150);t.print();
    }
}
// addFirst O(1); addLast O(n) without a tail; insertAt O(n) traversal.
// Once the predecessor is found, the pointer update is O(1).